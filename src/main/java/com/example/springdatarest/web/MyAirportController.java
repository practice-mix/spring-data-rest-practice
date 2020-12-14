package com.example.springdatarest.web;

import com.example.springdatarest.model.MyAirport;
import com.example.springdatarest.repository.MyAirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Luo Bao Ding
 * @since 12/14/2020
 */
@RestController
@RequestMapping("myAirports")
@RequiredArgsConstructor
public class MyAirportController {

    private final MyAirportRepository airportRepository;


    @GetMapping("/search/takeByName")
    public List<MyAirport> takeByName(@RequestParam("name") String name) {
        MyAirport airport=new MyAirport();
        airport.setName(name);
       return airportRepository.findAll(Example.of(airport));
    }

}
