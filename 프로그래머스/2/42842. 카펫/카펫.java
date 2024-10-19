class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for(int height=1; height <= Math.sqrt(yellow); height++){
            if(yellow % height == 0){
                int width = yellow / height;
                if((width+2)*(height+2) == total){
                    return new int[] {width+2, height+2};
                }
            }
        }
        return new int[0]; //빈배열 반환방법
    }
}