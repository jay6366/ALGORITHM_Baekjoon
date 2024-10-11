import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b)); 
        //b+a가 a+b보다 크면 양수반환. 양수니까 a,b위치 교환해야함 b,a로 정렬
        
        StringBuilder sb = new StringBuilder();
        for(String x : arr){
            sb.append(x);
        }
        
        if(sb.toString().startsWith("0")){
            return "0";
        }
        return sb.toString();
    }
}