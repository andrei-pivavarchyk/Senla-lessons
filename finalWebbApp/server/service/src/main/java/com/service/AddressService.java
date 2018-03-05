package com.service;

import com.daoAPI.IAddressDAO;
import com.daoAPI.IAuthorDAO;
import com.model.Address;
import com.serviceAPI.IAddressService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


@Service
@Transactional
public class AddressService implements IAddressService {
    @Autowired
    private IAddressDAO addressDAO;
    private static Logger log = Logger.getLogger(AddressService.class);
    public AddressService(){}

    public Map updateAddress(Address address){
        try {
            this.addressDAO.updateEntity(address);
            Map result = new HashMap();
            result.put("success", true);
            result.put("message", "Address update success");
            return result;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
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
    public Address getAddressByID(Integer addressID){
        try {
            Address address=this.addressDAO.getEntityById(addressID);
            return address;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

}
