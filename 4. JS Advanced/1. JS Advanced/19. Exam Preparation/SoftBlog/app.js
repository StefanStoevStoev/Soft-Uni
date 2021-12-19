function solve() {

    const createBtn = document.getElementsByTagName('button')[0].addEventListener('click', takeAllData);


    //  console.log(createBtn);


    function takeAllData(e) {

        e.preventDefault();

        let creator = document.getElementById('creator');
        let title = document.getElementById('title'); //JavaScript
        let category = document.getElementById('category');
        let content = document.getElementById('content');

        let repositoryPlace = document.querySelector('.site-content main section');

        let article = document.createElement('article');
        repositoryPlace.appendChild(article);

        let h1 = document.createElement('h1');
        h1.textContent = title.value;
        article.appendChild(h1);

        let pCategory = document.createElement('p');
        pCategory.textContent = 'Category:';
        article.appendChild(pCategory);

        let strongCategory = document.createElement('strong');
        strongCategory.textContent = category.value;
        pCategory.appendChild(strongCategory);

        let pCreator = document.createElement('p')
        pCreator.textContent = 'Creator:';
        article.appendChild(pCreator);

        let strongCreator = document.createElement('strong');
        strongCreator.textContent = creator.value;
        pCreator.appendChild(strongCreator);

        let pContent = document.createElement('p');
        pContent.textContent = content.value;
        article.appendChild(pContent);

        creator.textContent = '';
        title.textContent = '';
        category.textContent = '';
        content.textContent = '';

        let divBtn = document.createElement('div');
        divBtn.classList.add('buttons');
        article.appendChild(divBtn);

        let btnDelete = document.createElement('button');
        btnDelete.classList.add('btn', 'delete');
        btnDelete.textContent = 'Delete';
        divBtn.appendChild(btnDelete);

        let btnArchive = document.createElement('button');
        btnArchive.classList.add('btn', 'archive');
        btnArchive.textContent = 'Archive';
        divBtn.appendChild(btnArchive);


        //   repositoryPlace.appendChild(article);
        btnDelete.addEventListener('click', deleteData);
        btnArchive.addEventListener('click', archiveData);

    }

    function deleteData(e) {
        let deleteBtn = e.target;
        let element = deleteBtn.parentElement.parentElement;
        element.remove();
    }

    function archiveData(e) {
        let articleToArchive = e.target.parentElement.parentElement;
        let archiveOl = document.querySelector('.archive-section ol');

        let achiveLis = Array.from(archiveOl.querySelectorAll('li'));
        let articleTitle = articleToArchive.querySelector('h1').textContent;

        let newTitleLi = document.createElement('li');
        newTitleLi.textContent = articleTitle;

        articleToArchive.remove();

        achiveLis.push(newTitleLi);
        achiveLis
            .sort((a, b) => a.textContent.localeCompare(b.textContent))
            .forEach(li => archiveOl.appendChild(li));
    }
}