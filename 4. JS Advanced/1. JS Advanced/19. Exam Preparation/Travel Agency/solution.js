window.addEventListener('load', solution);

function solution() {
    let buttonSubmit = document.getElementById('submitBTN');
    buttonSubmit.addEventListener('click', onSubmit);

    function onSubmit() {
        const fullName = document.getElementById('fname');
        const email = document.getElementById('email');
        const phone = document.getElementById('phone');
        const address = document.getElementById('address');
        const code = document.getElementById('code');

        if (fullName.value == '' || email.value == '') {
            return;
        }
        const fn = fullName.value;
        const em = email.value;
        const ph = phone.value;
        const ad = address.value;
        const co = code.value;

        buttonSubmit.disabled = true;
        // console.log(fullName, email, phone, address, code);
        const repoPlace = document.getElementById('infoPreview');

        createElement('li', repoPlace, fullName.value, 'Full name: ');
        createElement('li', repoPlace, email.value, 'Email: ');
        createElement('li', repoPlace, phone.value, 'Phone Number: ');
        createElement('li', repoPlace, address.value, 'Address: ');
        createElement('li', repoPlace, code.value, 'Postal Code: ');

        cleanData();

        let editBtn = document.getElementById('editBTN');
        editBtn.disabled = false;
        editBtn.addEventListener('click', onEdit);

        let continueBTN = document.getElementById('continueBTN');
        continueBTN.disabled = false;
        continueBTN.addEventListener('click', onEContinue);

        function onEContinue() {
            const div = document.getElementById('block');
            div.innerHTML = '';

            createElement('h3', div, 'Thank You For Your Reservation!');
        }

        function onEdit() {
            fullName.value = fn;
            email.value = em;
            phone.value = ph;
            address.value = ad;
            code.value = co;
            const divPreviw = document.getElementById('infoPreview');
            divPreviw.innerHTML = '';

            buttonSubmit.disabled = false;
            editBtn.disabled = true;
            continueBTN.disabled = true;
        }

        function cleanData() {
            fullName.value = '';
            email.value = '';
            phone.value = '';
            address.value = '';
            code.value = '';
        }

        function createElement(element, repoPlace, variable, parameter, enterClass, enterContent) {
            const elementDom = document.createElement(`${element}`);
            if (parameter == undefined) {
                elementDom.textContent = parameter;
            } else {
                elementDom.textContent = parameter + variable;
            }

            if (enterClass != undefined) {
                elementDom.className = enterClass;
            }
            if (enterContent != undefined) {
                elementDom.textContent = enterContent;
            }
            if (repoPlace == null) {
                repoPlace = document.getElementById('infoPreview');
            }
            repoPlace.appendChild(elementDom);
        }
    }
}