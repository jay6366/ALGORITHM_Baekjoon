import java.util.*;

class Solution {
    public boolean isOneLetterDifferent(String begin, String word){
        int count = 0;
        for(int i=0; i<begin.length(); i++){
            if(begin.charAt(i)!=word.charAt(i)){
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        
        // words 배열을 List로 변환하여 탐색에 사용
        List<String> wordList = Arrays.asList(words);

        // target이 words에 없으면 변환 불가능하므로 0 반환
        if (!wordList.contains(target)) {
            return 0;
        }
        
        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[]{begin,"0"});//생각못한 부분
        
        Set<String> visited = new HashSet<>();
        visited.add(begin);

        while(!queue.isEmpty()){
            String[] current = queue.poll();
            String currentWord = current[0];
            int steps = Integer.parseInt(current[1]);
            
            if(currentWord.equals(target)){
                return steps;
            }
            
            for(String word : wordList){
                if(!visited.contains(word) && isOneLetterDifferent(currentWord,word)){
                    queue.add(new String[]{word,Integer.toString(steps+1)});
                }
            }           
        }
        return 0;       
    }
}