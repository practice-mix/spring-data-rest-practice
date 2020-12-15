package com.example.springdatarest.repository;

import com.example.springdatarest.model.MyAirport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 * @author Luo Bao Ding
 * @since 12/14/2020
 */
@RepositoryRestResource
public interface MyAirportRepository extends JpaRepository<MyAirport, String> {

    List<MyAirport> findBySizeGreaterThanEqual(@Param("size") Integer size);

    List<MyAirport> findByName(@Param("name") String name);
}
