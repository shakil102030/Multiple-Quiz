package com.example.shakil.multiplequiz;

public class ForeignKey {
    private int id;
    private String name;

    public ForeignKey() {
    }

    public ForeignKey(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}