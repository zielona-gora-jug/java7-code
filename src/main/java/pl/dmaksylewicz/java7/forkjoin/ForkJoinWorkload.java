package pl.dmaksylewicz.java7.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinWorkload {

	private final static int PARALLELISM_LEVEL = 4;
	private final static double WORKLOAD = 5.0;

	@SuppressWarnings("serial")
	private class CounterRecursiveTask extends RecursiveTask<Double> {

		private double workload = 0;

		public CounterRecursiveTask(double workload) {
			super();
			this.workload = workload;
		}

		@Override
		protected Double compute() {
			System.out.println("current thread name -> " + Thread.currentThread().getName() + ", workload -> " + this.workload);
			if (this.workload > 2) {
				// System.out.println("fork tasks with workload -> " + this.workload);
				List<CounterRecursiveTask> subtasks = new ArrayList<CounterRecursiveTask>();
				subtasks.addAll(createSubtasks());
				for (CounterRecursiveTask subtask : subtasks) {
					subtask.fork();
				}
				double result = 0.0;
				for (CounterRecursiveTask subtask : subtasks) {
					result += subtask.join();
				}
				System.out.println("joined tasks result -> " + result);
				return result;
			} else {
				System.out.println("single task result -> " + workload);
				return workload;
			}
		}

		private List<CounterRecursiveTask> createSubtasks() {
			List<CounterRecursiveTask> subtasks = new ArrayList<CounterRecursiveTask>();
			subtasks.add(new CounterRecursiveTask(this.workload / 2));
			subtasks.add(new CounterRecursiveTask(this.workload / 2));
			return subtasks;
		}
	}

	public static void main(String[] args) {
		CounterRecursiveTask recursiveTask = new ForkJoinWorkload().new CounterRecursiveTask(WORKLOAD);
		double result = new ForkJoinPool(PARALLELISM_LEVEL).invoke(recursiveTask);
		System.out.println("final result = " + result);
	}
}
