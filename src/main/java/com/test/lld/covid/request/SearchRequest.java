package com.test.lld.covid.request;

import com.test.lld.covid.types.VaccineType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchRequest {

    private String zipCode;
    private String hospitalName;
    private VaccineType vaccineType;
}
