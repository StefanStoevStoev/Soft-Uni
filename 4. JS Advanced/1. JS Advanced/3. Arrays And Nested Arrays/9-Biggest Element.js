function solve(arr){

    let maxArr = arr[0];
    let maxNum = maxArr[0];

    for (const iterator of arr) {
        let num = Math.max(...iterator);
            if(num > maxNum){
                maxNum = num;
            }
    }
    return maxNum;
}

console.log(solve([[20, 50, 10],
    [8, 33, 145]]));