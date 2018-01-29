package com.nimbusds.jose;


import java.text.ParseException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import net.minidev.json.JSONObject;

import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.JSONObjectUtils;


/**
 * The base abstract class for plaintext, JSON Web Signature (JWS) and JSON Web 
 * Encryption (JWE) headers.
 *
 * <p>The header may also carry {@link #setCustomParameters custom parameters};
 * these will be serialised and parsed along the reserved ones.
 *
 * @author Vladimir Dzhuvinov
 * @version $version$ (2012-10-01)
 */
public abstract class Header implements ReadOnlyHeader {
	
	
	/**
	 * The algorithm ({@code alg}) parameter.
	 */
	final protected Algorithm alg;
	
	
	/**
	 * The JOSE object type ({@code typ}) parameter.
	 */
	private JOSEObjectType typ;
	
	
	/**
	 * The content type ({@code cty}) parameter.
	 */
	private String cty;
	
	
	/**
	 * Custom header parameters.
	 */
	private Map<String,Object> customParameters = new HashMap<String,Object>();
	
	
	/**
	 * Creates a new header with the specified algorithm ({@code alg}) 
	 * parameter.
	 *
	 * @param alg The algorithm parameter. Must not be {@code null}.
	 */
	protected Header(final Algorithm alg) {
	
		if (alg == null)
			throw new IllegalArgumentException("The algorithm \"alg\" header parameter must not be null");
		
		this.alg = alg;
	}
	
	
	@Override
	public JOSEObjectType getType() {
	
		return typ;
	}
	
	
	/**
	 * Sets the type ({@code typ}) parameter.
	 *
	 * @param typ The type parameter, {@code null} if not specified.
	 */
	public void setType(final JOSEObjectType typ) {
	
		this.typ = typ;
	}
	
	
	@Override
	public String getContentType() {
	
		return cty;
	}
	
	
	/**
	 * Sets the content type ({@code cty}) parameter.
	 *
	 * @param cty The content type parameter, {@code null} if not specified.
	 */
	public void setContentType(final String cty) {
	
		this.cty = cty;
	}
	
	
	@Override
	public Object getCustomParameter(final String name) {
		
		return customParameters.get(name);
	}
	
	
	/**
	 * Sets a custom (non-reserved) parameter. Callers and extending classes
	 * should ensure the parameter name doesn't match a reserved parameter 
	 * name.
	 *
	 * @param name  The name of the custom parameter. Must not match a 
	 *              reserved parameter name and must not be {@code null}.
	 * @param value The value of the custom parameter, should map to a valid
	 *              JSON entity, {@code null} if not specified.
	 */
	protected void setCustomParameter(final String name, final Object value) {
	
		customParameters.put(name, value);
	}
	
	
	@Override
	public Map<String,Object> getCustomParameters() {
	
		return Collections.unmodifiableMap(customParameters);
	}
	
	
	/**
	 * Sets the custom (non-reserved) parameters. The values must be 
	 * serialisable to a JSON entity, otherwise will be ignored.
	 *
	 * @param customParameters The custom parameters, empty map or 
	 *                         {@code null} if none.
	 */
	public void setCustomParameters(final Map<String,Object> customParameters) {
	
		if (customParameters == null)
			return;
			
		this.customParameters = customParameters;
	}
	
	
	@Override
	public JSONObject toJSONObject() {
	
		// Include custom parameters, they will be overwritten if their
		// names match specified reserved ones
		JSONObject o = new JSONObject(customParameters);
	
		// Alg is always defined
		o.put("alg", alg.toString());
	
		if (typ != null)
			o.put("typ", typ.toString());
		
		if (cty != null)
			o.put("cty", cty);
		
		return o;
	}
	
	
	/**
	 * Returns a JSON string representation of this header. All custom
	 * parameters will be included if they serialise to a JSON entity and 
	 * their names don't conflict with the reserved ones.
	 *
	 * @return The JSON string representation of this header.
	 */
	public String toString() {
	
		return toJSONObject().toString();
	}
	
	
	/**
	 * Returns a Base64URL representation of this header.
	 *
	 * @return The Base64URL representation of this header.
	 */
	public Base64URL toBase64URL() {
	
		return Base64URL.encode(toString());
	}
	
	
	/**
	 * Parses an algorithm ({@code alg}) parameter from the specified 
	 * header JSON object. Intended for initial parsing of plain, JWS and 
	 * JWE headers.
	 *
	 * <p>The algorithm type (none, JWS or JWE) is determined by inspecting
	 * the algorithm name for "none" and the presence of an "enc" parameter.
	 *
	 * @param json The JSON object to parse. Must not be {@code null}.
	 *
	 * @return The algorithm, an instance of {@link Algorithm#NONE},
	 *         {@link JWSAlgorithm} or {@link JWEAlgorithm}.
	 *
	 * @throws ParseException If the {@code alg} parameter couldn't be 
	 *                        parsed.
	 */
	public static Algorithm parseAlgorithm(final JSONObject json)
		throws ParseException {
		
		String algName = JSONObjectUtils.getString(json, "alg");
		
		// Infer algorithm type
		
		// Plain
		if (algName.equals(Algorithm.NONE.getName()))
			return Algorithm.NONE;
		
		// JWE
		else if (json.containsKey("enc"))
			return JWEAlgorithm.parse(algName);
		
		// JWS
		else
			return JWSAlgorithm.parse(algName);
	}
	
	
	/**
	 * Parses a {@link PlainHeader}, {@link JWSHeader} or {@link JWEHeader} 
	 * from the specified JSON object.
	 *
	 * @param json The JSON object to parse. Must not be {@code null}.
	 *
	 * @return The header.
	 *
	 * @throws ParseException If the specified JSON object doesn't represent
	 *                        a valid header.
	 */
	public static Header parse(final JSONObject json)
		throws ParseException {
		
		Algorithm alg = parseAlgorithm(json);
		
		if (alg.equals(Algorithm.NONE))
			return PlainHeader.parse(json);
			
		else if (alg instanceof JWSAlgorithm)
			return JWSHeader.parse(json);
			
		else if (alg instanceof JWEAlgorithm)
			return JWEHeader.parse(json);
		
		else
			throw new AssertionError("Unexpected algorithm type: " + alg);
	}
}
