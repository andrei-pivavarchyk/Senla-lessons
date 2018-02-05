package com.service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.apache.log4j.Logger;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenHandler {

    private Map<Object, Object> tokenList = new HashMap<Object, Object>();
    private volatile static TokenHandler instance;
    private static Logger log = Logger.getLogger(TokenHandler.class);

    public static TokenHandler getInstance() {
        if (instance == null) {
            synchronized (TokenHandler.class) {
                if (instance == null)
                    instance = new TokenHandler();
            }
        }
        return instance;
    }

    public String createToken(String login, String password) {

        // Generate random 256-bit (32-byte) shared secret
        SecureRandom random = new SecureRandom();
        byte[] sharedSecret = new byte[32];
        random.nextBytes(sharedSecret);

        try {
            JWSSigner signer = new MACSigner(sharedSecret);

            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .issuer("SuperWebApp")
                    .expirationTime(new Date(new Date().getTime() + 60 * 1000))
                    .claim("login", login)
                    .claim("password", password)
                    .build();

            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(signer);
            String mapKey = new StringBuffer(login).append(password).toString();
            String token = signedJWT.serialize();

            synchronized (this.tokenList) {
                this.tokenList.put(mapKey, token);
            }
            return token;

        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    public Boolean checkToken(String token) {

        String mapKey = null;
        try {
            String login = (String) SignedJWT.parse(token).getJWTClaimsSet().getClaim("login");
            String password = (String) SignedJWT.parse(token).getJWTClaimsSet().getClaim("password");
            mapKey = new StringBuffer(login).append(password).toString();
        } catch (ParseException e) {
            log.error(e.toString());
        }

        synchronized (this.tokenList) {
            if (this.tokenList.get(mapKey) != null) {
                return true;
            } else {
                return false;
            }
        }
    }
}
