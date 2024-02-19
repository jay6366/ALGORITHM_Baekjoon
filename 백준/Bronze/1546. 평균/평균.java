import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int numbers [] = new int[N];
        for(int i=0; i<N; i++){
            numbers[i] = sc.nextInt();
        }
        int max = 0;
        int sum = 0;
        for(int i=0; i<N; i++){
            if(max < numbers[i]){
                max = numbers[i];
            }
            sum += numbers[i];
        }
        
        System.out.println(sum*100.0/max/N);
    }
}