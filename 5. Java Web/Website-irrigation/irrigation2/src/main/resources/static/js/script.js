function validate() {
    if (document.username.value == "" && document.password.value === "") {
        alert("Username and password are required");
        document.username.focus();
        return false;
    }
    if (document.username.value === "") {
        alert("Username is required");
        document.username.focus();
        return false;
    }
    if (document.password.value === "") {
        alert("Password is required");
        document.password.focus();
        return false;
    }
}

function show(btn) {
    /* Access image by id and change
    the display property to block*/
    let myInputImg = btn.parentElement
        .parentElement
        .parentElement
        .parentElement
        .parentElement
        .parentElement
        .parentElement.querySelector(".imageBtn");
    let button = btn.parentElement.querySelector(".btnID");

    if (myInputImg.style.display == "block") {
        myInputImg.style.display = "none";
        // document.getElementById('btnID').style.display = "none";
        button.textContent = "Покажи";
    } else {
        myInputImg.style.display = "block";
        button.textContent = "Скрий";
    }
}

function stepper(btn) {

    const myInput = btn.parentElement.querySelector("input");
    let price = btn.parentElement.parentElement.querySelector("p.price2");

    let numsDTO = btn.parentElement.parentElement.querySelector("input.pieces");

    let numbers = btn.parentElement.parentElement.querySelector("p.availability");
    const initPrice = btn.parentElement.parentElement.querySelector("p.single-price").getAttribute("value");
    let clas = btn.getAttribute("class");
    const step = myInput.getAttribute("step");
    let min = myInput.getAttribute("min");
    let max = myInput.getAttribute("max");
    let val = myInput.getAttribute("value");

    let calcStep = (clas == "text-center increment") ? (step * 1) : (step * -1);
    let newValue = parseInt(val) + calcStep;
    let num = parseInt(numbers.getAttribute("value")) - newValue;

    if (num >= 0) {

        if (newValue >= min && newValue <= max) {
            myInput.setAttribute("value", newValue);

            let discount = 501 / (500 + newValue);
            let newPrice = newValue * parseFloat(initPrice) * discount;
            numbers.textContent = (num).toString() + ' бр.';
            price.textContent = newPrice.toFixed(2) + ' лв.';

            numsDTO.textContent = num;
            // numbers.style.display = 'none';
        }
    }
}

function setAttributeData(event) {
    const initPrice = event.parentElement.parentElement.querySelector("p.price2").textContent;
    let parsePrice = initPrice.split(" ");
    let price = parsePrice[0];
    let id = event.parentElement.parentElement.querySelector("input.id").value;
    let numbers = event.parentElement.parentElement.querySelector("input.my-input").value;

    event.parentElement.querySelectorAll("input")[0].setAttribute("text", id);
    event.parentElement.querySelectorAll("input")[1].setAttribute("value", price);
    event.parentElement.querySelectorAll("input")[2].setAttribute("value", numbers);
}

function setAttributeDataAuthHome(event) {
    const initPrice = event.parentElement.parentElement.parentElement.parentElement.querySelector("p.price2").textContent;
    let parsePrice = initPrice.split(" ");
    let price = parsePrice[0];
    let id = event.parentElement.parentElement.querySelector("input.id").value;
    let name = event.parentElement.parentElement.querySelector("input.name-element").value;
    let numbers = event.parentElement.parentElement.parentElement.parentElement.querySelector("input.my-input").value;

    event.parentElement.parentElement.querySelectorAll("input")[0].setAttribute("text", id);
    event.parentElement.parentElement.querySelectorAll("input")[1].setAttribute("text", name);
    event.parentElement.parentElement.querySelectorAll("input")[2].setAttribute("value", price);
    event.parentElement.parentElement.querySelectorAll("input")[3].setAttribute("value", numbers);
}

function setAdminDTO(event) {

    let id = event.parentElement.querySelector("input.id").value;
    let name = event.parentElement.querySelector("input.name-element").value;
    let price = event.parentElement.querySelector("input.price").value;
    let numbers = event.parentElement.querySelector("input.pieces").value;

    event.parentElement.querySelectorAll("input")[0].setAttribute("text", id);
    event.parentElement.querySelectorAll("input")[1].setAttribute("text", name);
    event.parentElement.querySelectorAll("input")[2].setAttribute("value", price);
    event.parentElement.querySelectorAll("input")[3].setAttribute("value", numbers);
}