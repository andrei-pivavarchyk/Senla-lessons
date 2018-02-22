package com.serviceAPI;

public interface ITokenHandler {
    String createToken(Integer id);
    Integer getUserIdByToken(String token);

}
