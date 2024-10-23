import java.util.*;
class Solution {
    public String repeatString(String str,int count){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++){
            sb.append(str);
        }
        return sb.toString();
    }
    
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i=0; i<9; i++){
            dp.add(new HashSet<>());
        }
        
        for(int i=1; i<9; i++){
            dp.get(i).add(Integer.parseInt(repeatString(String.valueOf(N),i)));
        }
        
        for(int i=1; i<9; i++){
            for(int j=1; j<i; j++){
                for(int x : dp.get(j)){
                    for(int y: dp.get(i-j)){
                        dp.get(i).add(x+y);
                        dp.get(i).add(x-y);
                        dp.get(i).add(x*y);
                        if(y!=0){
                            dp.get(i).add(x/y);
                        }
                    }
                }
            }
            if(dp.get(i).contains(number)){
            return i;
            } 
        }
        
   
        return -1;
    }
    
}