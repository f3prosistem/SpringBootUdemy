package com.f3pro.rest_udemy.converter;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerConverter {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> perseListbject(List<O> origin, Class<D> destination) {
        List<D> destinationObects = new ArrayList<>();
        for (Object o : origin) {
            destinationObects.add(mapper.map(o, destination));
        }
        return destinationObects;
    }
}
