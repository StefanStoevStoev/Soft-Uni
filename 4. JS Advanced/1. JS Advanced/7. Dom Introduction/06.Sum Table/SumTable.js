function sumTable() {
    const array = document.querySelectorAll('td');

    let sum = 0;


    for (let i = 0; i < array.length; i++) {

        if (i % 2 != 0 && Number(array[i].textContent) != NaN) {
            sum += Number(array[i].textContent);
        }
    }

    document.getElementById('sum').textContent = sum;
}