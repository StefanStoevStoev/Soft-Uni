function solution(numberInput) {
    let number = Number(numberInput);

    return function(secondNum) {
        return secondNum + number;
    }
}

let add5 = solution(5);

console.log(add5(2));
console.log(add5(3));