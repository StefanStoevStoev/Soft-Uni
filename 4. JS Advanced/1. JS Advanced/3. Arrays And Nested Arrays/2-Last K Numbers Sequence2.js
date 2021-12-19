function solve(n, k) {
    let arr = [1];

    for (let i = 1; i < n; i++) {
        let arrNew = arr.slice(arr.length - k >= 0 ? arr.length - k : 0 , arr.length);
        const reducer = (accumulator, currentValue) => accumulator + currentValue;
        let sum = arrNew.reduce(reducer);
        arr.push(sum);
    }
    return arr;
}
console.log(solve(8, 2));