function solve() {
    const entryText = document.getElementById("input").value;

    let text1 = entryText.split('.').filter(x => x != '');

    // let arrText = [];

    for (let i = 0; i < text1.length; i += 3) {
        let text = '<p>';

        for (let k = 0; k < 3; k++) {
            if (k + i < text1.length) {
                text += text1[k + i] + '.';
            }
        }
        text += '</p>'
        document.getElementById('output').innerHTML += text;
    }
}