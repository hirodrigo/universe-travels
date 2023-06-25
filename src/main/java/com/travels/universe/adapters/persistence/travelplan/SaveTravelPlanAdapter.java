package com.travels.universe.adapters.persistence.travelplan;

import com.travels.universe.adapters.persistence.travelplan.mapper.TravelPlanMapper;
import com.travels.universe.adapters.persistence.travelplan.repository.TravelPlanRepository;
import com.travels.universe.application.domain.TravelPlan;
import com.travels.universe.application.ports.SaveTravelPlanPort;
import org.springframework.stereotype.Component;

@Component
public class SaveTravelPlanAdapter implements SaveTravelPlanPort {

    private final TravelPlanRepository travelPlanRepository;

    public SaveTravelPlanAdapter(TravelPlanRepository travelPlanRepository) {
        this.travelPlanRepository = travelPlanRepository;
    }

    @Override
    public TravelPlan saveTravelPlan(TravelPlan travelPlan) {
        return TravelPlanMapper.toDomain(
                travelPlanRepository.save(
                        TravelPlanMapper.toAdapter(travelPlan)));
    }
}
