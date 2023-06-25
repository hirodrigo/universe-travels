package com.travels.universe.adapters.http.location.images;

import com.travels.universe.application.ports.RetrieveLocationImagesPort;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LocationImagesAdapter implements RetrieveLocationImagesPort {

    @Override
    public List<String> retrieveLocationImages(String locationName) {
        try {
            return Jsoup.connect(String.format("https://rickandmorty.fandom.com/wiki/%s",
                    locationName.replace(" ", "_")))
                    .get()
                    .select("img.pi-image-thumbnail")
                    .stream()
                    .map(image -> Optional.ofNullable(image.selectFirst("img"))
                            .map(element -> element.attr("src"))
                            .map(url -> url.split("/revision")[0])
                            .orElse(null))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
