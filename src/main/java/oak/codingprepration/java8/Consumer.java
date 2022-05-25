package oak.codingprepration.java8;

import java.util.List;

public class Consumer  implements  Runnable {
	
	List<String> list;
	Consumer(List<String> list)
	{
		this.list=list;
	}
	
public void run() {
	while (true) {
        try {
            System.out.println("Consumed: " + consume());
            Thread.sleep(50);
        } catch (InterruptedException ex) {}

 }
	 }

private String consume() throws InterruptedException {
    //wait if the queue is empty
    while (list.isEmpty()) {
        synchronized (list) {
            System.out.println("The queue is empty " + Thread.currentThread().getName()
                                + " is waiting , size: " + list.size());

            list.wait();
        }
    }

    //Otherwise consume element and notify the waiting producer
    synchronized (list) {
        list.notifyAll();
        return  list.remove(0);
    }
}

}
