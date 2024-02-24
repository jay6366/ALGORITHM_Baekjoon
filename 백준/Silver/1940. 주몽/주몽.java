import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] numbers = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        
        int count = 0;
        int i = 0;
        int j = N-1;
        while(i<j){
            if(numbers[i]+numbers[j]<M){
                i++;
            }
            else if(numbers[i]+numbers[j]>M){
                j--;
            }
            else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
    }
}