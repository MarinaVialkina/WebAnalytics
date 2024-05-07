package ru.vialkina.WebAnalytics.service;

import ru.vialkina.WebAnalytics.model.Event;

public interface EventService {
    Event addEvent(Event event);
    void evictCache();
    void sendCacheToDB() throws InterruptedException;
}