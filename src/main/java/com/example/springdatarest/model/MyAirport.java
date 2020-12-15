package com.example.springdatarest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "my_airport")
@Getter
@Setter
public class MyAirport {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid2") //generator always override id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private Integer size;

    public MyAirport(){}

    public MyAirport(String id) {
        this.id = id;
    }


//    @OneToMany(mappedBy = "depaAirport",fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private List<MyFlight> depaFlights;
//
//    @OneToMany(mappedBy = "arriAirport",fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private List<MyFlight> arriFlights;


}
