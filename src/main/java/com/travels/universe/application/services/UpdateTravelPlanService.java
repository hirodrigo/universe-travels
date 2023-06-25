package com.travels.universe.application.services;

import com.travels.universe.application.domain.TravelPlan;
import com.travels.universe.application.ports.SaveTravelPlanPort;
import com.travels.universe.application.ports.RetrieveTravelPlanPort;
import com.travels.universe.application.usecases.UpdateTravelPlanUseCase;
import org.springframework.stereotype.Component;

@Component
public class UpdateTravelPlanService implements UpdateTravelPlanUseCase {

    private final RetrieveTravelPlanPort retrieveTravelPlanPort;
    private final SaveTravelPlanPort saveTravelPlanPort;

    public UpdateTravelPlanService(RetrieveTravelPlanPort retrieveTravelPlanPort,
                                   SaveTravelPlanPort saveTravelPlanPort) {
        this.retrieveTravelPlanPort = retrieveTravelPlanPort;
        this.saveTravelPlanPort = saveTravelPlanPort;
    }

    @Override
    public TravelPlan updateTravelPlan(Integer travelPlanId, TravelPlan updatedTravelPlan) {
        final var existingTravelPlan = retrieveTravelPlanPort.retrieveTravelPlan(travelPlanId);
        existingTravelPlan.setTravelStopsIds(updatedTravelPlan.getTravelStopsIds());
        return saveTravelPlanPort.saveTravelPlan(existingTravelPlan);
    }
}
