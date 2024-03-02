import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] numbers = new mData[N];
        for(int i=0; i<N; i++){
            numbers[i] = new mData(Integer.parseInt(br.readLine()),i);
        }
        Arrays.sort(numbers);
        int Max = 0;
        for(int i=0; i<N; i++){
            if(numbers[i].index - i > Max){
                Max = numbers[i].index - i;
            }
        }
        System.out.println(Max+1);
    }
    
    public static class mData implements Comparable<mData>{
        int value;
        int index;
        public mData(int value, int index){
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo(mData o){
            return this.value - o.value;
        }
    }
}