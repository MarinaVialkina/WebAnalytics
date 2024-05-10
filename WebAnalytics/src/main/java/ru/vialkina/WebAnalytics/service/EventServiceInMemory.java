package ru.vialkina.WebAnalytics.service;

import lombok.RequiredArgsConstructor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.vialkina.WebAnalytics.model.Event;
import ru.vialkina.WebAnalytics.repository.EventRepository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Service
@RequiredArgsConstructor
public class EventServiceInMemory implements EventService {

    private final EventRepository eventRepository;
    private List<Event> cache = new CopyOnWriteArrayList<Event>();


    @Override
    public void addEvent(Event event) {
        cache.add(event);
    }


    @Scheduled(fixedRate = 60000, initialDelay = 60000)
    @Override
    public void sendCacheToDB() throws InterruptedException{
        List<Event> cacheForSending = cache;
        eventRepository.saveAllAndFlush(cacheForSending);
        cache.clear();
        cacheForSending.clear();
    }
}