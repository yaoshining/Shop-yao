package com.yao.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.util.FileCopyUtils;

/**
 * Implementation of {@link org.springframework.http.converter.HttpMessageConverter} that can read and write strings.
 * <p>By default, this converter supports all media types (<code>&#42;&#47;&#42;</code>), and writes with a {@code
 * Content-Type} of {@code text/plain}. This can be overridden by setting the {@link
 * #setSupportedMediaTypes(java.util.List) supportedMediaTypes} property.</p>
 * <p>Has a second constructor which can modify the defaultCharset.</p>
 *
 * @author yaoshining
 * @since 3.0
 *
 */
public class ConfigurableStringHttpMessageConverter extends AbstractHttpMessageConverter<String>{

	private final List<Charset> availableCharsets;
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public ConfigurableStringHttpMessageConverter() {
        this(DEFAULT_CHARSET);
    }

    public ConfigurableStringHttpMessageConverter(Charset defaultCharset) {
        super(new MediaType("text", "plain", defaultCharset), new MediaType("*", "*", defaultCharset), MediaType.ALL);
        this.availableCharsets = new ArrayList<Charset>(Charset.availableCharsets().values());
	}
    
	@Override
	protected boolean supports(Class<?> clazz) {
		return String.class.equals(clazz);
	}
	
	@Override
	public String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException {
		MediaType contentType = inputMessage.getHeaders().getContentType();
		Charset charset = contentType.getCharSet() != null ? contentType.getCharSet() : DEFAULT_CHARSET;
		return FileCopyUtils.copyToString(new InputStreamReader(inputMessage.getBody(), charset));
	}

	@Override
	protected Long getContentLength(String s, MediaType contentType) {
		if (contentType != null && contentType.getCharSet() != null) {
			Charset charset = contentType.getCharSet();
			try {
				return (long) s.getBytes(charset.name()).length;
			}
			catch (UnsupportedEncodingException ex) {
				// should not occur
				throw new InternalError(ex.getMessage());
			}
		}
		else {
			return null;
		}
	}

	@Override
	protected void writeInternal(String s, HttpOutputMessage outputMessage) throws IOException {
		outputMessage.getHeaders().setAcceptCharset(getAcceptedCharsets());
		MediaType contentType = outputMessage.getHeaders().getContentType();
		Charset charset = contentType.getCharSet() != null ? contentType.getCharSet() : DEFAULT_CHARSET;
		FileCopyUtils.copy(s, new OutputStreamWriter(outputMessage.getBody(), charset));
	}

	/**
	 * Return the list of supported {@link Charset}.
	 *
	 * <p>By default, returns {@link Charset#availableCharsets()}. Can be overridden in subclasses.
	 *
	 * @return the list of accepted charsets
	 */
	protected List<Charset> getAcceptedCharsets() {
		return this.availableCharsets;
	}

}
