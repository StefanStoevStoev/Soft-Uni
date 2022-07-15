const myInput = document.getElementById("my-input");
function stepper(btn){
    let id = btn.getAttribute("id");
    let min = myInput.getAttribute("min");
    let max = myInput.getAttribute("max");
    let step = myInput.getAttribute("step");
    let val = myInput.getAttribute("value");

    let calcStep = (id == "increment") ? (step*1) : (step * -1);
    let newValue = parseInt(val) + calcStep;

    if(newValue >= min && newValue <= max){
        myInput.setAttribute("value", newValue);
    }
}
const singlePrice = document.getElementById("singlePrice");
function changePrice(price){

}

function validate() {
    if (document.username.value === "" && document.password.value === "") {
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