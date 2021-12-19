function solve(arr) {
    arr.sort((a, b) => a - b);
    let minArr = arr.slice(0, arr.length / 2 + 1);
    let maxArr = arr.slice(arr.length / 2 + 1, arr.length);
    maxArr.sort((a, b) => b - a);

    resultArr = [];

    for (let i = 0; i < minArr.length; i++) {

        resultArr.push(minArr[i]);
        if(i < maxArr.length){
            resultArr.push(maxArr[i]);
        }
    }

    return resultArr;
}

console.log(solve([1, 65, 3, 5, 52, 48, 63, 31, -3, 18, 56]).join('\n'));