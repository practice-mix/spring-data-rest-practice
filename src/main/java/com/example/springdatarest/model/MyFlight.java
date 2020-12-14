package com.example.springdatarest.model;

import com.example.springdatarest.config.MyAirportToNameSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "my_flight")
@Getter
@Setter
public class MyFlight {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid2")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Integer duration;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "depa_airport_id")
    @JsonBackReference
//    @JsonSerialize(using = MyAirportToNameSerializer.class, as = MyAirport.class) // useless because REST do not render @ManyToOne, regardless of @JsonBackReference, although JPA would load @ManyToOne  that default to EAGER
    private MyAirport depaAirport;


    @ManyToOne
    @JoinColumn(name = "arri_airport_id")
    @JsonBackReference
    private MyAirport arriAirport;

    @JsonSerialize(using = MyAirportToNameSerializer.class, as = MyAirport.class)
    public MyAirport getDepaAirportName() {
        return depaAirport;
    }

    public String getArriAirportName() {
        return arriAirport.getName();
    }


}
