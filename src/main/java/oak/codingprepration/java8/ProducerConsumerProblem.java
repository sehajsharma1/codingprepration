package oak.codingprepration.java8;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerProblem 
{


public static void main(String[] args)
{
	List<String> list =new ArrayList<String>();
    Thread prodThread = new Thread(new Producer(list), "Producer");
    Thread consThread = new Thread(new Consumer(list), "Consumer");
    prodThread.start();
    consThread.start();
    System.out.println("hi");
}
	

}
