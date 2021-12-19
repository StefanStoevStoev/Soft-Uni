async function lockedProfile() {

    const main = document.getElementById('main');
    main.replaceChildren();

    const url = `http://localhost:3030/jsonstore/advanced/profiles`;

    try {
        const res = await fetch(url);

        if (res.status != 200) {
            throw new Error("Server not found");
        }
        const data = await res.json();

        let ss = Object.values(data);

        let count = 0;
        for (const userName of ss) {

            count++;

            const div = document.createElement('div');
            div.className = 'profile';
            main.appendChild(div);

            const imgPic = document.createElement('img');
            imgPic.src = './iconProfile2.png';
            imgPic.className = 'userIcon';
            div.appendChild(imgPic);

            const labelLock = document.createElement('label');
            labelLock.textContent = 'Lock';
            div.appendChild(labelLock);

            const inputLock = document.createElement('input');
            inputLock.type = 'radio';
            inputLock.name = `user${count}Locked`;
            inputLock.value = 'lock';
            inputLock.checked = true;
            div.appendChild(inputLock);

            const labelUnlock = document.createElement('label');
            labelUnlock.textContent = 'Unlock';
            div.appendChild(labelUnlock);

            const inputUnlock = document.createElement('input');
            inputUnlock.type = 'radio';
            inputUnlock.name = `user${count}Locked`;
            inputUnlock.value = 'unlock';
            inputUnlock.checked = false;
            div.appendChild(inputUnlock);

            const br = document.createElement('br');
            div.appendChild(br);

            const labelUsername = document.createElement('label');
            labelUsername.textContent = 'Username';
            div.appendChild(labelUsername);

            const inputName = document.createElement('input');
            inputName.type = 'text';
            inputName.name = `user${count}Username`;
            inputName.value = `${userName.username}`;
            inputName.disabled = true;
            inputName.readOnly = true;
            div.appendChild(inputName);

            const divId = document.createElement('div');
            divId.id = `user${count}HiddenFields`;
            div.appendChild(divId);

            const labelEmail = document.createElement('label');
            labelEmail.textContent = 'Email:';
            divId.appendChild(labelEmail);

            const inputEmail = document.createElement('input');
            inputEmail.type = 'email';
            inputEmail.name = `user${count}Email`;
            inputEmail.value = `${userName.email}`;
            inputEmail.disabled = true;
            inputEmail.readOnly = true;
            divId.appendChild(inputEmail);

            const labelAge = document.createElement('label');
            labelAge.textContent = 'Age:';
            divId.appendChild(labelAge);

            const inputAge = document.createElement('input');
            inputAge.type = 'email';
            inputAge.name = `user${count}Age`;
            inputAge.value = `${userName.age}`;
            inputAge.disabled = true;
            inputAge.readOnly = true;
            divId.appendChild(inputAge);

            const btn = document.createElement('button');
            btn.textContent = 'Show more';
            div.appendChild(btn);

            // console.log(value);
        }

        document
            .querySelectorAll('button')
            .forEach(b => b.addEventListener('click', reveal));

        function reveal(e) {

            const unlockBtn = e.target.parentElement.querySelector('input[type="radio"][value="unlock"]').checked;

            if (unlockBtn) {

                const hiddenFields =
                    e.target.parentElement.querySelector('div');


                if (e.target.textContent == 'Show more') {
                    hiddenFields.style.display = 'block';
                    e.target.textContent = 'Hide it';
                } else if (e.target.textContent == 'Hide it') {
                    hiddenFields.style.display = 'none';
                    e.target.textContent = 'Show more';
                }


            }
        }
    } catch (err) {
        console.log(err.message)
    }
}

// lockedProfile();