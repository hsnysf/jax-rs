package jaxrs.learn.interceptor;

import java.io.ByteArrayInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Provider
public class LoggingInterceptor implements ReaderInterceptor, WriterInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		
		InputStream stream = context.getInputStream();
		
		byte bytes[] = stream.readAllBytes();
		
		String content = new String(bytes);
		
		System.out.println("request == " + content);
		
		context.setInputStream(new ByteArrayInputStream(bytes));
		
		return context.proceed();
	}
	
	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		
		context.setOutputStream(new FilterOutputStream(context.getOutputStream()) {
			
			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				
				super.write(b, off, len);
				
				System.out.println("response == " + new String(b));
			}
		});
		
		context.proceed();
	}
}
