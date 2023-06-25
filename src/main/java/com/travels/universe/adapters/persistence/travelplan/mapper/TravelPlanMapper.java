package com.travels.universe.adapters.persistence.travelplan.mapper;

import com.travels.universe.adapters.persistence.travelplan.entity.TravelPlanEntity;
import com.travels.universe.application.domain.TravelPlan;

public class TravelPlanMapper {

    private TravelPlanMapper() {
    }

    public static TravelPlanEntity toAdapter(TravelPlan travelPlan) {
        return new TravelPlanEntity(travelPlan.getId(), travelPlan.getTravelStopsIds());
    }

    public static TravelPlan toDomain(TravelPlanEntity travelPlanEntity) {
        return new TravelPlan(travelPlanEntity.getId(), travelPlanEntity.getTravelStops());
    }
}
