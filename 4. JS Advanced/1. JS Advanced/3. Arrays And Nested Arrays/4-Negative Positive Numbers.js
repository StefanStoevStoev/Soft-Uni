function solve(arr) {
    let newArr = [];
    for (const iterator of arr) {
        if (iterator >= 0) {
            newArr.push(iterator);
        } else {
            newArr.unshift(iterator);
        }
    }
    return newArr
}
console.log(solve([3, -2, 0, -1]));