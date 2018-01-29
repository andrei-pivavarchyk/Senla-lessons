package com.nimbusds.jose.util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.zip.DeflaterInputStream;
import java.util.zip.DeflaterOutputStream;


/**
 * Deflate (RFC 1951) utilities.
 *
 * @author Vladimir Dzhuvinov
 * @version $version$ (2012-09-17)
 */
public class DeflateUtils {


	/**
	 * Compresses the specified byte array according to the DEFLATE 
	 * specification (RFC 1951).
	 *
	 * @param bytes The byte array to compress. Must not be {@code null}.
	 *
	 * @return The compressed bytes.
	 *
	 * @throws IOException If compression failed.
	 */
	public static byte[] compress(final byte[] bytes)
		throws IOException {
	
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		DeflaterOutputStream def = new DeflaterOutputStream(out);
		def.write(bytes);
		def.close();
		
		return out.toByteArray();
	}
	
	
	/**
	 * Decompresses the specified byte array according to the DEFLATE
	 * specification (RFC 1951).
	 *
	 * @param bytes The byte array to decompress. Must not be {@code null}.
	 *
	 * @return The decompressed bytes.
	 *
	 * @throws IOException If decompression failed.
	 */
	public static byte[] decompress(final byte[] bytes)
		throws IOException {
		
		DeflaterInputStream def = new DeflaterInputStream(new ByteArrayInputStream(bytes));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		// Transfer bytes from the compressed array to the output
		byte[] buf = new byte[1024];
		
		int len;
		
		while ((len = def.read(buf)) > 0)
			out.write(buf, 0, len);
 
		def.close();
		out.close();
		
		return out.toByteArray();
	}


	/**
	 * Prevents instantiation.
	 */
	private DeflateUtils() {
	
	}
}
