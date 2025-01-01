import java.util.*;
class Word{
    String begin;
    int step;
    Word(String begin, int step){
        this.begin = begin;
        this.step = step;
    }
}

class Solution {
    boolean isOneLetterDifferent(String word1, String word2){
        int count = 0;
        for(int i=0; i<word1.length();i++){
            if(word1.charAt(i)!=word2.charAt(i)){
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        List<String> wordList = Arrays.asList(words); //List변환
        if(!wordList.contains(target)){
            return 0;
        }
        
        Queue<Word> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(); //HashSet
        
        queue.offer(new Word(begin,0));
        visited.add(begin);
        
        while(!queue.isEmpty()){
            Word tmp = queue.poll();
            String currentWord = tmp.begin;
            int currentSteps = tmp.step;
            
            if(currentWord.equals(target)){
                return currentSteps;
            }
            
            for(String word : wordList){ //배열, List 모두 할 수 있지?
                if(!visited.contains(word)&&isOneLetterDifferent(tmp.begin,word)){
                    queue.offer(new Word(word,currentSteps+1));
                    visited.add(word);
                }
            }
        }
        return 0;
    }
}
                                