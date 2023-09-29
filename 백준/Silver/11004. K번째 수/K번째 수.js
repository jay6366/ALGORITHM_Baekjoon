let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let n = Number(input[0].split(' ')[0]);
let k = Number(input[0].split(' ')[1]);

let array = input[1].split(' ').map(Number);

array.sort(
    function(a,b){
        return a - b
    }
)

console.log(array[k-1]);

