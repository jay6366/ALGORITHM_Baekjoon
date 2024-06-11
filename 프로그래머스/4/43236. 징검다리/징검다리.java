import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        //int mid = (left+right)/2; -> while 문 안으로
        //int min = 0; -> answer로 변경
        int answer = 0;
        //nt[] distances = new int [rocks.length]; -> 해당 배열은 필요 없으므로 제거
        while(left <= right){ //while은 해당 조건이 충족할 때까지임
            //for(int rock : rocks){  -> for문은 제거
                int mid = (left+right)/2; //solution안에 있는 것을 while문으로 옮김
                int removedRocks = 0; //새로 추가
                int lastPosition = 0; //새로 추가
            
                for(int rock : rocks){
                    if(rock - lastPosition < mid){
                        removedRocks++;
                    } else {
                        lastPosition = rock;
                    }
                }
                if(distance - lastPosition < mid){
                    removedRocks++;
                }
            
                if(removedRocks <= n){
                    answer = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }                
            }
        return answer;
        }   
    }