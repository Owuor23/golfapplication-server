package com.golfapplication.golfapplicationserver.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Column(name="club_name")
    private String clubName;
    @NotBlank
    @Column(name="club_Location")
    private String clubLocation;
    @NotBlank
    @Column(name = "latitude")
    private double latitude;
    @NotBlank
    @Column(name = "longitude")
    private double longitude;

    @ManyToMany(mappedBy = "CLub")
    private Set<Services> servicesSet;

    public Club(@NotBlank String clubName, @NotBlank String clubLocation, @NotBlank double latitude, @NotBlank double longitude) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private Club(){

    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public Set<Services> getServicesSet() {
        return servicesSet;
    }

    public void setServicesSet(Set<Services> servicesSet) {
        this.servicesSet = servicesSet;
    }
}
