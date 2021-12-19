function extractText() {

    const items = document.querySelectorAll('ul#items li');
    const result = document.querySelector("#result");

    for (let it of items) {
        result.value += it.textContent + "\n";
    }
}