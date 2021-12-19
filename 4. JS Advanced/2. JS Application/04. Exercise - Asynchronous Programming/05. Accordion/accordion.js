async function solution() {

    const url = 'http://localhost:3030/jsonstore/advanced/articles/list';
    const main = document.getElementById('main');
    try {

        const res = await fetch(url);
        const data = await res.json();

        for (const value of data) {

            const divAcc = document.createElement('div');
            divAcc.className = 'accordion';
            main.appendChild(divAcc);

            const divHead = document.createElement('div');
            divHead.className = 'head';
            divAcc.appendChild(divHead);

            const span = document.createElement('span');
            span.textContent = `${value.title}`;
            divHead.appendChild(span);

            const button = document.createElement('button');
            button.className = 'button';
            button.id = `${value._id}`;
            button.textContent = 'More';
            divHead.appendChild(button);

            // console.log(value._id);

            const divExtra = document.createElement('div');
            divExtra.className = 'extra';
            divAcc.appendChild(divExtra);

            const p = document.createElement('p');
            divExtra.appendChild(p);
        }

        document
            .querySelectorAll('button').forEach(b => b.addEventListener('click', openInformation));

        async function openInformation(e) {

            const id = e.target.id;

            const urlDetails = `http://localhost:3030/jsonstore/advanced/articles/details/${id}`;

            try {
                const res = await fetch(urlDetails);
                const data = await res.json();

                const pElement = e.target.parentElement.parentElement.querySelector('div p');
                pElement.textContent = data.content;

                const divUnhide = e.target.parentElement.parentElement.querySelector('div.extra');

                if (divUnhide.style.display == 'block') {

                    divUnhide.style.display = 'none';
                    e.target.textContent = 'Less';

                } else {

                    divUnhide.style.display = 'block'
                    e.target.textContent = 'More';
                }

            } catch (ex) {
                console.log(ex.message);
            }
        }
    } catch (err) {

        console.log(err.message);

    }
}
solution();