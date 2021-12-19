function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {

        const array = Array.from(document.querySelectorAll('tbody tr'));
        const text1 = document.getElementById('searchField');
        const inputText = text1.value.toLocaleLowerCase();

        array.forEach(el => {
            let text2 = el.textContent.toLocaleLowerCase();

            if (text2.includes(inputText)) {
                el.classList.add('select');

            } else {
                el.classList.remove('select');
            }
        });
        text1.value = '';
    }

}