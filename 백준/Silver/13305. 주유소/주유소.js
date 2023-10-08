let input = require('fs')
.readFileSync('/dev/stdin')
.toString().split('\n');

let cityCount = Number(input[0]);
let cityDistance = input[1].split(' ').map(Number);
let cityCost = input[2].split(' ').map(Number);

let minCost = cityCost[0];
for(let i = 0; i<cityCount; i++){
    minCost = Math.min(minCost,cityCost[i])
    cityCost[i] = minCost;
}

let answer = BigInt(0);
for (let i=0; i<cityCount-1; i++){
    answer += BigInt(cityDistance[i])*BigInt(cityCost[i]);
}
console.log(String(answer));
