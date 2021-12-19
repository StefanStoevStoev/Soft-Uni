function comonDivisor(num1, num2) {
    let minNum = Math.min(num1,num2);

    for (let i = minNum; i > 0; i--) {
        let number = 0;
        if(num1 % i == 0 && num2 % i == 0){
            return i;
        }
    }
}
console.log(comonDivisor(2154, 458));

