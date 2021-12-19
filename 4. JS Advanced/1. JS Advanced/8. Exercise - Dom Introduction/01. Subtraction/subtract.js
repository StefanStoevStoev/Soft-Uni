function subtract() {
    const firstNumber = document.getElementById('firstNumber').value;
    const secondNumber = document.getElementById('secondNumber').value;

    let sum = Number(firstNumber) - Number(secondNumber);

    document.getElementById('result').textContent = sum;
}