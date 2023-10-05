let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let number = Number(input[0]);
let arr = [];
for (let i = 1; i <= number; i++){
    let [x,y] = input[i].split(' ').map(Number);
    arr.push([x,y]);
}

arr.sort(
    function(a,b){
        if (a[1] != b[1]){
            return a[1] - b[1]
        }
        return a[0] - b[0]       
    }
)
let answer = "";
for (let item of arr){
    answer += item[0] + " " + item[1] + "\n";
}
console.log(answer);