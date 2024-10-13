package com.solution.lld.covid.types;

import java.util.Calendar;

public enum VaccineType {
    COVAXIN, COVISHIELD;

    public long getNextAvailability(){
        Calendar cal = Calendar.getInstance();

        switch(this){
            case COVAXIN:
                cal.add(Calendar.MONTH, 1);
                return cal.getTimeInMillis();
            case COVISHIELD:
                cal.add(Calendar.MONTH, 3);
                return cal.getTimeInMillis();
            default:
                throw new RuntimeException(String.format("vaccine-type [%s] is not supported", this));
        }
    }
}
