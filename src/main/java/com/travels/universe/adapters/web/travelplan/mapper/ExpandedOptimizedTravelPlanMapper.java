package com.travels.universe.adapters.web.travelplan.mapper;

import com.travels.universe.adapters.web.travelplan.dto.out.ExpandedTravelPlanOutDto;
import com.travels.universe.application.domain.TravelPlan;
import com.travels.universe.application.domain.TravelStop;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ExpandedOptimizedTravelPlanMapper implements TravelPlanMapper<ExpandedTravelPlanOutDto> {

    @Override
    public ExpandedTravelPlanOutDto toAdapter(TravelPlan travelPlan) {
        return new ExpandedTravelPlanOutDto(travelPlan.getId(), travelPlan.getTravelStops()
                .stream().map(this::toAdapter).collect(Collectors.toList()));
    }

    private ExpandedTravelPlanOutDto.TravelStopOutDto toAdapter(TravelStop travelStop) {
        return new ExpandedTravelPlanOutDto.TravelStopOutDto(travelStop.getId(),
                travelStop.getName(),
                travelStop.getType(),
                travelStop.getDimension());
    }
}
