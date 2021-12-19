function solve(arr) {
    let reference = 0;
    for (const iterator of arr[0]) {
        reference += iterator;
    }

    for (let i = 0; i < arr.length; i++) {
        let sumRow = 0;
        for (let k = 0; k < arr[0].length; k++) {
            sumRow += arr[i][k];
        }
        if (sumRow != reference) {
            return false;
        }
    }
    for (let i = 0; i < arr[0].length; i++) {
        let sumColumn = 0;
        for (let k = 0; k < arr.length; k++) {
            sumColumn += arr[k][i];
        }
        if (sumColumn != reference) {
            return false;
        }
    }
    return true;
}

// console.log(solve([[4, 5, 6],
// [6, 5, 4],
// [5, 5, 5]]));

// console.log(solve([[11, 32, 45],
// [21, 0, 1],
// [21, 1, 1]]));

console.log(solve([[1, 0, 0],
[0, 0, 1],
[0, 1, 0]]));