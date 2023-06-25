package com.travels.universe.adapters.persistence.travelplan.repository;

import com.travels.universe.adapters.persistence.travelplan.entity.TravelPlanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TravelPlanRepository extends CrudRepository<TravelPlanEntity, Integer> {
}
