import java.util.*;

public class Solution {
    public int solution(int[][] jobs) {
        // 작업을 요청 시간 순서로 정렬 (comparingInt 대신 직접 Comparator 구현)
        Arrays.sort(jobs, new Comparator<int[]>() { //익명클래스를 사용하여 인터페이스 구현 중괄호 안에서는 인터페이스가 요구하는 메소드 정의
            @Override
            public int compare(int[] job1, int[] job2) {
                return Integer.compare(job1[0], job2[0]); //뺄셈도 가능하나 큰수가 나올시 오버플로우 방지를 위해 해당방법 추천 
            }
        });

        // 나머지 코드는 동일하게 유지됩니다.
        //배열 자체는 Comparable 인터페이스를 구현하지 않습니다. 
        //즉, 배열은 기본적으로 Comparable 인터페이스를 구현한 객체가 아니므로, 
        //배열을 직접 PriorityQueue에 넣고자 할 때는 **배열의 요소를 기준으로 정렬하는 Comparator**를 제공해야 합니다.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] job1, int[] job2) {
                return Integer.compare(job1[1], job2[1]);  // 소요 시간을 기준으로 정렬
            }
        });

        int currentTime = 0;  // 현재 시간
        int totalTime = 0;    // 각 작업의 소요 시간을 누적
        int jobIndex = 0;     // jobs 배열에서 현재 처리 중인 인덱스
        int completedJobs = 0; // 완료된 작업 수

        // 모든 작업이 처리될 때까지 반복
        while (completedJobs < jobs.length) {
            // 현재 시간 이전에 요청된 모든 작업을 큐에 추가
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime) {
                pq.offer(jobs[jobIndex]);
                jobIndex++;
            }

            if (pq.isEmpty()) {
                // 처리할 작업이 없다면, 다음 작업의 요청 시간으로 시간을 이동
                currentTime = jobs[jobIndex][0];
            } else {
                // 우선순위 큐에서 소요 시간이 가장 짧은 작업을 꺼내 처리
                int[] currentJob = pq.poll();
                currentTime += currentJob[1];  // 작업 소요 시간만큼 시간 추가
                totalTime += currentTime - currentJob[0];  // 요청부터 종료까지 걸린 시간 누적
                completedJobs++;
            }
        }

        // 평균 시간을 소수점 이하 버리고 반환
        return totalTime / jobs.length;
    }
}
