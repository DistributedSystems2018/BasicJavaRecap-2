package com.elte;

public class Player {
    String name_;

    public Player(String name) {
        this.name_ = name;
    }

    @Override
    public String toString() {
        return this.name_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }
}
