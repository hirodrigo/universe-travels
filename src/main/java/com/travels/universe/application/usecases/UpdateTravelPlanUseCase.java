package com.travels.universe.application.usecases;

import com.travels.universe.application.domain.TravelPlan;

public interface UpdateTravelPlanUseCase {

    TravelPlan updateTravelPlan(Integer travelPlanId, TravelPlan travelPlan);
}
