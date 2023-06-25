package com.travels.universe.adapters.web.travelplan.mapper;

import com.travels.universe.adapters.web.travelplan.dto.out.TravelPlanOutDto;
import com.travels.universe.application.domain.TravelPlan;
import org.springframework.stereotype.Component;

@Component
public class NormalTravelPlanMapper implements TravelPlanMapper<TravelPlanOutDto> {

    @Override
    public TravelPlanOutDto toAdapter(TravelPlan travelPlan) {
        return new TravelPlanOutDto(travelPlan.getId(), travelPlan.getTravelStopsIds());
    }
}
