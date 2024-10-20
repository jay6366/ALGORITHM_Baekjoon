class Solution {
    public int solution(String word) {
        
        int[] weights = {781,156,31,6,1};
        //각 자릿수가 i일 때, 해당 자리에서 가능한 단어의 수를 의미
        //각 자리에 모음이 올 때마다 건너뛰어야 하는 단어의 개수를 나타내는 가중치임
        char[] vowels = {'A','E','I','O','U'};
        
        int result = word.length();
        
        for(int i=0; i<word.length(); i++){
            for(int j=0; j<vowels.length; j++){
                if(word.charAt(i)==vowels[j]){
                    result += weights[i]*j;
                    break; //빼먹지말기
                }
            }
        }
        return result;
    }
}