import java.util.*;

class Solution {
    static class Song{
        int play;
        int id;
        Song(int play, int id){
            this.play = play;
            this.id = id;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
    
        //각 장르별 총 재생 횟수를 저장하는 자료구조
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        
        //각 장르별로 노래의 정보를 우선순위 큐에 저장하여, 자동으로 재생횟수에 따라 정렬되게 하는 자료구조
        HashMap<String, PriorityQueue<Song>> genreSongs = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre,0)+play);
            genreSongs.computeIfAbsent(genre, k -> new PriorityQueue<>((a,b)->{
                if(a.play == b.play) return a.id - b.id; // 재생 횟수 같으면 고유 번호 낮은 순
                return b.play - a.play; //재생 횟수 높은 순
            })).add(new Song(play,i)); //이 부분 다시 질문 ()
        }
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet()); //이부분도 다시 질문 ()
        sortedGenres.sort((a,b) -> genrePlayCount.get(b)-genrePlayCount.get(a));
        
        List<Integer> answerList = new ArrayList<>(); //int가 아닌 Integer로 정의한 이유
        for(String genre : sortedGenres){
            PriorityQueue<Song> pq = genreSongs.get(genre);
            int count = 0;
            while(!pq.isEmpty()&&count<2){
                answerList.add(pq.poll().id);
                count++;
            }
        }
        return answerList.stream().mapToInt(i->i).toArray(); //Array로 해줘야해? 이 코드 의미
    }

}
