import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int dn = Integer.parseInt(st.nextToken());
        int qn = Integer.parseInt(st.nextToken());
        long[] Sum = new long[dn + 1];
        Sum[0] = 0;
        st = new StringTokenizer(bf.readLine());
        for(int i=1; i<=dn; i++){
            Sum[i] = Sum[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int q=0; q<qn; q++){
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(Sum[j]-Sum[i-1]);
        }
    } 
}