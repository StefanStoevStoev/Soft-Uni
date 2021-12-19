function solve(arr) {
    let maxNum = arr[0];
    let newArr = [arr[0]];
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] >= maxNum) {
            maxNum = arr[i];
            newArr.push(maxNum);
        }

    }
    return newArr;
}

solve([1, 
    2, 
    3,
    4]
    );
// solve([20,
//     3,
//     2,
//     15,
//     6,
//     1]);

// solve([1, 
//     3, 
//     8, 
//     4, 
//     10, 
//     12, 
//     3, 
//     2, 
//     24]);
