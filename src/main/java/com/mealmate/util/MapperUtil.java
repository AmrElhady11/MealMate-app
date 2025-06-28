package com.mealmate.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class MapperUtil {
    private final ModelMapper modelMapper;


    public <S, D> D map(S source, Class<D> destinationClass) {
        return modelMapper.map(source, destinationClass);
    }
    public <S, D> List<D> map(List<S> source, Class<D> destinationClass) {
        return source.stream()
                .map(sourceItem -> modelMapper.map(sourceItem,destinationClass))
                .collect(Collectors.toList());}

}
