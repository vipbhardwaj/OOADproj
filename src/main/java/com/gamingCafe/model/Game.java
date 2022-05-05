package com.gamingCafe.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game", schema = "public")

public class Game {
    @Id
    public String g_id;
    public String g_name;
    public int g_price;
    public Game() {

    }

    public Game(String g_id, String g_name, int g_price) {
        super();

        this.g_id = g_id;
        this.g_name = g_name;
        this.g_price = g_price;
    }

    @Column(name = "g_id", nullable = false)
    public String getId() {
        return g_id;
    }

    public void setId(String g_id) {
        this.g_id = g_id;
    }

    @Column(name = "g_name", nullable = false)
    public String getName() {
        return g_name;
    }

    public void setName(String g_name) {
        this.g_name = g_name;
    }

    @Column(name = "g_price", nullable = false)
    public int getPrice() {
        return g_price;
    }

    public void setPrice(int g_price) {
        this.g_price = g_price;
    }

    @Override
    public String toString() {
        return "Game [ g_id = " + g_id + ", g_name = " + g_name + ", g_price = " + g_price + " ]";
    }
}