package org.in28minutes.springboot.violation_tpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entry_area")
public class EntryArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public EntryArea() {
    }

    public EntryArea(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public EntryArea(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
