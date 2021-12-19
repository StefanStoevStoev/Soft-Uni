window.addEventListener('load', solve);

function solve() {

    document.getElementById('add').addEventListener('click', onclick);

    let model = document.getElementById('model');
    let year = document.getElementById('year');
    let description = document.getElementById('description');
    let price = document.getElementById('price');

    let totalPrice = 0;

    function onclick(e) {
        e.preventDefault();
        // console.log(year, price);

        if (model.value == '' || year.value == '' || description.value == '' || price.value == '') {
            return;
        }
        if (Number(year.value) < 0 || Number(price.value) < 0 || typeof Number(price.value) != "number" || typeof Number(year.value) != "number") {
            return;
        }

        const repoPlace = document.getElementById('furniture-list');

        const trInfo = document.createElement('tr');
        trInfo.className = 'info';
        repoPlace.appendChild(trInfo);

        const tdModel = document.createElement('td');
        tdModel.textContent = model.value;
        trInfo.appendChild(tdModel);

        const tdPrice = document.createElement('td');
        tdPrice.textContent = Number(price.value).toFixed(2);
        trInfo.appendChild(tdPrice);

        const tdButtons = document.createElement('td');
        trInfo.appendChild(tdButtons);

        const infoBtn = document.createElement('button');
        infoBtn.className = 'moreBtn';
        infoBtn.textContent = 'More Info';
        tdButtons.appendChild(infoBtn);

        const buyBtn = document.createElement('button');
        buyBtn.className = 'buyBtn';
        buyBtn.textContent = 'Buy it';
        tdButtons.appendChild(buyBtn);

        infoBtn.addEventListener('click', onInfo);
        buyBtn.addEventListener('click', onBuy);

        const trHide = document.createElement('tr');
        trHide.className = 'hide';
        trHide.style.display = 'none';
        repoPlace.appendChild(trHide);

        const tdYear = document.createElement('td');
        tdYear.textContent = 'Year: ' + year.value;
        trHide.appendChild(tdYear);

        const tdDescr = document.createElement('td');
        tdDescr.colSpan = 3;
        tdDescr.textContent = 'Description: ' + description.value;
        trHide.appendChild(tdDescr);

        clenData();

        function onBuy(e) {

            let deleteBtn = e.target;
            let element = deleteBtn.parentElement.parentElement;

            // console.log(element[1].textContent);

            totalPrice += Number(element.querySelectorAll('td')[1].textContent);
            const total = document.querySelector('td.total-price');
            total.textContent = totalPrice.toFixed(2);

            element.remove();
        }

        function onInfo() {
            if (trHide.style.display == 'none') {
                infoBtn.textContent = 'Less Info';
                trHide.style.display = 'contents';
            } else if (trHide.style.display == 'contents') {
                infoBtn.textContent = 'More Info';
                trHide.style.display = 'none';
            }

        }

        function clenData() {
            model.value = '';
            year.value = '';
            description.value = '';
            price.value = '';
        }
    }
}