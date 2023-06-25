package com.travels.universe.application.services;

import com.travels.universe.application.domain.TravelStop;
import com.travels.universe.application.exception.SearchLocationImagesException;
import com.travels.universe.application.ports.RetrieveLocationImagesPort;
import com.travels.universe.application.ports.RetrieveTravelStopInformationPort;
import com.travels.universe.application.usecases.RetrieveLocationImagesUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetrieveLocationImagesService implements RetrieveLocationImagesUseCase {

    private final RetrieveTravelStopInformationPort retrieveTravelStopInformationPort;
    private final RetrieveLocationImagesPort retrieveLocationImagesPort;

    public RetrieveLocationImagesService(RetrieveTravelStopInformationPort retrieveTravelStopInformationPort,
                                         RetrieveLocationImagesPort retrieveLocationImagesPort) {
        this.retrieveTravelStopInformationPort = retrieveTravelStopInformationPort;
        this.retrieveLocationImagesPort = retrieveLocationImagesPort;
    }


    @Override
    public TravelStop retrieveLocationImages(Integer locationId) {
        return retrieveTravelStopInformationPort
                .retrieveLocationInformation(List.of(locationId)).stream().findFirst()
                .map(location -> {
                    location.getImages()
                            .addAll(retrieveLocationImagesPort.retrieveLocationImages(location.getName()));
                    return location;
                })
                .orElseThrow(() -> new SearchLocationImagesException("Location images not found"));
    }
}
