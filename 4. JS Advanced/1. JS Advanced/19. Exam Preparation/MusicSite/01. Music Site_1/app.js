window.addEventListener('load', solve);

function solve() {

    const addBtn = document.getElementById('add-btn').addEventListener('click', takeAllData);

    let likes = 0;

    function takeAllData(e) {
        e.preventDefault();


        let flag = true;

        const repositoryLikes = document.querySelector('div.likes p');

        let genre = document.getElementById('genre');
        let name = document.getElementById('name');
        let author = document.getElementById('author');
        let date = document.getElementById('date');

        if (genre.value == '' || name.value == '' || author.value == '' || date.value == '') {
            return;
        }

        function clearData() {
            genre.value = '';
            name.value = '';
            author.value = '';
            date.value = '';
        }

        const repositoryPlace = document.querySelector('div.all-hits-container');

        const div = document.createElement('div');
        div.className = "hits-info";
        repositoryPlace.appendChild(div);

        const img = document.createElement('img');
        const src = "./static/img/img.png"
        img.setAttribute("src", src);
        div.appendChild(img);

        const h2First = document.createElement('h2');
        h2First.textContent = "Genre: " + genre.value;
        div.appendChild(h2First);

        const h2Second = document.createElement('h2');
        h2Second.textContent = "Name: " + name.value;
        div.appendChild(h2Second);

        const h2Author = document.createElement('h2');
        h2Author.textContent = "Author: " + author.value;
        div.appendChild(h2Author);

        const h3Date = document.createElement('h3');
        h3Date.textContent = "Date: " + date.value;
        div.appendChild(h3Date);

        clearData();

        const saveBtn = document.createElement('button');
        saveBtn.className = 'save-btn';
        saveBtn.textContent = 'Save song';
        div.appendChild(saveBtn);

        const likeBtn = document.createElement('button');
        likeBtn.className = 'like-btn';
        likeBtn.textContent = 'Like song';
        div.appendChild(likeBtn);

        const deleteBtn = document.createElement('button');
        deleteBtn.className = 'delete-btn';
        deleteBtn.textContent = 'Delete';
        div.appendChild(deleteBtn);

        saveBtn.addEventListener('click', saveEvent);
        deleteBtn.addEventListener('click', deleteEvent);
        likeBtn.addEventListener('click', likeEvent);

        // function saveEvent() {
        //     const savedContainer = document.querySelector('div.saved-container');
        //     div.removeChild(likeBtn);
        //     div.removeChild(saveBtn);
        //     savedContainer.appendChild(div);
        //     deleteBtn.addEventListener('click', deleteEvent);
        // }

        function saveEvent() {
            const savedContainer = document.querySelector('div.saved-container');
            div.removeChild(likeBtn);
            div.removeChild(saveBtn);
            savedContainer.appendChild(div);
            deleteBtn.addEventListener('click', deleteEvent);
        }

        function deleteEvent(e) {
            e.target.parentElement.remove();
            if (!flag) {
                repositoryLikes.textContent = 'Total Likes: ' + likes;
            }
        }

        function likeEvent() {

            if (flag) {
                likes++;
                flag = false;
                likeBtn.style.background = 'LightGray';
                repositoryLikes.textContent = 'Total Likes: ' + likes;
            }
        }
    }
}