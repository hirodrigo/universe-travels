package com.travels.universe.adapters.web.travelplan.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExpandedTravelPlanOutDto extends TravelPlanOutDto {

    @JsonProperty("travel_stops")
    private List<TravelStopOutDto> travelStops;

    public ExpandedTravelPlanOutDto(Integer travelPlanId) {
        super(travelPlanId);
    }

    public ExpandedTravelPlanOutDto(Integer travelPlanId, List<TravelStopOutDto> travelStops) {
        super(travelPlanId);
        this.travelStops = travelStops;
    }

    public static class TravelStopOutDto {
        private final Integer id;
        private final String name;
        private final String type;
        private final String dimension;

        public TravelStopOutDto(Integer id, String name, String type, String dimension) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.dimension = dimension;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getDimension() {
            return dimension;
        }
    }

    @Override
    public Integer getTravelPlanId() {
        return travelPlanId;
    }

    @Override
    public void setTravelPlanId(Integer travelPlanId) {
        this.travelPlanId = travelPlanId;
    }

    @Override
    public List<?> getTravelStops() {
        return travelStops;
    }

    @Override
    public String toString() {
        return "TravelPlanOutDto{" +
                "travelPlanId=" + travelPlanId +
                ", travelStops=" + travelStops +
                '}';
    }
}
