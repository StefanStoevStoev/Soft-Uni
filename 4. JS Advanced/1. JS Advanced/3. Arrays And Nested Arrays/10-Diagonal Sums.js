function solve(arr){
    let leftDiagonalSum = 0;
    let leftDiagonalFirstPoint = 0;
    let rightDiagonalSum = 0;
    let rightDiagonalFirstPoint = arr.length - 1;

    for (const iterator of arr) {

        leftDiagonalSum += iterator[leftDiagonalFirstPoint];
        leftDiagonalFirstPoint ++;

        rightDiagonalSum += iterator[rightDiagonalFirstPoint];
        rightDiagonalFirstPoint--;
        
    }

    return leftDiagonalSum + ' ' + rightDiagonalSum;
}
console.log(solve([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]
   ));