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
}
