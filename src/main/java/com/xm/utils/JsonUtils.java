package com.xm.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.List;

public class JsonUtils {
    @SneakyThrows
    public static <T> T to(Class<T> clazz, String data) {
        return new ObjectMapper().readValue(data, clazz);
    }

    @SneakyThrows
    public static <T> List<T> toList(Class<T> clazz, String data) {
        return new ObjectMapper().readerForListOf(clazz).readValue(data);
    }
}
