package com.travels.universe.adapters.http.location.information.dto.in;

import java.util.List;

public class LocationInformationInDto {

    private final String query;
    private final static String GRAPHQL_QUERY = "query { locationsByIds (ids: %s) { id, name, type, dimension, " +
            "residents { id, episode { id } } } }";

    public LocationInformationInDto(List<Integer> locationsIds) {
        this.query = String.format(GRAPHQL_QUERY, locationsIds.toString());
    }

    public String getQuery() {
        return query;
    }
}
