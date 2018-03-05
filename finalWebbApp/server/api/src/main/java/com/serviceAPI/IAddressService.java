package com.serviceAPI;

import com.model.Address;

import java.util.Map;


public interface IAddressService {
    Map updateAddress(Address address);
    void addAddress(Address address);
    Address getAddressByID(Integer addressID);

}
