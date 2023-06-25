package com.travels.universe.adapters.http.location.information.dto.out;

import java.util.Collections;
import java.util.List;

public class LocationInformationOutDto {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {

        private List<LocationsByIds> locationsByIds;

        public List<LocationsByIds> getLocationsByIds() {
            return locationsByIds;
        }

        public void setLocationsByIds(List<LocationsByIds> locationsByIds) {
            this.locationsByIds = locationsByIds;
        }

        public static class LocationsByIds {

            private final Integer id;
            private final String name;
            private final String type;
            private final String dimension;
            private final List<ResidentOutDto> residents;

            public LocationsByIds(Integer id, String name, String type, String dimension, List<ResidentOutDto> residents) {
                this.id = id;
                this.name = name;
                this.type = type;
                this.dimension = dimension;
                this.residents = residents == null ? Collections.emptyList() : residents;
            }

            public static class ResidentOutDto {
                private final Integer id;
                private final List<EpisodeOutDto> episode;

                public ResidentOutDto(Integer id, List<EpisodeOutDto> episode) {
                    this.id = id;
                    this.episode = episode == null ? Collections.emptyList() : episode;
                }

                public Integer getId() {
                    return id;
                }

                public List<EpisodeOutDto> getEpisode() {
                    return episode;
                }
            }

            public static class EpisodeOutDto {
                private Integer id;

                public void setId(Integer id) {
                    this.id = id;
                }

                public Integer getId() {
                    return id;
                }
            }

            public Integer getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getType() {
                return type;
            }

            public String getDimension() {
                return dimension;
            }

            public List<ResidentOutDto> getResidents() {
                return residents;
            }
        }
    }
}
