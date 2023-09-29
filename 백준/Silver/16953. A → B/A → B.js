let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split(' ');

let number1 =  Number(input[0]);
let number2 =  Number(input[1]);
let count = 1;

while(number1!==number2 && number2 > 0){
    if (number2 % 2 == 0){
        number2 /= 2;
    }
    else if (number2 % 10 === 1) {
       number2 = Math.floor(number2 /= 10);
    }
    else {
        break;
    }
    count += 1;
}
if(number1 !== number2){
    console.log(-1);
} else {
    console.log(count);
}

