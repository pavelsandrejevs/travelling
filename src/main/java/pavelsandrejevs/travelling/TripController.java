package pavelsandrejevs.travelling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import pavelsandrejevs.travelling.Extra;
import pavelsandrejevs.travelling.Extra.Type;
import pavelsandrejevs.travelling.Trip;
import pavelsandrejevs.travelling.Order;

@Slf4j
@Controller
@RequestMapping("/trips")
@SessionAttributes("order")
public class TripController {

    @ModelAttribute
    public void addExtrasToModel(Model model) {
        List<Extra> extras = Arrays.asList(
            new Extra("VEGAN", "Vegan Food", Type.FOOD),
            new Extra("LACTOSE", "Lactose Free", Type.FOOD),
            new Extra("HALAL", "Halal", Type.FOOD),
            new Extra("SEPARATE", "Separate Room", Type.SLEEPING),
            new Extra("BUNK", "Bunk Bed", Type.SLEEPING),
            new Extra("VIEW", "With View", Type.SLEEPING)
        );

        Type[] types = Extra.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                filterByType(extras, type));
        }
    }

    private Iterable<Extra> filterByType(
        List<Extra> extras, Type type) {
        return extras
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "trip")
    public Trip trip() {
        return new Trip();
    }

    @GetMapping
    public String showTripForm() {
        return "tripForm";
    }

    @PostMapping
    public String processTrip(Trip trip, @ModelAttribute Order order) {
        order.addTrip(trip);
        log.info("Processing trip: {}", trip);
        return "redirect:/orders/current";
    }

}
