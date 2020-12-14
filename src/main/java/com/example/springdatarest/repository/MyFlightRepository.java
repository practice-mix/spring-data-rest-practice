package com.example.springdatarest.repository;

import com.example.springdatarest.model.MyFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Luo Bao Ding
 * @since 12/14/2020
 */
@RepositoryRestResource
public interface MyFlightRepository  extends JpaRepository<MyFlight,String> {

}
