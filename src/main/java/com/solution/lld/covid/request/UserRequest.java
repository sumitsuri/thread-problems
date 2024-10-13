package com.solution.lld.covid.request;

import com.solution.lld.covid.model.Address;
import lombok.Builder;

/**
 *     private String id;
 *     private String name;
 *     private Address address;
 *     private Map<String, List<Vaccine>> vaccines;
 */
@Builder
public class UserRequest {

    private String name;
    private String mobileNumber;
    private String email;
    private Address address;
}
