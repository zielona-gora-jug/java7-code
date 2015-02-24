package pl.dmaksylewicz.java7.invokedynamic;

public class BytecodeInstruction implements HelloInterface {

	private void hello1() {
		//
	}

	public void hello2() {
		//
	}

	public static void hello3() {
		//
	}

	@Override
	public void hello4() {
		//
	}

	public static void main(String[] args) {
		System.out.println("warming up...");
		BytecodeInstruction invocation = new BytecodeInstruction();
		// private
		invocation.hello1();
		// public
		invocation.hello2();
		// static
		BytecodeInstruction.hello3();
		// via interface
		HelloInterface invocationViaInterface = new BytecodeInstruction();
		invocationViaInterface.hello4();
		System.out.println("done !");
	}
}
