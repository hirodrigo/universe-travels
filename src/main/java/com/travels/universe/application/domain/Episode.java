package com.travels.universe.application.domain;

public class Episode {

    private Integer id;

    public Episode(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                '}';
    }
}
