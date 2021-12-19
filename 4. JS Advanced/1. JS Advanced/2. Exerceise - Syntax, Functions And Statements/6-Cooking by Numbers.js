function cookingNumbers(num, func1, func2, func3, func4, func5) {
    let number = Number(num);

    let arrList = [func1, func2, func3, func4, func5];

    for (let i = 0; i < arrList.length; i++) {
        number = printResult(number, arrList[i]);
        console.log(number);
    }
    function printResult(number, operation) {

        switch (operation) {
            case 'chop': number /= 2; break;
            case 'dice': number = Math.sqrt(number); break;
            case 'spice': number++; break;
            case 'bake': number *= 3; break;
            case 'fillet': number -= 0.2 * number; break;
        }

        return number;
    }
}

cookingNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet');