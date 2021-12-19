function solve(arr) {
    let firstRow = [];
    let secondRow = [];
    let count = 0;
    for (let i = 0; i < arr.length - 1; i++) {
        let firstRow = arr[i];
        let secondRow = arr[i + 1];
        for (let k = 0; k < firstRow.length; k++) {
            if (firstRow[k] === secondRow[k] ||
                firstRow[k] === firstRow[k + 1] ||
                secondRow[k] === secondRow[k + 1]) {
                count++;
            }
        }
    }

    let lasttRow = arr[arr.length - 1];

    for (let n = 0; n < lasttRow.length-1; n++) {
        if (lasttRow[n] === lasttRow[n + 1]) {
            count++;
        }
    }
    return count;
}

console.log(solve([['test', 'test', 'yo', 'ho'],
                    ['test', 'done', 'yo', 'ho'],
                    ['not', 'not', 'yet', 'yet']]));

// console.log(solve([['2', '3', '4', '7', '0'],
// ['4', '0', '5', '3', '4'],
// ['2', '3', '5', '4', '2'],
// ['9', '8', '7', '5', '4']]
// ));

// console.log(solve([[2, 2, 5, 7, 4],
//                     [4, 0, 5, 3, 4],
//                     [2, 5, 5, 4, 2]]));