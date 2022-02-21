package com.test.lld.covid.service.impl;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import com.test.lld.covid.constant.AppConstant;
import com.test.lld.covid.dao.BookingDao;
import com.test.lld.covid.model.*;
import com.test.lld.covid.request.BookingRequest;
import com.test.lld.covid.request.SearchRequest;
import com.test.lld.covid.response.SearchResponse;
import com.test.lld.covid.service.BookingService;
import com.test.lld.covid.service.HospitalService;
import com.test.lld.covid.service.UserService;
import com.test.lld.covid.types.VaccineStatus;
import com.test.lld.covid.types.VaccineType;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    private BookingDao bookingDao;
    private UserService userService;
    private HospitalService hospitalService;

    public BookingServiceImpl(UserService userService, HospitalService hospitalService){
        this.bookingDao = new BookingDao();
        this.userService = userService;
        this.hospitalService = hospitalService;
    }



    @Override
    public Booking get(String id) {
        return this.bookingDao.get(id);
    }

    @Override
    public List<Booking> getAll() {
        return this.getAll();
    }

    @Override
    public void update(String id, BookingRequest bookingRequest) {
    this.bookingDao.update(null);
    }

    @Override
    public synchronized String createBooking(BookingRequest bookingRequest) {
        //Create booking
        //User bookedByUser, Vaccine vaccine, Slot slot, Hospital hospital, List<String> bookedFor

        Hospital hospital = hospitalService.get(bookingRequest.getHospitalName());
        AtomicInteger slotCount = hospital.getVaccines().get(bookingRequest.getSlot()).get(bookingRequest.getVaccineType());
        slotCount.compareAndSet(slotCount.get(), slotCount.get()-1);
        hospital.getVaccines().get(bookingRequest.getSlot()).put(bookingRequest.getVaccineType(), slotCount);
        hospitalService.update(hospital.getName(), hospital);

        User user = userService.get(bookingRequest.getBookedBy());
        Booking booking = new Booking(user, bookingRequest.getVaccineType(), bookingRequest.getSlot(), hospital, bookingRequest.getBookedForIds());

        return this.bookingDao.create(booking);

    }

    @Override
    public synchronized void markBookingAsComplete(boolean isFirstDose, String bookingId) {
        Booking booking = bookingDao.get(bookingId);
        if(isFirstDose){
            booking.setVaccineStatus(VaccineStatus.FIRST_DOSE_COMPLETED);
            booking.setNextVaccinationDate(booking.getVaccineType().getNextAvailability());
        }else{
            booking.setVaccineStatus(VaccineStatus.SECOND_DOSE_COMPLETED);
        }
        bookingDao.update(booking);

        //Increament slot count.
        Hospital hospital = booking.getHospital();
        AtomicInteger slotCount = hospital.getVaccines().get(booking.getSlot()).get(booking.getVaccineType());
        slotCount.compareAndSet(slotCount.get(), slotCount.get()+1);
        hospital.getVaccines().get(booking.getSlot()).put(booking.getVaccineType(), slotCount);
        hospitalService.update(hospital.getName(), hospital);
    }

    @Override
    public SearchResponse getAllAvailableSlots(SearchRequest searchRequest) {
        String zipCode = searchRequest.getZipCode();
        String hospitalName = searchRequest.getHospitalName();
        VaccineType vaccineType = searchRequest.getVaccineType();

        if(StringUtils.isNotBlank(zipCode)
                && (vaccineType != null)){
           return getAllAvailableSlots(zipCode, vaccineType);
        }else if(StringUtils.isNotBlank(hospitalName)
                && (vaccineType != null)){
           return new SearchResponse(getAvailableSlots(hospitalName, vaccineType));
        }
        return getAllAvailableSlots(zipCode);
    }


    public SearchResponse getAllAvailableSlots(String zipCode){
        if(StringUtils.isBlank(zipCode)){
            throw new RuntimeException(String.format("invalid zipcode: [%s]", zipCode));
        }
        List<Hospital> hospitals = this.hospitalService.getAllByZip(zipCode);
        List<SearchResponse.VaccineSlot> vaccineSlots = new ArrayList<>();
        for(VaccineType vaccineType : VaccineType.values()){
            for(Hospital hospital : hospitals){
                vaccineSlots.addAll(getAvailableSlots(hospital.getName(), vaccineType));
            }
        }
        return new SearchResponse(vaccineSlots);

    }

    public SearchResponse getAllAvailableSlots(String zipCode, VaccineType vaccineType){
        if(StringUtils.isBlank(zipCode)){
            throw new RuntimeException(String.format("invalid zipcode: [%s]", zipCode));
        }
        List<Hospital> hospitals = this.hospitalService.getAllByZip(zipCode);
        List<SearchResponse.VaccineSlot> vaccineSlots = new ArrayList<>();
        for(Hospital hospital : hospitals){
            vaccineSlots.addAll(getAvailableSlots(hospital.getName(), vaccineType));
        }
        return new SearchResponse(vaccineSlots);

    }


    public List<SearchResponse.VaccineSlot> getAvailableSlots(String hospitalName, VaccineType vaccineType){
        Hospital hospital = hospitalService.get(hospitalName);
        Map<Slot, Map<VaccineType, AtomicInteger>> vaccines = hospital.getVaccines();

        List<SearchResponse.VaccineSlot> vaccineSlots = Lists.newArrayList();
        for(Slot slot : vaccines.keySet()){
            Map<Slot, Map<VaccineType, AtomicInteger>> hospitalAvailableSlots = new HashMap<>();
            Map<VaccineType, AtomicInteger> vaccineTypeListMap = vaccines.get(slot);
            Map<VaccineType, AtomicInteger> availableVaccines = new HashMap<>();
            if(vaccineTypeListMap.get(vaccineType).get() > 0){
                availableVaccines.put(vaccineType, vaccineTypeListMap.get(vaccineType));
                hospitalAvailableSlots.put(slot, availableVaccines);
            }else{
                //update slot as full
            }
            SearchResponse.VaccineSlot vaccineSlot = SearchResponse.ofVaccineSlot(hospital.getName(), hospitalAvailableSlots);
            vaccineSlots.add(vaccineSlot);
        }
        return vaccineSlots;
    }
}
