import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] numbers = new int [str.length()];
        for(int i=0; i<str.length(); i++){
            numbers[i] = Integer.parseInt(str.substring(i,i+1));
        }
        for(int i=0; i<str.length(); i++){
            int max = i;
            for(int j= i+1; j<str.length(); j++){
                if(numbers[max]<numbers[j]){
                    max = j;
                }
            }
            if(numbers[max]>numbers[i]){
                int temp = numbers[i];
                numbers[i] = numbers[max];
                numbers[max] = temp;
            }
        }
        for(int i=0; i<str.length(); i++){
            System.out.print(numbers[i]);
        }
    }
}