package com.threading.singleThread.tasks;


public class Runnable2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Executing Runnable2");
		try{
			Thread.sleep(1000);
			
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		
	}

}


