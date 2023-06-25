package com.travels.universe.application.domain;

import java.util.List;

public class Resident {

    private final Integer id;
    private final List<Episode> episodes;

    public Resident(Integer id, List<Episode> episodes) {
        this.id = id;
        this.episodes = episodes;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "id=" + id +
                ", episode=" + episodes +
                '}';
    }
}
