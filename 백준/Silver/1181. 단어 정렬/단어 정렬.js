let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let n = Number(input[0]);
let array = [];

for (let i=1; i<=n; i++){
    array.push(input[i]);
}

array = [...new Set(array)];


array.sort(
    function(a,b){
        if(a.length !== b.length){
            return a.length - b.length;
        }
       return a.localeCompare(b);
    }
)

let answer = "";
for (let i=0; i<array.length; i++){
    answer += array[i] + "\n";
}
console.log(answer);

