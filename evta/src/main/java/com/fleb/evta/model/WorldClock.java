package com.fleb.evta.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WorldClock {
    private String currentDateTime;
    private String utcOffset;
    private Boolean isDayLightSavingsTime;
    private String dayOfTheWeek;
    private String timeZoneName;
    private Long currentFileTime;
    private String ordinalDate;
    private String serviceResponse;

}
