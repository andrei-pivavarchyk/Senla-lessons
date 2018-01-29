package com.nimbusds.jose;


import java.text.ParseException;

import net.jcip.annotations.ThreadSafe;

import com.nimbusds.jose.util.Base64URL;


/**
 * JSON Web Encryption (JWE) object. This class is thread-safe.
 *
 * @author Vladimir Dzhuvinov
 * @version $version$ (2012-10-23)
 */
@ThreadSafe
public class JWEObject extends JOSEObject {


	/**
	 * Enumeration of the states of a JSON Web Encryption (JWE) object.
	 */
	public static enum State {
	
		
		/**
		 * The JWE object is created but not encrypted yet.
		 */
		UNENCRYPTED,
		
		
		/**
		 * The JWE object is encrypted.
		 */
		ENCRYPTED,
		
		
		/**
		 * The JWE object is decrypted.
		 */
		DECRYPTED;
	}
	
	
	/**
	 * The header.
	 */
	private final JWEHeader header;
	
	
	/** 
	 * The encrypted key, {@code null} if not computed or applicable.
	 */
	private Base64URL encryptedKey;
	
	
	/**
	 * The initialisation vector, {@code null} if not generated or 
	 * applicable.
	 */
	private Base64URL initializationVector;
	
	
	/**
	 * The cipher text, {@code null} if not computed.
	 */
	private Base64URL cipherText;
	
	
	/**
	 * The integrity value, {@code null} if not computed or applicable.
	 */
	private Base64URL integrityValue;
	
	
	/**
	 * The JWE object state.
	 */
	private State state;
	
	
	/**
	 * Creates a new to-be-encrypted JSON Web Encryption (JWE) object with 
	 * the specified header and payload. The initial state will be 
	 * {@link State#UNENCRYPTED unencrypted}.
	 *
	 * @param header  The JWE header. Must not be {@code null}.
	 * @param payload The payload. Must not be {@code null}.
	 */
	public JWEObject(final JWEHeader header, Payload payload) {
	
		if (header == null)
			throw new IllegalArgumentException("The JWE header must not be null");
			
		this.header = header;
		
		if (payload == null)
			throw new IllegalArgumentException("The payload must not be null");
		
		setPayload(payload);
		
		encryptedKey = null;
		
		cipherText = null;
		
		state = State.UNENCRYPTED;
	}
	
	
	/**
	 * Creates a new encrypted JSON Web Encryption (JWE) object with the 
	 * specified serialised parts. The state will be {@link State#ENCRYPTED 
	 * encrypted}.
	 *
	 * @param firstPart  The first part, corresponding to the JWE header. 
	 *                   Must not be {@code null}.
	 * @param secondPart The second part, corresponding to the encrypted 
	 *                   key. Empty or {@code null} if none.
	 * @param thirdPart  The third part, corresponding to the initialisation
	 *                   vector. Empty or {@code null} if none.
	 * @param fourthPart The fourth part, corresponding to the cipher text.
	 *                   Must not be {@code null}.
	 * @param fifthPart  The fifth part, corresponding to the integrity
	 *                   value. Empty of {@code null} if none.
	 *
	 * @throws ParseException If parsing of the serialised parts failed.
	 */
	public JWEObject(final Base64URL firstPart, 
	                 final Base64URL secondPart, 
	                 final Base64URL thirdPart,
	                 final Base64URL fourthPart,
	                 final Base64URL fifthPart)
		throws ParseException {
	
		if (firstPart == null)
			throw new IllegalArgumentException("The first part must not be null");
		
		try {
			this.header = JWEHeader.parse(firstPart);
			
		} catch (ParseException e) {
		
			throw new ParseException("Invalid JWE header: " + e.getMessage(), 0);
		}
		
		if (secondPart == null || secondPart.toString().isEmpty())
			initializationVector = null;
		else
			initializationVector = secondPart;
		
		if (thirdPart == null || thirdPart.toString().isEmpty())
			encryptedKey = null;
		else
			encryptedKey = secondPart;
	
		if (fourthPart == null)
			throw new IllegalArgumentException("The fourth part must not be null");
		
		cipherText = fourthPart;
		
		if (fifthPart == null || fifthPart.toString().isEmpty())
			integrityValue = null;
		else
			integrityValue = fifthPart;
		
		state = State.ENCRYPTED; // but not decrypted yet!

		setParsedParts(firstPart, secondPart, thirdPart, fourthPart, fifthPart);
	}
	
	
	@Override
	public ReadOnlyJWEHeader getHeader() {
	
		return header;
	}
	
	
	/**
	 * Gets the encrypted key of this JWE object.
	 *
	 * @return The encrypted key, {@code null} not applicable or the JWE
	 *         object has not been encrypted yet.
	 */
	public Base64URL getEncryptedKey() {
	
		return encryptedKey;
	}
	
	
	/**
	 * Gets the initialisation vector (IV) of this JWE object.
	 *
	 * @return The initialisation vector (IV), {@code null} if not 
	 *         applicable or the JWE object has not been encrypted yet.
	 */
	public Base64URL getInitializationVector() {
	
		return initializationVector;
	}
	
	
	/**
	 * Gets the cipher text of this JWE object.
	 *
	 * @return The cipher text, {@code null} if the JWE object has not been
	 *         encrypted yet.
	 */
	public Base64URL getCipherText() {
	
		return cipherText;
	}
	
	
	/**
	 * Gets the integrity value of this JWE object.
	 *
	 * @return The integrity value, {@code null} if not applicable or the 
	 *         JWE object has not been encrypted yet.
	 */
	public Base64URL getIntegrityValue() {
	
		return integrityValue;
	}
	
	
	/**
	 * Gets the state of this JWE object.
	 *
	 * @return The state.
	 */
	public State getState() {
	
		return state;
	}
	
	
	/**
	 * Ensures the current state is {@link State#UNENCRYPTED unencrypted}.
	 *
	 * @throws IllegalStateException If the current state is not 
	 *                               unencrypted.
	 */
	private void ensureUnencryptedState() {
	
		if (state != State.UNENCRYPTED)
			throw new IllegalStateException("The JWE object must be in an unencrypted state");
	}
	
	
	/**
	 * Ensures the current state is {@link State#ENCRYPTED encrypted}.
	 *
	 * @throws IllegalStateException If the current state is not encrypted.
	 */
	private void ensureEncryptedState() {
	
		if (state != State.ENCRYPTED)
			throw new IllegalStateException("The JWE object must be in an encrypted state");
	}
	
	
	/**
	 * Ensures the current state is {@link State#ENCRYPTED encrypted} or
	 * {@link State#DECRYPTED decrypted}.
	 *
	 * @throws IllegalStateException If the current state is not encrypted 
	 *                               or decrypted.
	 */
	private void ensureEncryptedOrDecryptedState() {
	
		if (state != State.ENCRYPTED && state != State.DECRYPTED)
			throw new IllegalStateException("The JWE object must be in an encrypted or decrypted state");
	}
	
	
	/**
	 * Ensures the specified JWE encrypter supports the algorithms of this 
	 * JWE object.
	 *
	 * @throws JOSEException If the JWE algorithms are not supported.
	 */
	private void ensureJWEEncrypterSupport(final JWEEncrypter encrypter)
		throws JOSEException {
	
		if (! encrypter.supportedAlgorithms().contains(getHeader().getAlgorithm())) {
		
			throw new JOSEException("The \"" + getHeader().getAlgorithm() + 
			                        "\" algorithm is not supported by the JWE encrypter");
		}
		
		if (! encrypter.supportedEncryptionMethods().contains(getHeader().getEncryptionMethod())) {
		
			throw new JOSEException("The \"" + getHeader().getEncryptionMethod() + 
			                        "\" encryption method is not supported by the JWE encrypter");
		}
	}
	
	
	/**
	 * Ensures the specified JWE decrypter accepts the algorithms and the 
	 * headers of this JWE object.
	 *
	 * @throws JOSEException If the JWE algorithms or headers are not 
	 *                       accepted.
	 */
	private void ensureJWEDecrypterAcceptance(final JWEDecrypter decrypter)
		throws JOSEException {
		
		JWEHeaderFilter filter = decrypter.getJWEHeaderFilter();
		
		if (filter == null)
			return;
		
		
		if (! filter.getAcceptedAlgorithms().contains(getHeader().getAlgorithm())) {
		
			throw new JOSEException("The \"" + getHeader().getAlgorithm() + 
			                        "\" algorithm is not accepted by the JWE decrypter");
		}
		
		
		if (! filter.getAcceptedEncryptionMethods().contains(getHeader().getEncryptionMethod())) {
		
			throw new JOSEException("The \"" + getHeader().getEncryptionMethod() + 
			                        "\" encryption method is not accepted by the JWE decrypter");
		}		
		
		// Header params
		
		if (! filter.getAcceptedParameters().containsAll(getHeader().getIncludedParameters())) {
		
			throw new JOSEException("One or more header parameters not accepted by the JWE decrypter");
		}
	}
	
	
	/**
	 * Encrypts this JWE object with the specified encrypter. The JWE object
	 * must be in an {@link State#UNENCRYPTED unencrypted} state.
	 *
	 * @param encrypter The JWE encrypter. Must not be {@code null}.
	 *
	 * @throws IllegalStateException If the JWE object is not in an 
	 *                               {@link State#UNENCRYPTED unencrypted
	 *                               state}.
	 * @throws JOSEException         If the JWE object couldn't be 
	 *                               encrypted.
	 */
	public synchronized void encrypt(final JWEEncrypter encrypter)
		throws JOSEException {
	
		ensureUnencryptedState();
		
		ensureJWEEncrypterSupport(encrypter);
		
		JWECryptoParts parts = encrypter.encrypt(getHeader(), getPayload().toBytes());
		
		encryptedKey = parts.getEncryptedKey();
		initializationVector = parts.getInitializationVector();
		cipherText = parts.getCipherText();
		integrityValue = parts.getIntegrityValue();
		
		state = State.ENCRYPTED;
	}
	
	
	/**
	 * Decrypts this JWE object with the specified decrypter. The JWE object
	 * must be in a {@link State#ENCRYPTED encrypted} state.
	 *
	 * @param decrypter The JWE decrypter. Must not be {@code null}.
	 *
	 * @throws IllegalStateException If the JWE object is not in an 
	 *                               {@link State#ENCRYPTED encrypted
	 *                               state}.
	 * @throws JOSEException         If the JWE object couldn't be 
	 *                               decrypted.
	 */
	public synchronized void decrypt(final JWEDecrypter decrypter)
		throws JOSEException {
		
		ensureEncryptedState();
		
		ensureJWEDecrypterAcceptance(decrypter);
		
		setPayload(new Payload(decrypter.decrypt(getHeader(), 
		                                         getEncryptedKey(), 
							 getInitializationVector(),
							 getCipherText(), 
							 getIntegrityValue())));
		
		state = State.DECRYPTED;
	}
	
	
	/**
	 * Serialises this JWE object to its compact format consisting of 
	 * Base64URL-encoded parts delimited by period ('.') characters. It must 
	 * be in a {@link State#ENCRYPTED encrypted} or 
	 * {@link State#DECRYPTED decrypted} state.
	 *
	 * <pre>
	 * [header-base64url].[encryptedKey-base64url].[iv-base64url].[cipherText-base64url].[integrityValue-base64url]
	 * </pre>
	 *
	 * @return The serialised JWE object.
	 *
	 * @throws IllegalStateException If the JWE object is not in a 
	 *                               {@link State#ENCRYPTED encrypted} or
	 *                               {@link State#DECRYPTED decrypted 
	 *                               state}.
	 */
	@Override
	public String serialize() {
	
		ensureEncryptedOrDecryptedState();
		
		StringBuilder sb = new StringBuilder(header.toBase64URL().toString());
		sb.append('.');
		
		if (encryptedKey != null)
			sb.append(encryptedKey.toString());
		
		sb.append('.');
		
		if (initializationVector != null)
			sb.append(initializationVector.toString());
		
		sb.append('.');
		
		sb.append(cipherText.toString());
		
		sb.append('.');
		
		if (integrityValue != null)
			sb.append(integrityValue.toString());
		
		return sb.toString();
	}
	
	
	/**
	 * Parses a JWE object from the specified string in compact form. The 
	 * parsed JWE object will be given an {@link State#ENCRYPTED} state.
	 *
	 * @param s The string to parse. Must not be {@code null}.
	 *
	 * @return The JWE object.
	 *
	 * @throws ParseException If the string couldn't be parsed to a valid JWE
	 *                        object.
	 */
	public static JWEObject parse(String s)
		throws ParseException {
	
		Base64URL[] parts = JOSEObject.split(s);
		
		if (parts.length != 5)
			throw new ParseException("Unexpected number of Base64URL parts, must be five", 0);
		
		return new JWEObject(parts[0], parts[1], parts[2], parts[3], parts[4]);
	}
}
