package com.example.springdatarest.model.projection;

import com.example.springdatarest.model.MyFlight;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * Spring Data REST finds projection definitions as follows:
 *
 * Any @Projection interface found in the same package as your entity definitions (or one of its sub-packages) is registered.
 *
 * You can manually register a projection by using RepositoryRestConfiguration.getProjectionConfiguration().addProjection(…).
 *
 *
 * @author Luo Bao Ding
 * @since 12/14/2020
 */
@Projection(name = "MyFlightSummary", types = MyFlight.class)
public interface MyFlightSummary {

    String getName();

   // @JsonIgnore // prevent from serialized
    String getPassword();//serialized as null , because it recognize entity field's @JsonIgnore

    @Value("#{target.name} takes #{target.duration} minutes long")
    String getDescription();
}
