package com.solved.mvchw017.domain;

import com.solved.mvchw017.domain.department.Kitchen;
import com.solved.mvchw017.domain.menu.Menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Restaurant {

    private Long id;
    private String name;
    private LocalDateTime dateOfFoundation;

    private Menu menu;
    private List<Client> clients;
    private Kitchen kitchen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfFoundation() {
        return LocalDate.from(dateOfFoundation);
    }

    public void setDateOfFoundation(LocalDateTime dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
}
