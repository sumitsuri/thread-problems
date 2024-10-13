package com.solution.lld.covid.model;

import com.solution.lld.covid.types.VaccineType;
import lombok.Builder;

import java.util.List;

@Builder
public class VaccinationCertificate {

    private String name;
    private VaccineType vaccineType;
    private List<Long> vaccineDates;
}
