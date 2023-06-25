package com.travels.universe.adapters.http.location.information;

import com.travels.universe.adapters.http.location.information.dto.in.LocationInformationInDto;
import com.travels.universe.adapters.http.location.information.dto.out.LocationInformationOutDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "rickAndMortyClient", url = "${client.rickandmortyapi.url}")
public interface RickAndMortyClient {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LocationInformationOutDto getLocationInformation(@RequestBody LocationInformationInDto locationInformationInDto);
}
