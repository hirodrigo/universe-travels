package com.travels.universe.adapters.web.location.images.mapper;

import com.travels.universe.adapters.web.location.images.dto.out.TravelStopOutDto;
import com.travels.universe.application.domain.TravelStop;

public class TravelStopMapper {

    public static TravelStopOutDto toAdapter(TravelStop travelStop) {
        return new TravelStopOutDto(travelStop.getId(), travelStop.getName(), travelStop.getImages());
    }
}
