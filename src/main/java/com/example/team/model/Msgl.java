package com.example.team.model;

import javax.persistence.*;

@Entity
@Table(name="zxl_msgl")
public class Msgl {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String identifier;
    @Column(nullable = false)
    private String laboratory;
    @Column(nullable = false)
    private String entries_number;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String indentifier) {
        this.identifier = indentifier;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getEntries_number() {
        return entries_number;
    }

    public void setEntries_number(String entries_number) {
        this.entries_number = entries_number;
    }
}
