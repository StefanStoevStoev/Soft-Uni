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

function changeImage() {
    if (document.getElementById("imgClickAndChange").src == "/images/pumps/pompa-hiperi-1-5.jpg") {
        document.getElementById("imgClickAndChange").src = "/images/pumps/pompa-hiperi-1-5(2).jpg";
    } else {
        document.getElementById("imgClickAndChange").src = "/images/pumps/pompa-hiperi-1-5.jpg";
    }
}


function stepper(btn) {

    const myInput = btn.parentElement.querySelector("input");
    console.log(myInput);
    let price = btn.parentElement.parentElement.querySelector("p.price");
    const initPrice = btn.parentElement.parentElement.querySelector("p.single-price").getAttribute("value");
    let clas = btn.getAttribute("class");
    let step = myInput.getAttribute("step");
    let min = myInput.getAttribute("min");
    let max = myInput.getAttribute("max");
    let val = myInput.getAttribute("value");

    let calcStep = (clas == "text-center increment") ? (step * 1) : (step * -1);
    let newValue = parseInt(val) + calcStep;

    if (newValue >= min && newValue <= max) {
        myInput.setAttribute("value", newValue);

        let discount = 500/(500 + newValue);
        let newPrice = newValue * parseFloat(initPrice) * discount;

        price.textContent = newPrice.toFixed(2) + ' лв.';
    }
}


// $(function () {
//     // console.log(1)
//     $(".dropdown-menu li a").click(function () {
//         $(".dropdown-toggle .listname").text($(this).text());
//     });
// });
// $('#demolist li').on('click', function(){
//     $('#datebox').val($(this).text());
// });


// function stepper(btn) {
//     const myInput = document.getElementById("my-input");
//     const price = document.getElementById('price');
//     let id = btn.getAttribute("id");
//     let step = myInput.getAttribute("step");
//     let min = myInput.getAttribute("min");
//     let max = myInput.getAttribute("max");
//     let val = myInput.getAttribute("value");
//     // let priceNumber = price.getAttribute("text");
//
//     let singlePrice = [[getPrice]];
//
//     let calcStep = (id == "increment") ? (step * 1) : (step * -1);
//     let newValue = parseInt(val) + calcStep;
//
//     if (newValue >= min && newValue <= max) {
//         myInput.setAttribute("value", newValue);
//
//         let newPrice = newValue * singlePrice;
//         price.textContent = newPrice.toFixed(2) + ' лв.';
//     }
// }

// function stepper(btn) {
//     // let ss2 = btn.getAttribute("value");
//     // console.log(ss2);
//     const myInput = document.querySelector(".my-input");
//     const price = document.querySelector("p.price");
//     const initPrice = document.querySelector("p.single-price").getAttribute("value");
//     let clas = btn.getAttribute("class");
//     let step = myInput.getAttribute("step");
//     let min = myInput.getAttribute("min");
//     let max = myInput.getAttribute("max");
//     let val = myInput.getAttribute("value");
//
//     let calcStep = (clas == "text-center increment") ? (step * 1) : (step * -1);
//     let newValue = parseInt(val) + calcStep;
//
//     if (newValue >= min && newValue <= max) {
//         myInput.setAttribute("value", newValue);
//
//         let newPrice = newValue * parseFloat(initPrice);
//         price.textContent = newPrice.toFixed(2) + ' лв.';
//     }
// }