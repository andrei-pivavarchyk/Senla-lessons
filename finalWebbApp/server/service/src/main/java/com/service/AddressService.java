package com.service;

import com.daoAPI.IAddressDAO;
import com.daoAPI.IAuthorDAO;
import com.model.Address;
import com.serviceAPI.IAddressService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AddressService implements IAddressService {
    @Autowired
    private IAddressDAO addressDAO;
    private static Logger log = Logger.getLogger(AddressService.class);
    public AddressService(){}

    public void updateAddress(Address address){
        try {
            this.addressDAO.updateEntity(address);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public void addAddress(Address address)
    {
        try {
            this.addressDAO.addEntity(address);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

}
