let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let n = Number(input[0].split(' ')[0]);
let k = Number(input[0].split(' ')[1]); 
let result = 0;

let array = [];
for(let i = 1; i<=n; i++){
    array.push(Number(input[i]));
}

let start = 1;
let end = array.reduce((a,b)=>Math.max(a,b));

while(start<=end){
    let mid = Math.floor((start+end)/2);
    let share = 0;
    for(let i=0; i<n; i++){
        share += Math.floor(array[i]/mid);
    }
    if(share >= k){
        result = mid;
        start = mid + 1;
    }
    else {
        end = mid - 1;
    }
}   
console.log(result);
