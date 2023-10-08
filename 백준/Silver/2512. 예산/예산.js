let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let number = Number(input[0]);
let arr = input[1].split(' ').map(Number);
let totalBudget = Number(input[2]);

let start = 1;
let end = arr.reduce((a, b) => Math.max(a, b));

// 모든 예산 요청의 합이 국가 예산보다 적거나 같은 경우
// 가장 큰 예산 요청을 상한액으로 설정하고 종료
if(arr.reduce((a, b) => a + b) <= totalBudget) {
    console.log(end);
}
else {
    let result = 0;
    while (start <= end) {
        let mid = parseInt((start + end) / 2);
        let total = 0;
        for (let x of arr) {
            total += Math.min(mid, x);
        }

        if (total <= totalBudget) {
            result = mid;
            start = mid + 1;
        }
        else {
            end = mid - 1;
        }
    }
    console.log(result);
}
