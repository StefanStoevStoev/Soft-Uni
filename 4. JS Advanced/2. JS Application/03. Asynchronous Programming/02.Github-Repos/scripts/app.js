function loadRepos() {
    const username = document.getElementById('username');
    const list = document.getElementById('repos');

    const url = `https://api.github.com/users/${username.value}/repos`;

    fetch(url)
        .then(res => {
            if (res.ok == false) {
                throw new Error(`${res.status} ${res.statusText}`);
            }
            return res.json();
        })
        .then(handleResponse)
        .catch(handleError);

    function handleResponse(data) {


        list.innerHTML = '';

        for (let resp of data) {
            const liElement = document.createElement('li');
            liElement.innerHTML = `<a href="${resp.html_url}">
${resp.full_name}
</a>`;
            list.appendChild(liElement);
        }
    }

    function handleError(error) {
        list.innerHTML = '';
        list.textContent = `${error.message}`;
    }
}