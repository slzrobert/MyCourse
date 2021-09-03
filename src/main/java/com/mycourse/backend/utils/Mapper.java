package com.mycourse.backend.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }
    public <S, T> S generalMapper(T input, Class<S> output) {
        return modelMapper.map(input, output);
    }
    public <S, T> List<S> mapCollection(List<T> input, Class<S> output) {
        return input.stream().map(element -> generalMapper(element, output)).collect(Collectors.toList());
    }
}
