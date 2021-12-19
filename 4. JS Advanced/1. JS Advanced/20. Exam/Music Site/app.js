window.addEventListener('load', solve);

function solve() {

    document.getElementById('add-btn')
        .addEventListener('click', addAllData);



    function addAllData(e) {

        e.preventDefault();

        let genreSong = document.getElementById('genre');
        let nameSong = document.getElementById('name');
        let authorSong = document.getElementById('author');
        let date = document.getElementById('date');


        if (!genreSong.value || !nameSong.value || !authorSong.value || !date.value) {
            return;
        }

        let repositoryPlace = document.querySelector('#all-hits div.all-hits-container');

        let divHits = document.createElement('div');
        divHits.className = 'hits-info';
        repositoryPlace.appendChild(divHits);

        let h2Gener = document.createElement('h2');
        h2Gener.textContent = genreSong.value;
        divHits.appendChild(h2Gener);



        let h2Name = document.createElement('h2');
        h2Name.textContent = nameSong.value;
        divHits.appendChild(h2Name);

        let h2Autor = document.createElement('h2');
        h2Autor.textContent = authorSong.value;
        divHits.appendChild(h2Autor);

        let h3Date = document.createElement('h3');
        h3Date.textContent = date.value;
        divHits.appendChild(h3Date);

        let btnSave = document.createElement('button');
        btnSave.classList.add('save-btn');
        btnSave.textContent = 'Save song';
        divHits.appendChild(btnSave);

        let btnLike = document.createElement('button');
        btnLike.classList.add('like-btn');
        btnLike.textContent = 'Like song';
        divHits.appendChild(btnLike);

        let btnDelete = document.createElement('button');
        btnDelete.classList.add('delete-btn');
        btnDelete.textContent = 'Delete';
        divHits.appendChild(btnDelete);

        let btnSave = document.createElement('button');
        btnSave.className = 'save-btn';
        btnSave.textContent = 'Save';
        divHits.appendChild(btnSave);

        btnDelete.addEventListener('click', deleteData);

        btnLike.addEventListener('click', likeData);

        btnSave.addEventListener('click', saveData);


        // genreSong.value = '';
        // nameSong.value = '';
        // authorSong.value = '';
        // date.value = '';
    }

    function saveData(e) {

    }

    function deleteData(e) {
        let deleteBtn = e.target;
        let element = deleteBtn.parentElement;
        element.remove();
    }

    function likeData(e) {

        let likes = document.querySelector('#total-likes div.likes p');

        e.target.style.background = 'grey';

        let like = likes.textContent.split(' ');
        let newNum = Number(like[2]) + 1;

        likes.textContent = like[0] + ' ' + like[1] + ' ' + newNum;

        e.target.disabled = true
            // console.log(Number(like));
    }


}