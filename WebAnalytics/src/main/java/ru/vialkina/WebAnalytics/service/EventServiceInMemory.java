package ru.vialkina.WebAnalytics.service;


import lombok.RequiredArgsConstructor;



import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.vialkina.WebAnalytics.model.Event;
import ru.vialkina.WebAnalytics.repository.EventRepository;




@Service
@RequiredArgsConstructor
public class EventServiceInMemory implements EventService {

    private final EventRepository eventRepository;


    @Override
    public void addEvent(Event event) {
        
    }



    @Override
    public void evictCache() {}

    @Scheduled(fixedRate = 60000, initialDelay = 60000)
    @Override
    public void sendCacheToDB() throws InterruptedException{


        //evictCache();



    }
}