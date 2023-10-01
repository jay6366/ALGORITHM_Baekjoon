let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let n = Number(input[0].split(' ')[0]);
let k = Number(input[0].split(' ')[1]);

let array = [];

for (let i=1; i<=n; i++)
{
    array.push(input[i]);
}

array = array.map(Number);
array.sort(
    function(a,b){
        return a - b
    }
)
let count = 0;
for(let i=array.length-1; i>=0; i--)
{
    if (k >= array[i]){
        count += Math.floor(k/array[i]);
        k %= array[i];
    }
    
}
console.log(count);
