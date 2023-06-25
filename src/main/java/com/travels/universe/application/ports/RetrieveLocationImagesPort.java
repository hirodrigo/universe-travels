package com.travels.universe.application.ports;

import java.util.List;

public interface RetrieveLocationImagesPort {

    List<String> retrieveLocationImages(String locationName);
}
