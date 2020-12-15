package com.example.springdatarest.web;

import com.example.springdatarest.model.MyAirport;
import com.example.springdatarest.repository.MyAirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Luo Bao Ding
 * @since 12/14/2020
 */
@RestController
@RequestMapping("/myAirports")
@RequiredArgsConstructor
public class MyAirportController {

    private final MyAirportRepository airportRepository;


    @GetMapping("/search/takeByNameRest")
    public List<MyAirport> takeByName(@RequestParam("name") String name) {//@RestController will load airport cascade as flight
        MyAirport airport = new MyAirport();
        airport.setName(name);
        return airportRepository.findAll(Example.of(airport));
    }

    @GetMapping("/search/takeById")
    public MyAirport takeById(@RequestParam("id") String id) {
        return airportRepository.findById(id).get(); //N+1
    }

    @GetMapping("/search/obtainByName")
    @ResponseBody
    public List<MyAirport> obtainByName(@RequestParam("name") String name) {
        return airportRepository.findByName(name); //N+1
    }


}
