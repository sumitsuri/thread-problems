package com.solution.lld.covid.dao;

import com.google.common.collect.Maps;
import com.solution.lld.covid.model.Booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingDao {

    private Map<String, Booking> bookings;
    private Map<String, List<String>> userBookings;

    //see if below ds is more suitable as booking will always be associated with user
    //private Map<String, Map<String,Booking>> bookings;

    public BookingDao(){
        this.bookings = Maps.newConcurrentMap();
        this.userBookings = Maps.newConcurrentMap();
    }

    public String create(Booking booking){
        this.bookings.put(booking.getId(), booking);
        this.userBookings.putIfAbsent(booking.getBookedByUser().getId(), new ArrayList<>());
        this.userBookings.get(booking.getBookedByUser().getId()).add(booking.getId());
        return booking.getId();
    }

    public Booking get(String id){
        return this.bookings.get(id);
    }

    public List<Booking> getAll(){
        return Collections.unmodifiableList(bookings.values().stream().collect(Collectors.toList()));
    }

    public void update(Booking booking){
        synchronized (booking.getId()){
            this.bookings.put(booking.getId(), booking);
        }
    }

    public Map<String, List<String>> getUserBookings() {
        return userBookings;
    }

}
