package pl.dmaksylewicz.java7.invokedynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class DynamicInvocation {

	public static void jump(String name) {
		System.out.println("jump jump Kris Kross will make ya ! jump jump " + name);
	}

	// at runtime, a call site (main method) is bound to a method handle by
	// bootstrap method
	public static void main(String[] args) throws Throwable {
		// a factory for creating method's handler, used for search targets,
		// accessible from caller's context
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle methodHandle = lookup.findStatic(DynamicInvocation.class, "jump", MethodType.methodType(void.class, String.class));
		String name = "Dejwww...";
		methodHandle.invokeExact(name);
	}
}
