package com.travels.universe.application.ports;

import com.travels.universe.application.domain.TravelStop;

import java.util.List;

public interface RetrieveTravelStopInformationPort {

    List<TravelStop> retrieveLocationInformation(List<Integer> locationsIds);
}
