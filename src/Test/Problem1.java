package Test;

/*class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("test : " + Thread.currentThread().getName());
    }
}*/


/*class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("test : " + Thread.currentThread().getName());
    }
}*/

public class Problem1 {
    public static void main(String[] args) {
        /*Thread thread1 = new Thread(() -> {
            task1();
        });

        Thread thread2 = new Thread(() -> {
            task2();
        });

        thread1.start();
        thread2.start();*/
        Thread thread = new Thread();
        thread.start();

        //Task 1 20 sec  // T1 -> 2nd sec + 18sec // 0th sec
        //Task 2 20 sec // 3rd Sec

        //40 Sec Sync, Indep 20 sec, Dep 40, Dep with Sync 23 Sec

        //T1 -> T2

        /*
        1 -> 1000
        T2 1 - 1000 // 20 sec

        //20 Sec
        18 sec + 2 s
        T1 1-> 499 T1.join    500-> 1000

        22 Sec


         */

        //T1
        /*
        1
        2 -> Imp task for T2
        synchronized {
            //notify, All, wait()
            3 notifyAll students
        }
        4
        5
        1000
         */

        //T2 -> T1

    }


    private static void task1(){
        for(int i = 0; i < 10; i++){
            System.out.println("Task 1 Thread "+Thread.currentThread().getName() + " "+i);
        }
    }

    private static void task2(){
        for(int i = 0; i < 10; i++){
            System.out.println("Task 2 Thread "+Thread.currentThread().getName() + " "+i);

        }
    }
}
    