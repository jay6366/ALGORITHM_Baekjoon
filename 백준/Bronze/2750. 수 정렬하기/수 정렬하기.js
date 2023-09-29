let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let number = Number(input[0]);
let array = [];
for (let i=1; i<=number; i++)
{
    array[i-1] = input[i].split('\n');
}

    
array.sort(function(a,b){
    return a-b
})

let answer = '';

for (let i=0; i<array.length; i++)
{
    answer += array[i] + "\n";
}
console.log(answer);
