import java.util.Random;

public class marksix {
    public static void main(String[] args) {
        int counter = 0;
        int[] marksixNumbers = new int[6];
        
        while (counter < 6) {
            int number = new Random().nextInt(49) + 1;
            boolean isDuplicate = false;
            
            for (int i = 0; i < counter; i++) {
                if (marksixNumbers[i] == number) {
                    isDuplicate = true;
                    break;
                }
            }
            
            if (isDuplicate) {
                continue;
            }
            
            marksixNumbers[counter] = number;
            counter++;
        }
        
        System.out.println("Mark Six Numbers:");
        for (int i = 0; i < marksixNumbers.length; i++) {
            System.out.print(marksixNumbers[i] + " ");
        }
    }
}