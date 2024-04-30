package ru.vialkina.WebAnalytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vialkina.WebAnalytics.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
