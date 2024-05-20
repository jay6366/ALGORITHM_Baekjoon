import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] characters = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            characters[i] = "" + numbers[i];
        }
        Arrays.sort(characters, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
        
        if(characters[0].equals("0")){
            return "0";
        }
            
        StringBuilder sb = new StringBuilder();   
        for(String character : characters){
            sb.append(character);
        }
        
               
        return sb.toString();
    }
}