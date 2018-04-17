package com.klt.faced;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.klt.faced.impl.PepoleServiceImpl;


public class ProxyDemo implements InvocationHandler{
	private PepoleSevice target;
	
	public ProxyDemo(){
		
	}
	
	public ProxyDemo(PepoleSevice target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(target, args);
		return result;
	}
	
	public static void main(String[] args) {
		PepoleServiceImpl impl = new PepoleServiceImpl();
		ProxyDemo demo = new ProxyDemo(impl);
		PepoleSevice pepoleSevice = (PepoleSevice)Proxy.newProxyInstance(impl.getClass().getClassLoader(), impl.getClass().getClasses(), demo);
		pepoleSevice.sing();
	}

}
