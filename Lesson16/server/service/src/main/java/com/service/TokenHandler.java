package com.service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.service.api.ITokenHandler;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
@Component
public class TokenHandler implements ITokenHandler{

    private static Logger log = Logger.getLogger(TokenHandler.class);

    public String createToken(Long id) {
        byte[] sharedSecret = new byte[32];
        try {
            JWSSigner signer = new MACSigner(sharedSecret);
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()

                    .issuer("SuperWebApp")
                    .expirationTime(new Date(new Date().getTime() + 60 * 1000))
                    .claim("id", id)
                    .build();

            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(signer);
            String token = signedJWT.serialize();
            return token;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

    private Boolean checkToken(String token) {
        try {
            byte[] sharedSecret = new byte[32];
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(sharedSecret);
           Boolean verify= signedJWT.verify(verifier);
            Date date = (Date) signedJWT.getJWTClaimsSet().getExpirationTime();
            if (date.after(new Date())&&verify.equals(true)) {
                return true;
            }

        } catch (ParseException e) {
            log.error(e.toString());
        } catch (JOSEException e) {
            log.error(e.toString());
        } catch (Exception e) {
            log.error(e.toString());
        }
        return false;
    }

    public Long getUserIdByToken(String token) {
        if (this.checkToken(token)) {
            try {
                SignedJWT signedJWT = SignedJWT.parse(token);
                Long id = (Long) signedJWT.getJWTClaimsSet().getClaim("id");
                return id;
            } catch (ParseException e) {
                log.error(e.toString());
            } catch (Exception e) {
                log.error(e.toString());
            }
        }
        return null;
    }
}
