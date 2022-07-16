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