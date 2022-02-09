package OldTest;

class DemoThreadApp {

    Integer i = 1;

    public void printOdd(){
        while (i <= 100) {
            synchronized (this){
                if(i % 2 != 0){
                    System.out.println(Thread.currentThread().getName()+" "+(i++));
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public void printEven(){
        while (i <= 100) {
            synchronized (this){
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName()+" "+(i++));
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class EvenOddDemo {
    public static void main(String[] args) {
        DemoThreadApp demoThreadApp = new DemoThreadApp();
        Thread t1 = new Thread(() -> demoThreadApp.printOdd());
        t1.setName("ODD: ");
        Thread t2 = new Thread(() -> demoThreadApp.printEven());
        t2.setName("EVEN: ");
        t1.start();
        t2.start();
    }
}
