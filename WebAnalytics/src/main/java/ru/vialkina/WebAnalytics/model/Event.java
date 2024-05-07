package ru.vialkina.WebAnalytics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(schema = "json", name = "events")
@Getter
@Setter
public class Event {
    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    private String name;
    private String created_at;
    private String param;

    public Event() {
    }

    public Event(String title, String name, String created_at, String param){
        this.title = title;
        this.name = name;
        this.created_at = created_at;
        this.param = param;
    }

}