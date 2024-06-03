class Solution {
    public long solution(int n, int[] times) {
        
        long maxTime = 0;
        
        for(int time : times){
            if(time > maxTime){
                maxTime = time;
            }
        }
        long minTime = 1;
        maxTime *= n; //이 부분 생각 X
        long answer = maxTime;//이 부분 생각 x
        while(minTime <= maxTime){
            long mid = (maxTime + minTime)/2;
            long sum = 0;
            for(int time : times){
                sum += mid/time;
                if(sum>=n) break;   //이 부분 생각 x
            }
            if(sum>=n){
                answer = mid;
                maxTime = mid - 1;
            } else {
                minTime = mid + 1;
            }
        }
       
        return answer;
    }
}