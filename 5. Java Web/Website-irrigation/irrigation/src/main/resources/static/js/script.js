

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
function changeImage() {
    if (document.getElementById("imgClickAndChange").src == "/images/pumps/pompa-hiperi-1-5.jpg"){
        document.getElementById("imgClickAndChange").src = "/images/pumps/pompa-hiperi-1-5(2).jpg";
    } else {
        document.getElementById("imgClickAndChange").src = "/images/pumps/pompa-hiperi-1-5.jpg";
    }
}