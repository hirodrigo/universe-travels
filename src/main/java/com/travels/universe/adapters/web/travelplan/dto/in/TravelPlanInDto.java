package com.travels.universe.adapters.web.travelplan.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class TravelPlanInDto {

    @Valid
    @NotEmpty
    @JsonProperty("travel_stops")
    private List<@Min(1) @Max(126) Integer> travelStops;

    public TravelPlanInDto() {
    }

    public TravelPlanInDto(List<Integer> travelStops) {
        this.travelStops = travelStops;
    }

    public List<Integer> getTravelStops() {
        return travelStops;
    }

    @Override
    public String toString() {
        return "TravelPlanInDto{" +
                "travelStops=" + travelStops +
                '}';
    }
}
