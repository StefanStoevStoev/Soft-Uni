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

/*<![CDATA[*/
function stepper(btn) {
    const myInput = document.getElementById("my-input");
    const price = document.getElementById('price');
    let id = btn.getAttribute("id");
    let step = myInput.getAttribute("step");
    let min = myInput.getAttribute("min");
    let max = myInput.getAttribute("max");
    let val = myInput.getAttribute("value");
    // let priceNumber = price.getAttribute("text");

    let singlePrice = [[getPrice]];

    let calcStep = (id == "increment") ? (step * 1) : (step * -1);
    let newValue = parseInt(val) + calcStep;

    if (newValue >= min && newValue <= max) {
        myInput.setAttribute("value", newValue);

        let newPrice = newValue * singlePrice;
        price.textContent = newPrice.toFixed(2) + ' лв.';
    }
}

/*]]>*/

// $(function () {
//     // console.log(1)
//     $(".dropdown-menu li a").click(function () {
//         $(".dropdown-toggle .listname").text($(this).text());
//     });
// });
$('#demolist li').on('click', function(){
    $('#datebox').val($(this).text());
});