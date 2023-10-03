let input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

let arr = input[0].split(' ');
arr.sort(
    function(a,b){
        return a-b
    })
let answer = "";
for(let i=0; i<arr.length; i++){
    answer += arr[i]+" ";
}
console.log(answer);