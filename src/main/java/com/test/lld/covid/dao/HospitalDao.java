package com.test.lld.covid.dao;

import com.google.common.collect.Maps;
import com.test.lld.covid.model.Hospital;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class HospitalDao {

    private Map<String, Hospital> hospitals;
    private Map<String, List<String>> zipCodeBasedHospitals;

    public HospitalDao(){
        this.hospitals = Maps.newConcurrentMap();
        this.zipCodeBasedHospitals = Maps.newConcurrentMap();
    }

    public void create(Hospital hospital){
        this.hospitals.put(hospital.getName(), hospital);
        String zipCode = hospital.getAddress().getZipCode();
        List<String> hospitals = zipCodeBasedHospitals.get(zipCode);
        if(CollectionUtils.isEmpty(hospitals)){
            hospitals = new ArrayList<>();
        }
        hospitals.add(hospital.getName());
        zipCodeBasedHospitals.put(zipCode, hospitals);
    }

    public void remove(String name){
        Hospital hospital = get(name);
        synchronized (name){
            this.hospitals.remove(name);
            zipCodeBasedHospitals.get(hospital.getAddress().getZipCode()).remove(name);
        }
    }

    public Hospital get(String name){
        return this.hospitals.get(name);
    }

    public List<Hospital> getAll(){
        return Collections.unmodifiableList(hospitals.values().stream().collect(Collectors.toList()));
    }

    public void update(Hospital hospital){
        synchronized (hospital.getName()){
            this.hospitals.put(hospital.getName(), hospital);
        }
    }

    public Map<String, List<String>> getZipCodeBasedHospitals(){
        return this.zipCodeBasedHospitals;
    }
}
