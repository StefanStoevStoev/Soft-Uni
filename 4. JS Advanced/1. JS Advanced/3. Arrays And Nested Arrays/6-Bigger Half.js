function solve(arr) {
    arr.sort((a, b) => a - b);
    const middle = Math.floor(arr.length / 2);
    const resilt = arr.slice(middle);
    return resilt;
}

console.log(solve([3, 19, 14, 7, 2, 19, 6]));