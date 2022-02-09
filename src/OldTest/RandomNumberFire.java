package OldTest;

public class RandomNumberFire {
    private static final int GENERATE_PER_SECOND = 5;

    public static void main(String[] args) {
        generateRandomNumber();
    }

    private static void generateRandomNumber(){
        while (true){
            Integer i = (int)(Math.random() * 1000);
            System.out.println(i);
            try {
                Thread.sleep((long) 1000/GENERATE_PER_SECOND);
            } catch (InterruptedException e){
                System.out.println("Interrupt");
            }
        }
    }
}
