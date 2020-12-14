package com.example.springdatarest.web;

import com.example.springdatarest.model.Actor;
import com.example.springdatarest.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resources;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * @author Luo Bao Ding
 * @since 12/13/2020
 */
@RepositoryRestController
@RequiredArgsConstructor
public class ActorController {

    private final ActorRepository actorRepository;


    @GetMapping(path = "/actors/search/getOne")
    @ResponseBody
    public ResponseEntity<?> getOne() {
        Actor actor = new Actor();
        actor.setFirstName("PENELOPE");
        Page<Actor> result = actorRepository.findAll(Example.of(actor), PageRequest.of(0, 5));

        return ResponseEntity.ok(result);
    }

}
