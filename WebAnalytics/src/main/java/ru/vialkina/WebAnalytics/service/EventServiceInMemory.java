package ru.vialkina.WebAnalytics.service;

import lombok.RequiredArgsConstructor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.vialkina.WebAnalytics.model.Event;
import ru.vialkina.WebAnalytics.repository.EventRepository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EventServiceInMemory implements EventService {

    private final EventRepository eventRepository;
    private List<Object> cache = Collections.synchronizedList( new LinkedList<>());


    @Override
    public void addEvent(Event event) {
        cache.add(event);
    }


    @Scheduled(fixedRate = 60000, initialDelay = 60000)
    @Override
    public void sendCacheToDB() throws InterruptedException{
        for (int i = 0; i < cache.size(); i++){
            eventRepository.saveAndFlush((Event) cache.get(i));
            cache.remove(i);
        }




    }
}