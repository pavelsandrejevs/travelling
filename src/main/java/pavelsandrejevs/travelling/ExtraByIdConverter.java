package pavelsandrejevs.travelling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pavelsandrejevs.travelling.Extra;
import pavelsandrejevs.travelling.Extra.Type;

@Component
public class ExtraByIdConverter implements Converter<String, Extra> {

    private Map<String, Extra> extraMap = new HashMap<>();

    public ExtraByIdConverter() {
        extraMap.put("VEGAN", new Extra("VEGAN", "Vegan Food", Type.FOOD));
        extraMap.put("LACTOSE", new Extra("LACTOSE", "Lactose Free", Type.FOOD));
        extraMap.put("HALAL", new Extra("HALAL", "Halal", Type.FOOD));
        extraMap.put("SEPARATE", new Extra("SEPARATE", "Separate Room", Type.SLEEPING));
        extraMap.put("BUNK", new Extra("BUNK", "Bunk Bed", Type.SLEEPING));
        extraMap.put("VIEW", new Extra("VIEW", "With View", Type.SLEEPING));
    }

    @Override
    public Extra convert(String id) {
        return extraMap.get(id);
    }

}
