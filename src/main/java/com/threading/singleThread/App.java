package com.threading.singleThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.threading.singleThread.tasks.Runnable1;
import com.threading.singleThread.tasks.Runnable2;
import com.threading.singleThread.tasks.Runnable3;
import com.threading.singleThread.tasks.RunnableList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<>(5);
        RejectedExecutionHandler handleRejection = new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				// TODO Auto-generated method stub
				System.out.println(r.toString() +" rejected");
			}
		};
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, workingQueue);
		executor.prestartAllCoreThreads();
		
		List<Runnable> runnables = new ArrayList<Runnable>();
		runnables.add(new Runnable1());
		runnables.add(new Runnable2());
		runnables.add(new Runnable3());
		
		workingQueue.add(new RunnableList(runnables));
		
		
    }
}
