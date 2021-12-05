package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.Address;
import com.solved.mvchw017.domain.Client;
import com.solved.mvchw017.domain.menu.Drink;
import com.solved.mvchw017.domain.menu.Food;
import com.solved.mvchw017.persistence.ClientRepository;
import com.solved.mvchw017.persistence.impl.ClientJDBCRepositoryImpl;
import com.solved.mvchw017.service.AddressService;
import com.solved.mvchw017.service.ClientService;
import com.solved.mvchw017.service.DishesService;
import com.solved.mvchw017.service.DrinkService;

import java.util.List;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AddressService addressService;
    private final DrinkService drinkService;
    private final DishesService dishesService;

    public ClientServiceImpl() {
        this.clientRepository = new ClientJDBCRepositoryImpl();
        this.addressService = new AddressServiceImpl();
        this.drinkService = new DrinkServiceImpl();
        this.dishesService = new DishesServiceImpl();
    }

    @Override
    public Client create(Client client) {
        client.setId(null);
        if (client.getAddress() != null) {
            Address address = addressService.create(client.getAddress());
            client.setAddress(address);
        }
        clientRepository.create(client, client.getAddress().getId());
        client.getDishes();

        {            List<Food> dishes = client.getDishes()
                    .stream()
                    .map(food ->clientRepository.linkClientDish(client.getId(), food.getId()) )
                    .collect(Collectors.toList());
            client.setDishes(dishes);
        }

        client.getDrinks();

        {            List<Drink> drinks = client.getDrinks()
                    .stream()
                    .map(drink ->clientRepository.linkClientDrink(client.getId(), drink.getId()) )
                    .collect(Collectors.toList());
            client.setDrinks(drinks);
        }


//        if (client.getDrinks() != null) {
//            List<Drink> drinks = client.getDrinks()
//                    .stream()
//                    .map(drink -> drinkService.create(drink))
//                    .collect(Collectors.toList());
//            client.setDrinks(drinks);
//        }
//        if (client.getDishes() != null){
//            List<Food> dishes = client.getDishes()
//                    .stream()
//                    .map(food -> dishesService.create(food))
//                    .collect(Collectors.toList());
//            client.setDishes(dishes);
//        }
        return client;
    }
}
