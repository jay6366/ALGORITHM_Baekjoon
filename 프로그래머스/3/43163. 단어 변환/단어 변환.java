import java.util.*;
class Word{
    String beginWord;
    int step;
    Word(String begin, int step){
        this.beginWord = begin;
        this.step = step;
    }
}

class Solution {
    public boolean isOneLetterDifferent(String current, String next){
        int count = 0;
        for(int i=0; i<current.length(); i++){
            if(current.charAt(i)!=next.charAt(i)){
                count++;
            }
        }
        if(count==1){
            return true;
        }
        return false;
    }
    public int solution(String begin, String target, String[] words) {
        List<String> wordList = Arrays.asList(words);
        if(!wordList.contains(target)){
            return 0;
        }
        
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin,0));
        
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        
        while(!queue.isEmpty()){
            Word cur = queue.poll();
            String currentWord = cur.beginWord;
            int steps = cur.step;
            
            if(currentWord.equals(target)){
                return steps;
            }
            
            for(String word : wordList){
                if(!visited.contains(word)&&isOneLetterDifferent(currentWord,word)){
                    queue.offer(new Word(word,steps+1));
                }
            }           
        }
        return 0;
        
    }
}