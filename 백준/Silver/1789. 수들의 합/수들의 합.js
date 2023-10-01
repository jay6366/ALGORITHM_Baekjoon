let input = require('fs')
.readFileSync('dev/stdin')
.toString().split('\n');

let number = Number(input[0]);
let currentNumber= 0;
let sum = 0;

while(sum<=number){
    currentNumber += 1;
    sum += currentNumber;
}
console.log(currentNumber - 1);


