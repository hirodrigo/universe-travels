package com.travels.universe.adapters.web.travelplan.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TravelPlanOutDto {

    @JsonProperty("id")
    protected Integer travelPlanId;

    @JsonProperty("travel_stops")
    private List<Integer> travelStops;

    public TravelPlanOutDto() {
    }

    public TravelPlanOutDto(Integer travelPlanId) {
        this.travelPlanId = travelPlanId;
    }

    public TravelPlanOutDto(Integer travelPlanId, List<Integer> travelStops) {
        this.travelPlanId = travelPlanId;
        this.travelStops = travelStops;
    }

    public Integer getTravelPlanId() {
        return travelPlanId;
    }

    public void setTravelPlanId(Integer travelPlanId) {
        this.travelPlanId = travelPlanId;
    }

    public List<?> getTravelStops() {
        return travelStops;
    }

    public void setTravelStops(List<Integer> travelStops) {
        this.travelStops = travelStops;
    }

    @Override
    public String toString() {
        return "TravelPlanOutDto{" +
                "travelPlanId=" + travelPlanId +
                ", travelStops=" + travelStops +
                '}';
    }
}
