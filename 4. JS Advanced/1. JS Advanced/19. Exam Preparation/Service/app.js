window.addEventListener('load', solve);

function solve() {

    document.querySelector('#right button').addEventListener('click', onSend);

    function onSend(e) {

        e.preventDefault();

        let typeProduct = document.querySelector('#type-product');
        let descriptionProduct = document.querySelector('#description');
        let clientName = document.querySelector('#client-name');
        let clientPhone = document.querySelector('#client-phone');


        if (descriptionProduct.value == '' || clientName.value == '' || clientPhone.value == '') {
            return;
        }

        const repoPlace = document.getElementById('received-orders');

        const container = document.createElement('div');
        container.className = 'container';
        repoPlace.appendChild(container);


        const propH2 = document.createElement('h2');
        propH2.textContent = 'Product type for repair: ' + typeProduct.value;
        container.appendChild(propH2);

        const propH3 = document.createElement('h3');
        propH3.textContent = 'Client information: ' + clientName.value + ', ' + clientPhone.value;
        container.appendChild(propH3);

        const propH4 = document.createElement('h4');
        propH4.textContent = 'Description of the problem: ' + descriptionProduct.value;
        container.appendChild(propH4);

        const secondContainer = document.createElement('div');
        secondContainer.className = 'container';
        let h2 = propH2;
        let h3 = propH3;
        let h4 = propH4;

        cleanData();

        const startBtn = document.createElement('button');
        startBtn.className = 'start-btn'
        startBtn.textContent = 'Start repair';
        container.appendChild(startBtn);

        const finishBtn = document.createElement('button');
        finishBtn.className = 'finish-btn'
        finishBtn.textContent = 'Finish repair';
        container.appendChild(finishBtn);
        finishBtn.disabled = true;

        startBtn.addEventListener('click', toRepair);
        finishBtn.addEventListener('click', toFinish);

        function toRepair() {
            startBtn.disabled = true;
            finishBtn.disabled = false;
        }

        function cleanData() {
            descriptionProduct.value = '';
            clientName.value = '';
            clientPhone.value = '';
        }

        function toFinish() {

            const repoCompletedOrders = document.getElementById('completed-orders');

            repoCompletedOrders.appendChild(secondContainer);
            secondContainer.appendChild(h2);
            secondContainer.appendChild(h3);
            secondContainer.appendChild(h4);

            repoPlace.removeChild(container);

            const btnClear = document.querySelector('#completed-orders button');
            btnClear.addEventListener('click', toDelete);

        }

        function toDelete(e) {

            const event = e.target.parentElement;
            event.removeChild(secondContainer);

        }

    }

}