import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] numStrings = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            numStrings[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numStrings,(a,b)->(b+a).compareTo(a+b));
        
        String result = String.join("", numStrings);
        
        return result.startsWith("0") ? "0" : result;
    }
}