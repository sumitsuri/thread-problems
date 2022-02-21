package com.test.lld.covid.request;

import com.test.lld.covid.model.Address;
import com.test.lld.covid.model.Slot;
import com.test.lld.covid.model.Vaccine;
import lombok.Builder;

import java.util.List;
import java.util.Map;

/**
 *     private String id;
 *     private String name;
 *     private Address address;
 *     private Map<String, List<Vaccine>> vaccines;
 */
@Builder
public class HospitalRequest {

    private String name;
    private Address address;
    private Map<String, List<Vaccine>> vaccines;
}
