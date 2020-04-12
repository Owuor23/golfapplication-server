package com.golfapplication.golfapplicationserver.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Services {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="service_type")
    private  String serviceType;
    @Column(name="service_name")
    private  String  serviceName;

    @ManyToMany(mappedBy = "Services")
    private Set<Club>clubs;

    public Services(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }
}
