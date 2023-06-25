package com.travels.universe.application.ports;

import com.travels.universe.application.domain.TravelPlan;

public interface SaveTravelPlanPort {

    TravelPlan saveTravelPlan(TravelPlan travelPlan);
}
