package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.Address;
import com.solved.mvchw017.persistence.AddressRepository;
import com.solved.mvchw017.persistence.impl.AddressJDBCRepositoryImpl;
import com.solved.mvchw017.service.AddressService;

public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl() {
        this.addressRepository = new AddressJDBCRepositoryImpl();
    }

    @Override
    public Address create(Address address) {
        address.setId(null);
        addressRepository.create(address);
        return address;
    }

    @Override
    public void delete(Address address) {
        addressRepository.delete(address);
    }

    @Override
    public Address select(Address address) {
        return addressRepository.select(address);
    }

    @Override
    public void update(Address address, Address addressNew) {
        addressRepository.update(address, addressNew);
    }
}
