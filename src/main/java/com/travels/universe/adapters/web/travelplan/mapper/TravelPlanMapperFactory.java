package com.travels.universe.adapters.web.travelplan.mapper;

import com.travels.universe.adapters.web.travelplan.RetrieveOptionsEnum;
import com.travels.universe.adapters.web.travelplan.dto.out.TravelPlanOutDto;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class TravelPlanMapperFactory {

    private static final Map<RetrieveOptionsEnum, TravelPlanMapper<? extends TravelPlanOutDto>> implementation = new EnumMap<>(RetrieveOptionsEnum.class);

    public TravelPlanMapperFactory(NormalTravelPlanMapper normalTravelPlanMapper,
                                   OptimizedTravelPlanMapper optimizedTravelPlanMapper,
                                   ExpandedOptimizedTravelPlanMapper expandedOptimizedTravelPlanMapper) {
        implementation.put(RetrieveOptionsEnum.NORMAL, normalTravelPlanMapper);
        implementation.put(RetrieveOptionsEnum.EXPAND, expandedOptimizedTravelPlanMapper);
        implementation.put(RetrieveOptionsEnum.OPTIMIZE, optimizedTravelPlanMapper);
        implementation.put(RetrieveOptionsEnum.EXPAND_OPTIMIZE, expandedOptimizedTravelPlanMapper);
    }

    public TravelPlanMapper<? extends TravelPlanOutDto> getImplementation(RetrieveOptionsEnum retrieveOptionsEnum) {
        return implementation.getOrDefault(retrieveOptionsEnum, new NormalTravelPlanMapper());
    }
}
