package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.Client;
import com.solved.mvchw017.domain.Restaurant;
import com.solved.mvchw017.domain.department.Kitchen;
import com.solved.mvchw017.domain.menu.Menu;
import com.solved.mvchw017.persistence.RestaurantRepository;
import com.solved.mvchw017.persistence.impl.RestaurantJDBCRepositoryImpl;
import com.solved.mvchw017.service.ClientService;
import com.solved.mvchw017.service.KitchenService;
import com.solved.mvchw017.service.MenuService;
import com.solved.mvchw017.service.RestaurantService;
import org.apache.logging.log4j.core.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuService menuService;
    private final ClientService clientService;
    private final KitchenService kitchenService;


    public RestaurantServiceImpl() {
        this.restaurantRepository = new RestaurantJDBCRepositoryImpl();
        this.menuService = null;
        this.clientService = null;
        this.kitchenService = null;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        restaurant.setId(null);
        restaurantRepository.create(restaurant);

        if (restaurant.getMenu() != null) {
            Menu menu = menuService.create(restaurant.getMenu(), restaurant.getId());
            restaurant.setMenu(menu);
        }
        if (restaurant.getClients() != null) {
            List<Client> clients = restaurant.getClients()
                    .stream()
                    .map(client -> clientService.create(client))
                    .collect(Collectors.toList());
            restaurant.setClients(clients);
        }
        if (restaurant.getKitchen() != null) {
            Kitchen kitchen = kitchenService.create(restaurant.getKitchen(), restaurant.getId());
            restaurant.setKitchen(kitchen);
        }
        return restaurant;
    }
}
