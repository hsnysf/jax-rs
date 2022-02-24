package jaxrs.learn.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class MethodInterceptor {

	@AroundInvoke
	public Object aroundInvoke(InvocationContext context) throws Exception {

		System.out.println("MethodInterceptor before aroundInvoke == " + context.getTarget());
		
		Object object = context.proceed();
		
		System.out.println("MethodInterceptor after aroundInvoke == " + context.getTarget());
		
		return object;
	}
}
