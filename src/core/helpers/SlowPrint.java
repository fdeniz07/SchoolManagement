package core.helpers;

public class SlowPrint {

    public static void slowPrint(String message, int delay){
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
