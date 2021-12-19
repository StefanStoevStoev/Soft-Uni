window.addEventListener('load', solve);

function solve() {

    document.querySelector('#right button').addEventListener('click', onSend);

    const type = document.querySelector('#type-product');
    const description = document.querySelector('#description');
    const clientName = document.querySelector('#client-name');
    const clientPhone = document.querySelector('#client-phone');

    function onSend(ev) {
        ev.preventDefault();

        if (description.value == '' || clientName.value == '' || clientPhone.value == '') {
            return;
        }

        const repoPlace = document.getElementById('received-orders');

        const container = document.createElement('div');
        container.className = 'container';
        repoPlace.appendChild(container);


        const h2 = document.createElement('h2');
        h2.textContent = 'Product type for repair: ' + type.value;
        container.appendChild(h2);

        const h3 = document.createElement('h3');
        h3.textContent = 'Client information: ' + clientName.value + ', ' + clientPhone.value;
        container.appendChild(h3);

        const h4 = document.createElement('h4');
        h4.textContent = 'Description of the problem: ' + description.value;
        container.appendChild(h4);

        const btnStart = document.createElement('button');
        btnStart.className = 'start-btn'
        btnStart.textContent = 'Start repair';
        container.appendChild(btnStart);

        const btnFinish = document.createElement('button');
        btnFinish.className = 'finish-btn'
        btnFinish.textContent = 'Finish repair';
        container.appendChild(btnFinish);
        btnFinish.disabled = true;

        btnStart.addEventListener('click', onRepair);
        btnFinish.addEventListener('click', onFinished);

        description.value = '';
        clientName.value = '';
        clientPhone.value = '';

        const containerN = document.createElement('div');
        containerN.className = 'container';
        const h2N = h2;
        const h3N = h3;
        const h4N = h4;

        function onRepair() {
            btnStart.disabled = true;
            btnFinish.disabled = false;

        }

        function onFinished() {
            const repoCompletedOrders = document.getElementById('completed-orders');

            repoCompletedOrders.appendChild(containerN);
            containerN.appendChild(h2N);
            containerN.appendChild(h3N);
            containerN.appendChild(h4N);

            repoPlace.removeChild(container);

            const btnClear = document.querySelector('#completed-orders button');
            btnClear.addEventListener('click', onDelete);
        }

        function onDelete(e) {
            const event = e.target.parentElement;
            event.removeChild(containerN);
        }
    }
}