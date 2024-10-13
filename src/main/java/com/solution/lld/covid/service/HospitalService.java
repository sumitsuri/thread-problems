package com.solution.lld.covid.service;

import com.solution.lld.covid.model.Hospital;

import java.util.List;
import java.util.Map;

public interface HospitalService {

    public void create(Hospital hospital);

    public Hospital get(String id);

    public List<Hospital> getAll();

    public void update(String id, Hospital hospital);

    public List<Hospital> getAllByZip(String zipCode);

    public Map<String, List<Hospital>> getAllWithZipCode();
}
