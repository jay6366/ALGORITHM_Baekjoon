import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int right = people.length;
        int left = 0;
        while(left < right){
            if(people[left]+people[right-1]<=limit){
                left++;
            }
            right--;
            answer++;
        }
        return answer;
    }
}