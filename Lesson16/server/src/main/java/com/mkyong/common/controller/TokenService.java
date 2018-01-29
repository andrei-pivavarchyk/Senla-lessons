package com.mkyong.common.controller;

import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class TokenService  {


    public String getToken(String username, String password) throws Exception {/*
        UserDAO userDAO=new UserDAO();

        if (username == null || password == null) {
            return null;
        }
        User user = userDAO.getEntityById(1);

        Map<String, Object> tokenData = new HashMap<String,Object>();
        if (password.equals(user.getPassword())) {


            tokenData.put("clientType", "user");
            tokenData.put("userID", user.getId().toString());
            tokenData.put("username", user.getLogin());
            tokenData.put("password", user.getPassword());
            tokenData.put("token_create_date", new Date().getTime());
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 2018);
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
*/

    }
    public String getToken(String email) throws NoSuchAlgorithmException {
        try {
            KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
            keyGenerator.initialize(1024);

            KeyPair kp = keyGenerator.genKeyPair();
            RSAPublicKey publicKey = (RSAPublicKey) kp.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) kp.getPrivate();

            System.out.println("publicKey: " + publicKey);
            System.out.println("privateKey: " + privateKey.toString());

            JWSSigner signer = new RSASSASigner(privateKey);

            JWTClaimsSet claimsSet = new JWTClaimsSet();
            claimsSet.setSubject("RTH");
            claimsSet.setCustomClaim("email", email);
            claimsSet.setCustomClaim("role", "USER");
            claimsSet.setIssuer("https://rth.com");
            claimsSet.setExpirationTime(new Date(new Date().getTime() + 60 * 1000));

            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), claimsSet);

            signedJWT.sign(signer);
            token = signedJWT.serialize();
            TokenSaverAndValidatorDAO tokenSaver = new TokenSaverAndValidatorDAO();
            tokenSaver.saveTokenToDB(email, token);

            signedJWT = SignedJWT.parse(token);

            JWSVerifier verifier = new RSASSAVerifier(publicKey);
            System.out.println("verifier: " + verifier);
            System.out.println("verify method: " + signedJWT.verify(verifier));
            assertTrue(signedJWT.verify(verifier));
            assertEquals("RTH", signedJWT.getJWTClaimsSet().getSubject());
            assertEquals("https://rth.com", signedJWT.getJWTClaimsSet().getIssuer());
            assertTrue(new Date().before(signedJWT.getJWTClaimsSet().getExpirationTime()));
        } catch (JOSEException | ParseException | NoSuchAlgorithmException ex) {
            Logger.getLogger(TokenProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return token;
    }
}

}
