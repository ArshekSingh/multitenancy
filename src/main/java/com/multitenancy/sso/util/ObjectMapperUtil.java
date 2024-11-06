package com.multitenancy.sso.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.extern.apachecommons.CommonsLog;
import org.antlr.v4.runtime.misc.NotNull;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

@CommonsLog
public class ObjectMapperUtil {

    private ObjectMapperUtil() {
//
    }

    public static final ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build()
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .registerModule(new JavaTimeModule())
            .registerModule(new ParameterNamesModule())
             .setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Kolkata")))
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    private static final ObjectMapper mapper2 = Jackson2ObjectMapperBuilder.json().build()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    public static <T> String asJsonString(T element) {
        try {
            return Objects.nonNull(element)
                    ? mapper.writerFor(element.getClass()).writeValueAsString(element)
                    : "";
        } catch (JsonProcessingException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T fromJsonString(@NotNull String jsonString, Class<T> clazz) {
        try {
            return mapper.readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> List<T> fromArrayString(String arrayString, Class<T> clazz) {
        try {
            TypeFactory typeFactory = mapper.getTypeFactory();
            CollectionType collectionType = typeFactory.constructCollectionType(List.class, clazz);
            return mapper.readValue(arrayString, collectionType);
        } catch (JsonProcessingException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            throw new IllegalArgumentException(e);
        }
    }

}
