package com.travels.universe.application.usecases;

import com.travels.universe.application.domain.TravelPlan;

import java.util.List;

public interface RetrieveTravelPlansUseCase {

    TravelPlan retrieveTravelPlan(Integer travelPlanId, boolean optimize, boolean expand);

    List<TravelPlan> retrieveAllTravelPlans(boolean optimize, boolean expand);
}
