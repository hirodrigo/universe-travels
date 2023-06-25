package com.travels.universe.application.domain;

import java.util.List;

public class TravelPlan {

    protected Integer id;
    private List<Integer> travelStopsIds;
    private List<TravelStop> travelStops;

    public TravelPlan(Integer id) {
        this.id = id;
    }

    public TravelPlan(Integer id, List<Integer> travelStopsIds) {
        this.id = id;
        this.travelStopsIds = travelStopsIds;
    }

    public TravelPlan(List<Integer> travelStopsIds) {
        this.travelStopsIds = travelStopsIds;
    }

    public Integer getId() {
        return id;
    }

    public List<Integer> getTravelStopsIds() {
        return travelStopsIds;
    }

    public void setTravelStopsIds(List<Integer> travelStopsIds) {
        this.travelStopsIds = travelStopsIds;
    }

    public List<TravelStop> getTravelStops() {
        return travelStops;
    }

    public void setTravelStops(List<TravelStop> travelStops) {
        this.travelStops = travelStops;
    }

    @Override
    public String toString() {
        return "TravelPlan{" +
                "id=" + id +
                ", travelStops=" + travelStopsIds +
                '}';
    }
}
