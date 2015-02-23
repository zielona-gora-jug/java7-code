package pl.dmaksylewicz.java7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {

	private final static int PARALLELISM_LEVEL = 4;

	public static void main(String[] args) {
		MyRecursiveTask myRecursiveTask = new ForkJoin().new MyRecursiveTask(12);
		long result = new ForkJoinPool(PARALLELISM_LEVEL).invoke(myRecursiveTask);
		System.out.println("result = " + result);
	}

	@SuppressWarnings("serial")
	private class MyRecursiveTask extends RecursiveTask<Long> {

		private int workload = 0;

		public MyRecursiveTask(int workload) {
			super();
			this.workload = workload;
		}

		@Override
		protected Long compute() {
			if (this.workload > 2) {
				System.out.println("current thread -> " + Thread.currentThread().getName() + ", split workload -> " + this.workload);
				List<MyRecursiveTask> subtasks = new ArrayList<MyRecursiveTask>();
				subtasks.addAll(createSubtasks());
				for (MyRecursiveTask subtask : subtasks) {
					subtask.fork();
				}
				long result = 0;
				for (MyRecursiveTask subtask : subtasks) {
					result += subtask.join();
					System.out.println("join -> " + result);
				}
				// System.out.println("split work result = " + result);
				return result;
			} else {
				// System.out.println("do final workload -> " + workload);
				return (long) workload;
			}
		}

		private List<MyRecursiveTask> createSubtasks() {
			List<MyRecursiveTask> subtasks = new ArrayList<MyRecursiveTask>();
			subtasks.add(new MyRecursiveTask(this.workload / 2));
			subtasks.add(new MyRecursiveTask(this.workload / 2));
			return subtasks;
		}
	}
}