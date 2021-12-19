function focused() {
    let fields = Array.from(document.getElementsByTagName('input'));
    for (let field of fields) {
        field.addEventListener('focus', onFocus);
        field.addEventListener('blur', onBlur);
    }

    function onFocus(ev) {
        ev.target.parentNode.classList.add('focused');
    }

    function onBlur(ev) {
        ev.target.parentNode.classList.remove('focused');
    }
}