package com.travels.universe.adapters.web.travelplan.mapper;

import com.travels.universe.adapters.web.travelplan.dto.in.TravelPlanInDto;
import com.travels.universe.adapters.web.travelplan.dto.out.TravelPlanOutDto;
import com.travels.universe.application.domain.TravelPlan;

public interface TravelPlanMapper<T extends TravelPlanOutDto> {

    static TravelPlan toDomain(TravelPlanInDto travelPlanInDto) {
        return new TravelPlan(travelPlanInDto.getTravelStops());
    }

    T toAdapter(TravelPlan travelPlan);
}
