package com.mkyong.common.controller;

import com.mkyong.common.controller.dao.UserDAO;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

public class TokenService  {


    public String getToken(String username, String password) throws Exception {
        UserDAO userDAO=new UserDAO();

        if (username == null || password == null)
            return null;
        User user = userDAO.getEntityById(1);;
        Map<String, Object> tokenData = new HashMap<String,Object>();
        if (password.equals(user.getPassword())) {
            tokenData.put("clientType", "user");
            tokenData.put("userID", user.getId().toString());
            tokenData.put("username", user.getLogin());
            tokenData.put("token_create_date", new Date().getTime());
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 100);
            tokenData.put("token_expiration_date", calendar.getTime());
            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setExpiration(calendar.getTime());
            jwtBuilder.setClaims(tokenData);
            String key = "abc123";
            String token = jwtBuilder.signWith(SignatureAlgorithm.HS512, key).compact();





            Claims claims = new DefaultClaims();
            try{
                claims = Jwts.parser().setSigningKey("abc123").parseClaimsJws(token).getBody();
            } catch (SignatureException e){
                //Signature error
            }


//

            System.out.println(claims.get("username"));


            @SuppressWarnings("unchecked")
            ArrayList<String> perms = (ArrayList<String>) claims.get("perms");








            return token;
        } else {
            throw new Exception("Authentication error");
        }
    }

}
