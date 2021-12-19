function solve(arr, firstStr, secondStr) {
    let positionFirst = arr.indexOf(firstStr);
    let positionSecoind = arr.indexOf(secondStr) + 1;

    let newArry = arr.splice(positionFirst, positionSecoind);

    return newArry;
}

console.log(solve(['Pumpkin Pie',
    'Key Lime Pie',
    'Cherry Pie',
    'Lemon Meringue Pie',
    'Sugar Cream Pie'],
    'Key Lime Pie',
    'Lemon Meringue Pie'
));