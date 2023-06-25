package com.travels.universe.adapters.persistence.travelplan.entity;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity(name = "travel_plan")
public class TravelPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CollectionTable(name = "travel_stop")
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> travelStops;

    public TravelPlanEntity() {
    }

    public TravelPlanEntity(Integer id, List<Integer> travelStops) {
        this.id = id;
        this.travelStops = travelStops;
    }

    public Integer getId() {
        return id;
    }

    public List<Integer> getTravelStops() {
        return travelStops;
    }

    @Override
    public String toString() {
        return "TravelPlanEntity{" +
                "id=" + id +
                ", travelStops=" + travelStops +
                '}';
    }
}
