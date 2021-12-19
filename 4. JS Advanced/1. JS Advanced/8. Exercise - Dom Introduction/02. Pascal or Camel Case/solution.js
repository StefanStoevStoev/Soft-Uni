function solve() {

    const textInput = document.getElementById('text').value;
    const textArr = textInput.split(" ");

    const namingConvention = document.getElementById('naming-convention').value;

    let sum = '';

    if (namingConvention === 'Camel Case') {

        sum = textArr[0].toLowerCase();

        for (let i = 1; i < textArr.length; i++) {

            sum += textArr[i][0].toUpperCase() + textArr[i].slice(1, textArr[i].length).toLowerCase();

        }
    } else if (namingConvention === 'Pascal Case') {

        for (let i = 0; i < textArr.length; i++) {

            sum += textArr[i][0].toUpperCase() + textArr[i].slice(1, textArr[i].length).toLowerCase();
        }
    } else {
        sum = 'Error!';
    }

    document.getElementById("result").textContent = sum;
}