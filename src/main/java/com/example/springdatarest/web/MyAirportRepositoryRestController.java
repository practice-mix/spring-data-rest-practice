package com.example.springdatarest.web;

import com.example.springdatarest.model.MyAirport;
import com.example.springdatarest.repository.MyAirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Luo Bao Ding
 * @since 12/14/2020
 */
@RepositoryRestController
@RequiredArgsConstructor
@RequestMapping("/myAirports")
public class MyAirportRepositoryRestController {

    private final MyAirportRepository airportRepository;


    @GetMapping("/search/takeByNameRepositoryRestExample")
    @ResponseBody
    public ResponseEntity<List<MyAirport>> takeByNameRepositoryRestExample(@RequestParam("name") String name) {
        MyAirport airport=new MyAirport();
        airport.setName(name);
       return ResponseEntity.ok(airportRepository.findAll(Example.of(airport))); // N+1
    }

    @GetMapping("/takeByName")
    @ResponseBody
    public List<MyAirport> takeByName(@RequestParam("name") String name) {
        return airportRepository.findByName(name);//N+1
    }

}
