package com.example.springdatarest.config;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import com.example.springdatarest.model.Actor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@RequiredArgsConstructor
public class MyRepositoryRestConfigurerAdapter implements RepositoryRestConfigurer {


    private final EntityManager entityManager;

    /**
     * expose id
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration, CorsRegistry cors) {
        repositoryRestConfiguration.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(e -> e.getJavaType()).collect(Collectors.toList()).toArray(new Class[0]));
//or individual:  config.exposeIdsFor(User.class);

//        config.withEntityLookup()
//                .forRepository(UserRepository.class)
//                .withIdMapping(User::getUsername)
//                .withLookup(UserRepository::findByUsername);

        ExposureConfiguration exposureConfiguration = repositoryRestConfiguration.getExposureConfiguration();

        exposureConfiguration.forDomainType(Actor.class).disablePutForCreation();
        exposureConfiguration.withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PATCH));

//        repositoryRestConfiguration.setDefaultMediaType(MediaType.APPLICATION_JSON);//useless
//        repositoryRestConfiguration.useHalAsDefaultJsonMediaType(false);//useless

    }


}