let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let n = Number(input[0].split(' ')[0]);
let h = Number(input[0].split(' ')[1]);
let heights = input[1].split(' ').map(Number);
let start = 0;
let end = heights.reduce((a,b)=>Math.max(a,b));

let result = 0;
while(start <= end){
    let mid = parseInt((start+end)/2);
    let sum = 0;
    for(let i=0; i<n; i++){
        if(heights[i]>=mid){
            sum += heights[i] - mid;
        }
    }
    if(sum < h){
        end = mid - 1;
    }
    else{
        result = mid;
        start = mid + 1;
    }
}
console.log(result);