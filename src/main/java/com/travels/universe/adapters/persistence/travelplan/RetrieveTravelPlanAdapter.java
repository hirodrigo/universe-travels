package com.travels.universe.adapters.persistence.travelplan;

import com.travels.universe.adapters.persistence.travelplan.mapper.TravelPlanMapper;
import com.travels.universe.adapters.persistence.travelplan.repository.TravelPlanRepository;
import com.travels.universe.application.domain.TravelPlan;
import com.travels.universe.application.exception.TravelPlanNotFoundException;
import com.travels.universe.application.ports.RetrieveTravelPlanPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class RetrieveTravelPlanAdapter implements RetrieveTravelPlanPort {

    private final TravelPlanRepository travelPlanRepository;

    public RetrieveTravelPlanAdapter(TravelPlanRepository travelPlanRepository) {
        this.travelPlanRepository = travelPlanRepository;
    }

    @Override
    public TravelPlan retrieveTravelPlan(Integer travelPlanId) {
        return travelPlanRepository.findById(travelPlanId)
                .map(TravelPlanMapper::toDomain)
                .orElseThrow(() ->
                        new TravelPlanNotFoundException(String.format("Travel Plan %d not found", travelPlanId)));
    }

    @Override
    public List<TravelPlan> retrieveAllTravelPlans() {
        return StreamSupport.stream(travelPlanRepository.findAll().spliterator(), false)
                .map(TravelPlanMapper::toDomain)
                .collect(Collectors.toList());
    }
}
