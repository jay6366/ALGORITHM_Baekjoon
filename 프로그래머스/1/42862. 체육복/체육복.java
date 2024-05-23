public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 전체 학생의 체육복 수를 관리하는 배열
        int[] clothes = new int[n + 1]; // 인덱스 1부터 사용하기 위해 n+1 크기로 생성

        // 초기화: 모든 학생은 1개의 체육복을 가지고 있다고 가정
        for (int i = 1; i <= n; i++) {
            clothes[i] = 1;
        }

        // 도난당한 학생 처리
        for (int l : lost) {
            clothes[l]--;
        }

        // 여벌의 체육복을 가진 학생 처리
        for (int r : reserve) {
            clothes[r]++;
        }

        // 체육복을 빌려줄 수 있는지 확인
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) { // 체육복이 없는 경우
                if (i > 1 && clothes[i - 1] > 1) { // 왼쪽 학생에게 빌릴 수 있는지
                    clothes[i]++;
                    clothes[i - 1]--;
                } else if (i < n && clothes[i + 1] > 1) { // 오른쪽 학생에게 빌릴 수 있는지
                    clothes[i]++;
                    clothes[i + 1]--;
                }
            }
        }

        // 체육수업을 들을 수 있는 학생 수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (clothes[i] > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
