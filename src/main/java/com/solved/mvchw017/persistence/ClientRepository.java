package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.Client;

public interface ClientRepository {

    void create(Client client, Long addressId);

    void linkClientDish(Long clientId, Long dishId);

    void linkClientDrink(Long clientId, Long drinkId);
}
