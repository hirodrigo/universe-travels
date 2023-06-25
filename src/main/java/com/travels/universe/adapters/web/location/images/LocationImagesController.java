package com.travels.universe.adapters.web.location.images;

import com.travels.universe.adapters.web.location.images.dto.out.TravelStopOutDto;
import com.travels.universe.adapters.web.location.images.mapper.TravelStopMapper;
import com.travels.universe.application.usecases.RetrieveLocationImagesUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location/")
public class LocationImagesController {

    private final Logger logger = LoggerFactory.getLogger(LocationImagesController.class);

    private final RetrieveLocationImagesUseCase retrieveLocationInformation;

    public LocationImagesController(RetrieveLocationImagesUseCase retrieveLocationInformation) {
        this.retrieveLocationInformation = retrieveLocationInformation;
    }

    @GetMapping("/{id}/images")
    public TravelStopOutDto retrieveLocationImages(@PathVariable("id") Integer travelPlanId) {
        logger.info("Request received in location images endpoint: {}", travelPlanId);
        final var travelStop = retrieveLocationInformation.retrieveLocationImages(travelPlanId);
        logger.info("Images for location {} successfully retrieved.", travelStop);
        return TravelStopMapper.toAdapter(travelStop);
    }
}
