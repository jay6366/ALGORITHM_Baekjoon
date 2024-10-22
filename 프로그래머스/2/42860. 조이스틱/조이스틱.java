class Solution {
       public int solution(String name) {
        int n = name.length();
        
        // 1번: 각 자리에서 알파벳 변경 최소 횟수 계산
        int totalMoves = 0;
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            // A에서 목표 문자로 가는 최소 조작 횟수 계산 (▲ 또는 ▼)
            totalMoves += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        // 2번: 좌우 이동 최적화
        int moveLR = n - 1; // 처음엔 오른쪽 끝까지 가는 경우로 초기화

        for (int i = 0; i < n; i++) {
            int nextPos = i + 1;
            
            // A가 아닌 문자가 나올 때까지 앞으로 이동
            while (nextPos < n && name.charAt(nextPos) == 'A') {
                nextPos++;
            }

            // i까지 갔다가 다시 왼쪽으로 돌아가는 경우와 비교
            moveLR = Math.min(moveLR, i + i + n - nextPos);
            moveLR = Math.min(moveLR,i+(n-nextPos)*2);
        }

        return totalMoves + moveLR;
    }

}