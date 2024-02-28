import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-1-i; j++){
                if(numbers[j]>numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        for(int i=0; i<N; i++){
            System.out.println(numbers[i]);
        }
    }
}