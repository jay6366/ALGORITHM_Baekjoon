let input = require('fs')
.readFileSync('/dev/stdin')
.toString().trim().split('');

let result = input.map(Number);
result.sort(
    function(a,b){
        return b-a;
    }
);

console.log(result.join(''));


