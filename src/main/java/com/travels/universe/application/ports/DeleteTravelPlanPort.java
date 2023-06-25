package com.travels.universe.application.ports;

import com.travels.universe.application.domain.TravelPlan;

public interface DeleteTravelPlanPort {

    void deleteTravelPlan(TravelPlan travelPlan);
}
