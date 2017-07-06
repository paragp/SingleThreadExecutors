package com.threading.singleThread.tasks;

import java.util.List;

public class RunnableList implements Runnable {

	private List<Runnable> runnableList;
	
	public RunnableList(List<Runnable> runnables) {
		// TODO Auto-generated constructor stub
		this.runnableList=runnables;
	}

	public void setRunnableList(List<Runnable> runnableList) {
		this.runnableList = runnableList;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(Runnable runnable: runnableList)
		{
			new Thread(runnable).start();
		}
	}
	

}


