package com.travels.universe.application.services;

import com.travels.universe.application.domain.TravelPlan;
import com.travels.universe.application.ports.RetrieveTravelPlanPort;
import com.travels.universe.application.ports.RetrieveTravelStopInformationPort;
import com.travels.universe.application.usecases.RetrieveTravelPlansUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetrieveTravelPlansService implements RetrieveTravelPlansUseCase {

    private final RetrieveTravelPlanPort retrieveTravelPlanPort;
    private final RetrieveTravelStopInformationPort retrieveTravelStopInformationPort;
    private final OptimizeTravelPlanService optimizeTravelPlanService;

    public RetrieveTravelPlansService(RetrieveTravelPlanPort retrieveTravelPlanPort,
                                      RetrieveTravelStopInformationPort retrieveTravelStopInformationPort,
                                      OptimizeTravelPlanService optimizeTravelPlanService) {
        this.retrieveTravelPlanPort = retrieveTravelPlanPort;
        this.retrieveTravelStopInformationPort = retrieveTravelStopInformationPort;
        this.optimizeTravelPlanService = optimizeTravelPlanService;
    }

    @Override
    public TravelPlan retrieveTravelPlan(Integer travelPlanId, boolean optimize, boolean expand) {
        final var travelPlan = retrieveTravelPlanPort.retrieveTravelPlan(travelPlanId);

        if (optimize || expand) {
            optimizeAndExpandTravelPlan(optimize, travelPlan);
        }
        return travelPlan;
    }

    @Override
    public List<TravelPlan> retrieveAllTravelPlans(boolean optimize, boolean expand) {
        final var travelPlans = retrieveTravelPlanPort.retrieveAllTravelPlans();

        if (optimize || expand) {
            travelPlans.forEach(travelPlan -> optimizeAndExpandTravelPlan(optimize, travelPlan));
        }

        return travelPlans;
    }

    private void optimizeAndExpandTravelPlan(boolean optimize, TravelPlan plan) {
        plan.setTravelStops(retrieveTravelStopInformationPort.retrieveLocationInformation(plan.getTravelStopsIds()));
        if (optimize) {
            optimizeTravelPlanService.optimize(plan.getTravelStops());
        }
    }
}
