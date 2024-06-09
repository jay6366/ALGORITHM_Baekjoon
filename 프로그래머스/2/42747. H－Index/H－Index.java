import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 인용 횟수를 오름차순으로 정렬
        int n = citations.length; // 논문의 총 개수

        for (int i = 0; i < n; i++) {
            // citations[i]는 i번째 논문의 인용 횟수
            // (n - i)는 i번째 논문을 포함하여 그 이상 인용된 논문의 수
            int h = n - i; // 현재 검토 중인 H-Index 후보
            if (citations[i] >= h) {
                return h; // H-Index 조건 만족: h편 이상이 h번 이상 인용
            }
        }
        return 0; // 인용 횟수가 0인 경우를 처리
    }
}
