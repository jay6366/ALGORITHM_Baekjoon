let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let groups = input[0].split('-');
let answer = 0;

for(let i=0; i<groups.length; i++){
    let current = groups[i].split('+').map(Number).reduce((a,b)=>a+b);
    if (i == 0){
        answer += current;
    }
    else{
        answer -= current;
    }
}

console.log(answer);