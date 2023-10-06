let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let number = Number(input[0]);
let arr = [];
for (let i=1; i<=number; i++){
    let [x,y] = input[i].split(' ').map(Number);
    arr.push([x,y]);
}

arr.sort(
    function(a,b){
        if(a[1] != b[1]){
            return a[1] - b[1];
        }
        else {
            return a[0] - b[0];
        }

    }
)

let Count = 1;
let currentIndex = 0;
for(let i = 1; i<arr.length; i++){
    if(arr[currentIndex][1] <= arr[i][0]){
        Count += 1;
        currentIndex = i;
    }
}
console.log(Count);