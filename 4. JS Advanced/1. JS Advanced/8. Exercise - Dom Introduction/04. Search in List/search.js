function search() {

    const towns = Array.from(document.querySelectorAll('ul li'));

    const text = document.getElementById('searchText').value;

    let count = 0;

    towns.forEach(element => {
        if (element.innerHTML.includes(text)) {
            element.style.fontWeight = 'bold';
            element.style.textDecoration = 'underline';
            count++;
        } else {
            element.style.fontWeight = 'normal';
            element.style.textDecoration = '';
        }
    });

    document.getElementById("result").textContent = `${count} matches found`;
}