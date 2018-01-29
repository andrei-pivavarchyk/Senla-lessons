package com.nimbusds.jose.crypto;


import java.util.HashSet;
import java.util.Set;

import java.security.Signature;
import java.security.InvalidKeyException;
import java.security.SignatureException;

import java.security.interfaces.RSAPublicKey;

import net.jcip.annotations.ThreadSafe;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeaderFilter;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.ReadOnlyJWSHeader;

import com.nimbusds.jose.util.Base64URL;



/**
 * RSA Signature-Scheme-with-Appendix (RSASSA) verifier of 
 * {@link com.nimbusds.jose.JWSObject JWS objects}. This class is thread-safe.
 *
 * <p>Supports the following JSON Web Algorithms (JWAs):
 *
 * <ul>
 *     <li>{@link com.nimbusds.jose.JWSAlgorithm#RS256}
 *     <li>{@link com.nimbusds.jose.JWSAlgorithm#RS384}
 *     <li>{@link com.nimbusds.jose.JWSAlgorithm#RS512}
 * </ul>
 *
 * <p>Accepts the following JWS header parameters:
 *
 * <ul>
 *     <li>{@code alg}
 *     <li>{@code typ}
 *     <li>{@code cty}
 * </ul>
 * 
 * @author Vladimir Dzhuvinov
 * @version $version$ (2012-10-23)
 */
@ThreadSafe
public class RSASSAVerifier extends RSASSAProvider implements JWSVerifier {


	/**
	 * The accepted JWS header parameters.
	 */
	private static final Set<String> ACCEPTED_HEADER_PARAMETERS;
	
	
	/**
	 * Initialises the accepted JWS header parameters.
	 */
	static {
	
		Set<String> params = new HashSet<String>();
		params.add("alg");
		params.add("typ");
		params.add("cty");
		
		ACCEPTED_HEADER_PARAMETERS = params;
	}
	
	
	/**
	 * The JWS header filter.
	 */
	private DefaultJWSHeaderFilter headerFilter;
	
	
	/**
	 * The public RSA key.
	 */
	private final RSAPublicKey publicKey;
	
	
	/**
	 * Creates a new RSA Signature-Scheme-with-Appendix (RSASSA) verifier.
	 *
	 * @param publicKey The public RSA key. Must not be {@code null}.
	 */
	public RSASSAVerifier(final RSAPublicKey publicKey) {

		if (publicKey == null)
			throw new IllegalArgumentException("The public RSA key must not be null");
		
		this.publicKey = publicKey;
		
		headerFilter = new DefaultJWSHeaderFilter(supportedAlgorithms(), ACCEPTED_HEADER_PARAMETERS);
	}
	
	
	/**
	 * Gets the public RSA key.
	 *
	 * @return The public RSA key.
	 */
	public RSAPublicKey getPublicKey() {
	
		return publicKey;
	}
	
	
	@Override
	public JWSHeaderFilter getJWSHeaderFilter() {
	
		return headerFilter;
	}


	@Override
	public boolean verify(final ReadOnlyJWSHeader header, 
	                      final byte[] signedContent, 
	                      final Base64URL signature)
		throws JOSEException {
		
		Signature verifier = getRSASignerAndVerifier(header.getAlgorithm());
		
		try {
			verifier.initVerify(publicKey);
			verifier.update(signedContent);
			return verifier.verify(signature.decode());
			
		} catch (InvalidKeyException e) {
		
			throw new JOSEException("Invalid public RSA key: " + e.getMessage(), e);
		
		} catch (SignatureException e) {
		
			throw new JOSEException("RSA signature exception: " + e.getMessage(), e);
		}
	}
}
