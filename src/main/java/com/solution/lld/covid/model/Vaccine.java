package com.solution.lld.covid.model;

import com.solution.lld.covid.types.VaccineStatus;
import com.solution.lld.covid.types.VaccineType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Vaccine {

    private String id;
    private VaccineType vaccineType;
    private VaccineStatus vaccineStatus;

    public Vaccine(VaccineType vaccineType){
        this.id = UUID.randomUUID().toString();
        this.vaccineType = vaccineType;
        this.vaccineStatus = VaccineStatus.AVAILABLE;
    }
}
