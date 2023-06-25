package com.travels.universe.application.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class TravelStop {

    private final Integer id;
    private final String name;
    private final String type;
    private final String dimension;
    private final List<Resident> residents;
    private final Integer popularity;
    private final List<String> images = new ArrayList<>();

    public TravelStop(Integer id, String name, String type, String dimension, List<Resident> residents) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dimension = dimension;
        this.residents = residents;
        this.popularity = calculatePopularity();
    }

    private Integer calculatePopularity() {
        AtomicReference<Integer> calculatedPopularity = new AtomicReference<>(0);
        Optional.ofNullable(residents)
                .ifPresent(r ->
                        r.forEach(resident -> calculatedPopularity.updateAndGet(v -> v + resident.getEpisodes().size())));
        return calculatedPopularity.get();
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

    public Integer getPopularity() {
        return popularity;
    }

    public List<String> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "TravelStop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dimension='" + dimension + '\'' +
                ", residents=" + residents +
                ", popularity=" + popularity +
                ", images=" + images +
                '}';
    }
}
