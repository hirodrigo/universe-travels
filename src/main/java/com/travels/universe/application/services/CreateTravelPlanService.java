package com.travels.universe.application.services;

import com.travels.universe.application.domain.TravelPlan;
import com.travels.universe.application.ports.SaveTravelPlanPort;
import com.travels.universe.application.usecases.CreateTravelPlanUseCase;
import org.springframework.stereotype.Component;

@Component
public class CreateTravelPlanService implements CreateTravelPlanUseCase {

    private final SaveTravelPlanPort saveTravelPlanPort;

    public CreateTravelPlanService(SaveTravelPlanPort saveTravelPlanPort) {
        this.saveTravelPlanPort = saveTravelPlanPort;
    }

    @Override
    public TravelPlan createTravelPlan(TravelPlan travelPlan) {
        return saveTravelPlanPort.saveTravelPlan(travelPlan);
    }
}
