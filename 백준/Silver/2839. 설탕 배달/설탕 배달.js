let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let number = Number(input[0]);
let shareCount = 0;
let flag = false;

while(number>=0){
    if(number== 0 || number % 5 == 0) {
        shareCount += Math.floor(number/5);
        console.log(shareCount);
        flag = true;
        break;
    }
    number -= 3;
    shareCount += 1;
}
if(!flag){
    console.log(-1);
}
