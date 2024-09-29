import java.util.*;

class Point{
    int price, index;
    Point(int price, int index){
        this.price = price;
        this.index = index;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(prices[0], 0));   
        
        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < stack.peek().price) {
                Point point = stack.pop();
                answer[point.index] = i - point.index;  // 가격이 떨어진 경우
            }
            stack.push(new Point(prices[i], i));  // 현재 가격과 인덱스를 스택에 저장
        }
        
        // 스택에 남은 요소들 처리
        while (!stack.isEmpty()) {
            Point point = stack.pop();
            answer[point.index] = prices.length - point.index - 1;  // 끝까지 가격이 떨어지지 않은 경우
        }
        
        return answer;        
    }
}
