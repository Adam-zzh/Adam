package com.huamiao.example.service.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author 邱润泽 bullock
 */
public class ForkJoinTest extends RecursiveTask<Integer> {

	private static final int THRESHOLD = 2;

	private int start, end;
	public ForkJoinTest(int start, int end){
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int result = 0;
		boolean canSplit = (end - start) > THRESHOLD;
		if (canSplit){
			int mid = (end - start) / 2;
			ForkJoinTest left = new ForkJoinTest(start, mid);
			ForkJoinTest right = new ForkJoinTest(mid +1, end);

			left.fork();
			right.fork();

			Integer leftSum = left.join();
			Integer rightSum = right.join();
			result = leftSum + rightSum;
		} else {
			for (int i = start; i <= end ; i++) {
				result += i;
			}
		}
		return result;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTest forkJoinTest = new ForkJoinTest(1, 4);
		System.out.println(pool.submit(forkJoinTest).get());
	}
}
