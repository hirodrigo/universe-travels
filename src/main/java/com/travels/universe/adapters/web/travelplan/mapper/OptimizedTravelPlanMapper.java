package com.travels.universe.adapters.web.travelplan.mapper;

import com.travels.universe.adapters.web.travelplan.dto.out.TravelPlanOutDto;
import com.travels.universe.application.domain.TravelPlan;
import com.travels.universe.application.domain.TravelStop;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OptimizedTravelPlanMapper implements TravelPlanMapper<TravelPlanOutDto> {

    @Override
    public TravelPlanOutDto toAdapter(TravelPlan travelPlan) {
        return new TravelPlanOutDto(travelPlan.getId(), travelPlan.getTravelStops()
                .stream().map(TravelStop::getId).collect(Collectors.toList()));
    }
}
