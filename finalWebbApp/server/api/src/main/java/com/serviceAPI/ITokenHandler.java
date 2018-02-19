package com.serviceAPI;

public interface ITokenHandler {
    String createToken(Long id);
    Long getUserIdByToken(String token);

}
