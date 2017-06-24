package com.app.TravelComparison;

import java.util.Date;

/**
 * Created by Chris Harris on 6/24/2017.
 */
public class TravelMode {

    private long id;
    private String travelModeName;

    public TravelMode(String travelModeName) {
        this.id = (new Date()).getTime();
        this.travelModeName = travelModeName;
    }

    public long getId() {
        return id;
    }

    public String getTravelModeName() {
        return travelModeName;
    }

    public void setTravelModeName(String travelModeName) {
        this.travelModeName = travelModeName;
    }

    @Override
    public String toString() {
        return "TravelMode{" +
                "id=" + id +
                ", travelModeName='" + travelModeName + '\'' +
                '}';
    }
}
