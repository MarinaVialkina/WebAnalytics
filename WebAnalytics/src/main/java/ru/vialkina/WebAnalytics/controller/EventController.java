package ru.vialkina.WebAnalytics.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.vialkina.WebAnalytics.model.Event;
import ru.vialkina.WebAnalytics.service.EventService;


@RestController()
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;


    @PostMapping("/api/v1/events")
    public void addEvent(@RequestBody Event event) {
        eventService.addEvent(event);

    }
}