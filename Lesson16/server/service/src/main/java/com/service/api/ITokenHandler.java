package com.service.api;

public interface ITokenHandler {
    String createToken(Long id);
    Long getUserIdByToken(String token);

}
