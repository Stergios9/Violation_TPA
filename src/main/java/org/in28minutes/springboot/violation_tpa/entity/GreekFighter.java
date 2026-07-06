package org.in28minutes.springboot.violation_tpa.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "greek_fighter")
public class GreekFighter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String typeName;

    public GreekFighter(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public GreekFighter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
