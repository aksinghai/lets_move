package OldTest;

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueueDemo {

    Queue<Integer> queue = new LinkedList<>();
    int size = 10;
    int  i = 0;
    int j = 0;
    public void producer(){
        while (j < 50){
            synchronized (this){
                if(queue.size() > size){
                    try {
                        this.wait();
                    } catch (InterruptedException e){
                        System.out.println("Interrupt");
                    }
                } else {
                    System.out.println("produced"+ i);
                    queue.add(i++);
                    this.notify();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            j++;
        }
    }

    public void consumer(){
        while (j < 50){
            synchronized (this){
                if(!queue.isEmpty()){
                    System.out.println("Thread "+Thread.currentThread().getName() +" "+ queue.poll());
                    this.notify();
                } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e){
                        System.out.println("Interrupt");
                    }
                }
            }
            j++;
        }
    }
}

public class BlockingQueueDemoProgram {
    public static void main(String[] args) {
        BlockingQueueDemo blockingQueueDemoProgram = new BlockingQueueDemo();
        Thread t1 = new Thread(()->{
             blockingQueueDemoProgram.consumer();
        });
        t1.setName("Thread 1");

        Thread t2 = new Thread(()->{
            blockingQueueDemoProgram.producer();
        });
        t2.setName("Thread 2");
        t1.start();
        t2.start();
    }
}
