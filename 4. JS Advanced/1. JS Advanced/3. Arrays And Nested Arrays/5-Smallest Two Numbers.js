function solve(arr) {

    arr.sort((a,b) => a-b);
    let ss = arr[1] == undefined ? "" : arr[1];
    return arr[0] + ' ' + ss;
}
console.log(solve([-3, 0, -1]));