function deleteByEmail() {

    let email = document.getElementsByName('email')[0].value;

    let secondColumn = document.querySelectorAll('#customers tr td:nth-child(2)');


    console.log(email);

    for (const iterator of secondColumn) {
        if (iterator.textContent == email) {
            let row = iterator.parentNode;
            row.parentNode.removeChild(row);
            document.getElementById('result').textContent = 'Deleted.';
            return;
        }
        document.getElementById('result').textContent = 'Not found.';
    }
}