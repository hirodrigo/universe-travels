package com.travels.universe.application.ports;

import com.travels.universe.application.domain.TravelPlan;

import java.util.List;

public interface RetrieveTravelPlanPort {

    TravelPlan retrieveTravelPlan(Integer travelPlanId);

    List<TravelPlan> retrieveAllTravelPlans();
}
