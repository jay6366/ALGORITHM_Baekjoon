import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        
        int delta = a*e - b*d;
        int deltaX = c*e - b*f;
        int deltaY = a*f - c*d;
        
        int x = deltaX/delta;
        int y = deltaY/delta;
        
        System.out.println(x+" "+y);
                                   
    }
}
    