package oak.codingprepration.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import java.util.stream.Stream;


public class ThreadPractice implements Callable<Integer>
{
	Logger log=Logger.getLogger("ThreadPractice");
	Path path = Paths.get("src/main/resources/number.txt");
	public static Object lockingObject=new Object();
	public ThreadPractice() {
	}
	public ThreadPractice(int param) {
		this.param=param;
	}

	private int param;
   
	@Override
	public  Integer call() throws Exception {
		try {
			synchronized (lockingObject) {
    		Stream<String> stream = Files.lines(path);
    		int numberInfile=Integer.parseInt(stream.findFirst().get());
    		stream.close();
    		log.info("param:"+param+" number in file:"+numberInfile+" Thread name:"+Thread.currentThread().getName());
			Files.write(path, String.valueOf(numberInfile+param).getBytes());
			int savedNumber= Integer.parseInt(Files.lines(path).findFirst().get());
			return savedNumber;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
   return 0;
	}
 
 public static void main(String[] args) throws InterruptedException, ExecutionException {
	 ThreadPractice practice =new ThreadPractice();
	 practice.defaultNumber(100);
	 practice.ExecutorFrameworkPractice();
 }
 
private void ExecutorFrameworkPractice() throws InterruptedException, ExecutionException
{
	  ExecutorService executor = Executors.newFixedThreadPool(5);
	  List<Future<Integer>> futureList= new ArrayList<Future<Integer>>();
	  for(int i=0;i<5;i++)
	  {
		  Callable<Integer> thread=new ThreadPractice(i);
		  Future<Integer> future= executor.submit(thread);
		  futureList.add(future);
		 
	  }
	  executor.shutdown();
	  futureList.stream().forEach(value->{
		 try {
			System.out.println("future value:"+value.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
	  });
	  
	    
	    	
}

public  void defaultNumber(int number)
{
    try {
		Files.write(path, String.valueOf(number).getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
}


	

}
