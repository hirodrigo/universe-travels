package com.travels.universe.adapters.persistence.travelplan;

import com.travels.universe.adapters.persistence.travelplan.mapper.TravelPlanMapper;
import com.travels.universe.adapters.persistence.travelplan.repository.TravelPlanRepository;
import com.travels.universe.application.domain.TravelPlan;
import com.travels.universe.application.ports.DeleteTravelPlanPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteTravelPlanAdapter implements DeleteTravelPlanPort {

    private final TravelPlanRepository travelPlanRepository;

    public DeleteTravelPlanAdapter(TravelPlanRepository travelPlanRepository) {
        this.travelPlanRepository = travelPlanRepository;
    }

    @Override
    public void deleteTravelPlan(TravelPlan travelPlan) {
        travelPlanRepository.delete(TravelPlanMapper.toAdapter(travelPlan));
    }
}
