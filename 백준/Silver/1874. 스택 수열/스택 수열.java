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
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;
        for(int i=0; i<numbers.length; i++){
            int su = numbers[i];
            if (su >= num){
                while (su >= num){
                    stack.push(num++);
                    bf.append("+\n"); 
                }
                stack.pop();
                bf.append("-\n");
            }
            else {
                int n = stack.pop();
                if (n>su){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString());
    }
}