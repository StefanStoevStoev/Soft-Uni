function solve(n, k) {
    let arr = [1];

    for (let t = 1; t < n; t++) {

        let tempararyNumber = 0;

        for (let i = arr.length - 1; i >= arr.length - k; i-- && i > -1) {
            let newNumber = arr[i];
            if (newNumber !== undefined) {
                tempararyNumber += newNumber;
            } else {
                break;
            }
        }
        arr.push(tempararyNumber);
    }
    return arr;
}

console.log(solve(8, 2));