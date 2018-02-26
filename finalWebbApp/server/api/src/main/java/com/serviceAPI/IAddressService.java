package com.serviceAPI;

import com.model.Address;

/**
 * Created by андрей on 26.02.2018.
 */
public interface IAddressService {
    void updateAddress(Address address);
    void addAddress(Address address);
}
