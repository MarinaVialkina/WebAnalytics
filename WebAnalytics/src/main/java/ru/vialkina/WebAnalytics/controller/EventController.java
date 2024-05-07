package ru.vialkina.WebAnalytics.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.vialkina.WebAnalytics.model.Event;
import ru.vialkina.WebAnalytics.service.EventService;

import java.io.FileWriter;

@RestController()
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;


    @PostMapping("/api/v1/events")
    public void addEvent(@RequestBody Event event) {

        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            writer.write(String.valueOf(event));
            writer.flush();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        eventService.addEvent(event);

    }
}