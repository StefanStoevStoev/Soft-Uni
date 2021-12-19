function solve(arr) {
    arr.sort((a, b) => a.localeCompare(b));

    let count = 0;
    for (const iterator of arr) {
        count++;
        console.log(count + '.' + iterator);
    }
}

solve(["John", "Bob", "Christina", "Ema"]);