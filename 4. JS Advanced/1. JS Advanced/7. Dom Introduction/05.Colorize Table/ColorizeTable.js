function colorize() {
    const tagNames = document.querySelectorAll('tr');

    console.log(tagNames);
    for (let i = 0; i < tagNames.length; i++) {
        if (i % 2 != 0) {
            tagNames[i].style.background = 'teal';
        }
    }
}