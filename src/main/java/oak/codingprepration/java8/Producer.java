package oak.codingprepration.java8;
import java.util.List;

public class Producer implements Runnable
{
	List<String> list;
	Producer(List<String> list)
	{
		this.list=list;
	}

	@Override
	public void run() {
		
		for(int i=0;i<=4;i++)
		{
			try {
				produce(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void produce(int i) throws InterruptedException {

        //wait if the queue is full
        while (list.size() == 5) {
            synchronized (list) {
                System.out.println("The queue is full " + Thread.currentThread().getName()
                                    + " is waiting , size: " + list.size());

                list.wait();
            }
        }

        //producing element and notify consumers
        synchronized (list) {
            list.add("abc"+i);
            list.notifyAll();
        }
    }
}
