package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.Address;
import com.solved.mvchw017.domain.Client;
import com.solved.mvchw017.domain.menu.Dish;
import com.solved.mvchw017.domain.menu.Drink;
import com.solved.mvchw017.persistence.ClientRepository;
import com.solved.mvchw017.persistence.impl.ClientJDBCRepositoryImpl;
import com.solved.mvchw017.service.AddressService;
import com.solved.mvchw017.service.ClientService;
import com.solved.mvchw017.service.DishService;
import com.solved.mvchw017.service.DrinkService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AddressService addressService;
    private final DrinkService drinkService;
    private final DishService dishService;

    public ClientServiceImpl() {
        this.clientRepository = new ClientJDBCRepositoryImpl();
        this.addressService = new AddressServiceImpl();
        this.drinkService = new DrinkServiceImpl();
        this.dishService = new DishServiceImpl();
    }

    @Override
    public Client create(Client client) {
        client.setId(null);
        if (client.getAddress() != null) {
            Address address = addressService.create(client.getAddress());
            client.setAddress(address);
        }
        clientRepository.create(client, client.getAddress().getId());

        List<Dish> dishes = client.getDishes();
        client.getDishes()
                .stream()
                .forEach(dish -> clientRepository.linkClientDish(client.getId(), dish.getId()));
        client.setDishes(dishes);

        List<Drink> drinks = client.getDrinks();

        client.getDrinks()
                .stream()
                .forEach(drink -> clientRepository.linkClientDrink(client.getId(), drink.getId()));

        client.setDrinks(drinks);
        return client;
    }
}
