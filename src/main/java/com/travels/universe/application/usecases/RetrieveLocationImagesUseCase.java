package com.travels.universe.application.usecases;

import com.travels.universe.application.domain.TravelStop;

public interface RetrieveLocationImagesUseCase {

    TravelStop retrieveLocationImages(Integer locationId);
}
