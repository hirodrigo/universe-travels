package com.travels.universe.adapters.http.location.information;

import com.travels.universe.adapters.http.location.information.dto.in.LocationInformationInDto;
import com.travels.universe.adapters.http.location.information.mapper.LocationInformationMapper;
import com.travels.universe.application.domain.TravelStop;
import com.travels.universe.application.exception.SearchLocationInformationException;
import com.travels.universe.application.ports.RetrieveTravelStopInformationPort;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LocationInformationAdapter implements RetrieveTravelStopInformationPort {

    private final RickAndMortyClient rickAndMortyClient;

    public LocationInformationAdapter(RickAndMortyClient rickAndMortyClient) {
        this.rickAndMortyClient = rickAndMortyClient;
    }

    @Override
    public List<TravelStop> retrieveLocationInformation(List<Integer> locationsIds) {
        try {

            return Optional.of(rickAndMortyClient
                    .getLocationInformation(new LocationInformationInDto(locationsIds)))
                    .map(response -> response.getData().getLocationsByIds().stream()
                            .map(LocationInformationMapper::toDomain).collect(Collectors.toList()))
                    .orElse(Collections.emptyList());
        } catch (Exception e) {
            throw new SearchLocationInformationException(e.getMessage());
        }
    }
}
