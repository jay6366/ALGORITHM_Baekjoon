import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int [] numbers = new int [3];
        for (int i=0; i<3; i++){
            numbers[i] = scanner.nextInt();
        }
        
        Arrays.sort(numbers);
        for (int number : numbers){
            System.out.print(number + " ");
        }
        scanner.close();      
    }
}