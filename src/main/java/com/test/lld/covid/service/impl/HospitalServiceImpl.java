package com.test.lld.covid.service.impl;

import com.test.lld.covid.dao.HospitalDao;
import com.test.lld.covid.model.Hospital;
import com.test.lld.covid.service.HospitalService;

import java.util.*;
import java.util.stream.Collectors;

public class HospitalServiceImpl implements HospitalService {

    private HospitalDao hospitalDao;

    public HospitalServiceImpl(){
        this.hospitalDao = new HospitalDao();
    }

    @Override
    public void create(Hospital hospital) {
    this.hospitalDao.create(hospital);
    }

    @Override
    public Hospital get(String id) {
        return this.hospitalDao.get(id);
    }

    @Override
    public List<Hospital> getAll() {
        return this.getAll();
    }

    @Override
    public void update(String id, Hospital hospital) {
        this.hospitalDao.update(hospital);
    }

    @Override
    public List<Hospital> getAllByZip(String zipCode) {
        List<String> hospitalNames = hospitalDao.getZipCodeBasedHospitals().get(zipCode);
        List<Hospital> allHospitals = hospitalDao.getAll();
        return Collections.unmodifiableList(allHospitals
                .stream()
                .filter(hospital -> hospitalNames.contains(hospital.getName()))
                .collect(Collectors.toList()));
    }

    @Override
    public Map<String, List<Hospital>> getAllWithZipCode() {
        Map<String, List<String>> zipBasedHospitals = hospitalDao.getZipCodeBasedHospitals();
        Map<String, List<Hospital>> zipBasedHospitalResults = new HashMap<>();
        for(String zip : zipBasedHospitals.keySet()){
            List<Hospital> hospitals = new ArrayList<>();
            for(String hospitalName : zipBasedHospitals.get(zip)){
                hospitals.add(get(hospitalName));
            }
            zipBasedHospitalResults.put(zip, hospitals);
        }
        return zipBasedHospitalResults;
    }
}
