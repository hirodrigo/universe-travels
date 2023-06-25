package com.travels.universe.application.services;

import com.travels.universe.application.ports.DeleteTravelPlanPort;
import com.travels.universe.application.ports.RetrieveTravelPlanPort;
import com.travels.universe.application.usecases.DeleteTravelPlanUseCase;
import org.springframework.stereotype.Component;

@Component
public class DeleteTravelPlanService implements DeleteTravelPlanUseCase {

    private final RetrieveTravelPlanPort retrieveTravelPlanPort;
    private final DeleteTravelPlanPort deleteTravelPlanPort;

    public DeleteTravelPlanService(RetrieveTravelPlanPort retrieveTravelPlanPort,
                                   DeleteTravelPlanPort deleteTravelPlanPort) {
        this.retrieveTravelPlanPort = retrieveTravelPlanPort;
        this.deleteTravelPlanPort = deleteTravelPlanPort;
    }

    @Override
    public void deleteTravelPlan(Integer travelPlanId) {
        final var travelPlan = retrieveTravelPlanPort.retrieveTravelPlan(travelPlanId);
        deleteTravelPlanPort.deleteTravelPlan(travelPlan);
    }
}
