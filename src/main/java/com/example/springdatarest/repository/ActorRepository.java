package com.example.springdatarest.repository;

import com.example.springdatarest.model.Actor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author Luo Bao Ding
 * @since 12/12/2020
 */
@RepositoryRestResource(exported = true,path="actors")
public interface ActorRepository  extends JpaRepository<Actor, Integer> {


    @RestResource(exported = false)//hide actor DELETE endpoint
    @Override
    void deleteById(Integer integer);

    List<Actor> findByFirstName(@Param("firstName") String firstName);//SDR eliminated N+1 here; default to http://localhost:8080/actors/search/findByFirstName


    List<Actor> findByLastName(@Param("lastName") String lastName);

//    @Override
//    List<Actor> findAll(Example example);//useless

}
