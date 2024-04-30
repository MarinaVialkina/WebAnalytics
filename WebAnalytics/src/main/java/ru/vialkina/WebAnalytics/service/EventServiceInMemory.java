package ru.vialkina.WebAnalytics.service;


import lombok.RequiredArgsConstructor;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.vialkina.WebAnalytics.model.Event;
import ru.vialkina.WebAnalytics.repository.EventRepository;
import org.springframework.cache.Cache.ValueWrapper;



@Service
@RequiredArgsConstructor
public class EventServiceInMemory implements EventService {

    private final CacheManager cacheManager;
    private final EventRepository eventRepository;



    @Cacheable(value = "event", key = "k")
    @Override
    public Event addEvent(Event event) {
        eventRepository.saveAndFlush(event);
        return event;
    }


    @CacheEvict(cacheNames = "event", allEntries = true)
    @Override
    public void evictCache() {}

    @Scheduled(fixedRate = 60000, initialDelay = 60000)
    @Override
    public void sendCacheToDB() throws InterruptedException{
        Cache cache = cacheManager.getCache("event");
        ValueWrapper valueWrapper = cache.get("k");
        Event event = (Event) valueWrapper.get();


        eventRepository.save(event);

        //evictCache();



    }
}