package com.nimbusds.jose;


import java.util.Set;


/**
 * JSON Web Encryption (JWE) header filter. Specifies accepted JWE algorithms,
 * encryption methods, and header parameters.
 *
 * @author Vladimir Dzhuvinov
 * @version $version$ (2012-10-16)
 */
public interface JWEHeaderFilter extends HeaderFilter {


	/**
	 * Gets the names of the accepted JWE algorithms. These correspond to
	 * the {@code alg} JWE header parameter.
	 *
	 * @return The accepted JWE algorithms as a read-only set, empty set if 
	 *         none.
	 */
	public Set<JWEAlgorithm> getAcceptedAlgorithms();
	
	
	/**
	 * Sets the names of the accepted JWE algorithms. These correspond to 
	 * the {@code alg} JWE header parameter. 
	 *
	 * @param acceptedAlgs The accepted JWE algorithms. Must be a subset of
	 *                     the supported algorithms and not {@code null}.
	 */
	public void setAcceptedAlgorithms(Set<JWEAlgorithm> acceptedAlgs);
	
	
	/**
	 * Gets the names of the accepted encryption methods. These correspond 
	 * to the {@code enc} JWE header parameter.
	 *
	 * @return The accepted encryption methods as a read-only set, empty set
	 *         if none.
	 */
	public Set<EncryptionMethod> getAcceptedEncryptionMethods();
	
	
	
	/**
	 * Sets the names of the accepted encryption methods. These correspond 
	 * to the {@code enc} JWE header parameter.
	 *
	 * @param acceptedEncs The accepted encryption methods. Must be a subset
	 *                     of the supported encryption methods and not 
	 *                     {@code null}.
	 */
	public void setAcceptedEncryptionMethods(final Set<EncryptionMethod> acceptedEncs);
}
