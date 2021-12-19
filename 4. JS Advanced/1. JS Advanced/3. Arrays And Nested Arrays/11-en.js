function solve(arr) {

    let count = 0;
    for (let i = 0; i < arr.length; i++) {

        let rows1 = arr[i];
        let rows2 = [];
        if(i+1 < arr.length){
            rows2 = arr[i + 1];
            for (let g = 0; g < rows1.length; g++) {
                if(rows1[g] == rows2[g]){
                    count++;
                }
            }
        }
        for (let k = 0; k < rows1.length; k++) {
            if (rows1[k] == rows1[k + 1]) {
                count++;
            }
        }
    }
    return count;
}

// console.log(solve([['test', 'yes', 'yo', 'ho'],
// ['well', 'done', 'yo', 'ho'],
// ['not', 'not', 'yet', 'yet']]));

console.log(solve([['2', '2', '4', '0', '0'],
['2', '0', '5', '3', '0'],
['9', '3', '5', '4', '5'],
['9', '9', '7', '5', '5']]
));

// console.log(solve([[2, 2, 5, 7, 4],
//                     [4, 0, 5, 3, 4],
//                     [2, 5, 5, 4, 2]]));