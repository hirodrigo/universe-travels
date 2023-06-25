package com.travels.universe.adapters.http.location.information.mapper;

import com.travels.universe.application.domain.Episode;
import com.travels.universe.application.domain.Resident;
import com.travels.universe.application.domain.TravelStop;

import java.util.stream.Collectors;

import static com.travels.universe.adapters.http.location.information.dto.out.LocationInformationOutDto.Data.LocationsByIds;
import static com.travels.universe.adapters.http.location.information.dto.out.LocationInformationOutDto.Data.LocationsByIds.EpisodeOutDto;
import static com.travels.universe.adapters.http.location.information.dto.out.LocationInformationOutDto.Data.LocationsByIds.ResidentOutDto;

public class LocationInformationMapper {

    private LocationInformationMapper() {
    }

    public static TravelStop toDomain(LocationsByIds locationInformationOutDto) {
        return new TravelStop(locationInformationOutDto.getId(),
                locationInformationOutDto.getName(),
                locationInformationOutDto.getType(),
                locationInformationOutDto.getDimension(),
                locationInformationOutDto.getResidents().stream().map(LocationInformationMapper::toDomain).collect(Collectors.toList()));
    }

    public static Resident toDomain(ResidentOutDto residentOutDto) {
        return new Resident(residentOutDto.getId(),
                residentOutDto.getEpisode().stream().map(LocationInformationMapper::toDomain).collect(Collectors.toList()));
    }

    public static Episode toDomain(EpisodeOutDto episodeOutDto) {
        return new Episode(episodeOutDto.getId());
    }
}
