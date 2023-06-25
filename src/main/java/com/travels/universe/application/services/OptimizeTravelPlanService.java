package com.travels.universe.application.services;

import com.travels.universe.application.domain.TravelStop;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
public class OptimizeTravelPlanService {

    public void optimize(List<TravelStop> travelStops) {
        final var dimensionPopularity = new HashMap<String, Integer>();
        travelStops.forEach(stop ->
                Optional.ofNullable(dimensionPopularity.get(stop.getDimension()))
                        .ifPresentOrElse(stopList -> dimensionPopularity.put(stop.getDimension(), Math.addExact(stopList, stop.getPopularity())),
                                () -> dimensionPopularity.put(stop.getDimension(), stop.getPopularity())));

        travelStops.sort((stop1, stop2) -> {
            if (dimensionPopularity.get(stop1.getDimension()) > dimensionPopularity.get(stop2.getDimension())) {
                return 1;
            } else if (dimensionPopularity.get(stop1.getDimension()) < dimensionPopularity.get(stop2.getDimension())) {
                return -1;
            } else if (stop1.getDimension().compareTo(stop2.getDimension()) == 0) {
                if (stop1.getPopularity() > stop2.getPopularity()) {
                    return 1;
                } else if (stop1.getPopularity() < stop2.getPopularity()) {
                    return -1;
                } else {
                    return stop1.getName().compareTo(stop2.getName());
                }
            }
            return stop1.getDimension().compareTo(stop2.getDimension());
        });
    }
}
    