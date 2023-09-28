let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let n = Number(input[0]);
let array = input[1].split(' ').map(Number);

let uniqueArray = [...new Set(array)];
uniqueArray.sort(function(a,b){
        return a - b
});

let myMap = new Map();
for (let i=0; i<uniqueArray.length; i++)
{
    myMap.set(uniqueArray[i],i);
}
answer = "";
for(x of array){
    answer += myMap.get(x) + " ";
}

console.log(answer);