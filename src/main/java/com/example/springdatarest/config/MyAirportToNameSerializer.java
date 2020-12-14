package com.example.springdatarest.config;

import com.example.springdatarest.model.MyAirport;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author Luo Bao Ding
 * @since 12/15/2020
 */
public class MyAirportToNameSerializer extends JsonSerializer<MyAirport> {
    @Override
    public void serialize(MyAirport value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.getName());
    }
}
