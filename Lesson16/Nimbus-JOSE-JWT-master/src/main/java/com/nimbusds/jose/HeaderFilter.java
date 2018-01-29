package com.nimbusds.jose;


import java.util.Set;


/**
 * Javascript Object Signing and Encryption (JOSE) header filter. Specifies the
 * accepted header parameters.
 *
 * @author Vladimir Dzhuvinov
 * @version $version$ (2012-10-04)
 */
public interface HeaderFilter {


	/**
	 * Gets the names of the accepted header parameters.
	 *
	 * @return The accepted header parameters as a read-only set. Must 
	 *         contain at least the {@code alg} parameter for JWS headers or
	 *         the {@code alg} and {@code enc} parameters for JWE headers.
	 */
	public Set<String> getAcceptedParameters();
}
