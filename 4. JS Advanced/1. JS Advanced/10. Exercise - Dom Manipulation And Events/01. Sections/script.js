function create(words) {

    const content = document.getElementById('content');

    for (const word of words) {
        let newDiv = document.createElement('div');
        let para = document.createElement('p');
        para.textContent = word;
        para.style.display = 'none';
        para.href = '#';

        newDiv.addEventListener('click', onClick)

        newDiv.appendChild(para);

        content.appendChild(newDiv);
    }

    function onClick(a) {
        a.currentTarget.firstChild.style.display = '';
        //   a.currentTarget.children[0].style.display = '';
        //   a.target.children[0].style.display = '';
        //   console.log(a.target.querySelector('p'));
    }
}