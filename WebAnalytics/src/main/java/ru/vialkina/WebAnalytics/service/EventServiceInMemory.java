package ru.vialkina.WebAnalytics.service;


import lombok.RequiredArgsConstructor;



import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.vialkina.WebAnalytics.model.Event;
import ru.vialkina.WebAnalytics.repository.EventRepository;

import java.util.LinkedList;


@Service
@RequiredArgsConstructor
public class EventServiceInMemory implements EventService {

    private final EventRepository eventRepository;
    private LinkedList list = new LinkedList<>();


    @Override
    public void addEvent(Event event) {
        list.add(event);
    }



    @Override
    public void evictCache() {}

    @Scheduled(fixedRate = 60000, initialDelay = 60000)
    @Override
    public void sendCacheToDB() throws InterruptedException{
        for (int i = 0; i < list.size(); i++){
            eventRepository.saveAndFlush((Event) list.get(i));
            list.remove(i);
        }




    }
}