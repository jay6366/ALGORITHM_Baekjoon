import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수와 곡 정보를 저장할 해시맵
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, PriorityQueue<Song>> genreSongs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // 장르별 총 재생 횟수 갱신
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
            
            // 장르별 노래 정보 저장 (재생 횟수, 고유 번호)
            genreSongs.computeIfAbsent(genre, k -> new PriorityQueue<>((a, b) -> {
                if (a.play == b.play) return a.id - b.id; // 재생 횟수 같으면 고유 번호 낮은 순
                return b.play - a.play; // 재생 횟수 높은 순
            })).add(new Song(play, i));
        }
        
        // 장르별 총 재생 횟수를 기준으로 내림차순 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));
        
        List<Integer> answerList = new ArrayList<>();
        for (String genre : sortedGenres) {
            // 각 장르별로 가장 많이 재생된 노래 두 개씩 선택
            PriorityQueue<Song> pq = genreSongs.get(genre);
            int count = 0;
            while (!pq.isEmpty() && count < 2) {
                answerList.add(pq.poll().id);
                count++;
            }
        }
        
        // 결과 리스트를 배열로 변환하여 반환
        return answerList.stream().mapToInt(i -> i).toArray();
    }
    
    // 노래 정보를 저장할 Song 클래스
    static class Song {
        int play;
        int id;
        
        Song(int play, int id) {
            this.play = play;
            this.id = id;
        }
    }
}
