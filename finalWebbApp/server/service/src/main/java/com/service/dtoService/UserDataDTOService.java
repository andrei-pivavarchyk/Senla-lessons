package com.service.dtoService;

import com.daoAPI.IUserDAO;
import com.daoAPI.IUserDataDAO;
import com.model.*;
import com.serviceAPI.IUserDataDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserDataDTOService implements IUserDataDTOService {

    @Autowired
    private IUserDataDAO userDataDao;
    @Autowired
    private IUserDAO userDao;

    public UserDataDTOService() {
    }

    @Override
    public UserData getUserDataDTO(UserData userData) {

        UserData dto = new UserData();
        dto.setId(userData.getId());
        String str = userData.getRole().toString();
        dto.setRole(Role.valueOf(str));
        dto.setName(userData.getName());
        dto.setSurname(userData.getSurname());
        dto.setPatronymic(userData.getPatronymic());
        dto.setEmail(userData.getEmail());
        dto.setPhone(userData.getPhone());
        dto.setAddress(userData.getAddress());
        Address address = dto.getAddress();
        address.setCity(userData.getAddress().getCity());
        address.setCountry(userData.getAddress().getCountry());
        address.setIndex(userData.getAddress().getIndex());
        address.setRegion(userData.getAddress().getRegion());
        address.setLocalAddress(userData.getAddress().getLocalAddress());

        return dto;
    }


}