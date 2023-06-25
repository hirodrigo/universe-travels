package com.travels.universe.adapters.web.location.images.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TravelStopOutDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("images")
    private List<String> images;

    public TravelStopOutDto() {
    }

    public TravelStopOutDto(Integer id, String name, List<String> images) {
        this.id = id;
        this.name = name;
        this.images = images;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "TravelStopOutDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}
