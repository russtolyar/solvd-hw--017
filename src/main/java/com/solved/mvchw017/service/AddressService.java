package com.solved.mvchw017.service;

import com.solved.mvchw017.domain.Address;

public interface AddressService {
    Address create(Address address);

    void delete(Address address);

    Address select(Address address);

    void update(Address address, Address addressNew);
}
