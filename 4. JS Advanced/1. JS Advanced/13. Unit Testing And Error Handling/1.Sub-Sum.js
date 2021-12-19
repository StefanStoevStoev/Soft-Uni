function subSum(arr, firstNumber, secondNumber) {

    let sum = 0;
    if (firstNumber < 0) {
        firstNumber = 0;
    }
    if (secondNumber > arr.length) {
        secondNumber = arr.length - 1;
    }
    for (let i = firstNumber; i <= secondNumber; i++) {

        sum += Number(arr[i]);
    }
    return sum;
}

function test1_subSum() {
    let numbers = [10, 20, 30, 40, 50, 60];
    let startIndex = 3;
    let endIndex = 300;
    let exprectedResult = 150;

    let actualResult = subSum(numbers, startIndex, endIndex);

    if (actualResult === exprectedResult) {
        console.log('test 1 is passing');
    } else {
        console.error('Test 1 failed');
    }
};

function test2_subSum() {
    let numbers = [1.1, 2.2, 3.3, 4.4, 5.5];
    let startIndex = -3;
    let endIndex = 1;
    let exprectedResult = 3.3;

    let actualResult = Number(subSum(numbers, startIndex, endIndex).toFixed(1));

    if (actualResult === exprectedResult) {
        console.log('test 2 is passing');
    } else {
        console.error('Test 2 failed');
    }
}
test1_subSum();
test2_subSum();
















// module.exports = subSum;

// console.log(subSum([10, 20, 30, 40, 50, 60], 3, 300));
// console.log(subSum([1.1, 2.2, 3.3, 4.4, 5.5], -3, 1));
// console.log(subSum([10, 'twenty', 30, 40], 0, 2));
// console.log(subSum([], 1, 2));
// console.log(subSum('text', 0, 2));