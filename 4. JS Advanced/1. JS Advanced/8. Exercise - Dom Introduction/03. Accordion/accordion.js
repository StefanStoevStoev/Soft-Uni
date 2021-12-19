function toggle() {
    const button = document.querySelector('.button').innerHTML;
    const text = document.getElementById('extra');


    document.querySelector('.button').textContent = button === 'More' ? 'Less' : 'More';

    text.style.display = text.style.display == "none" || text.style.display == " " ? text.style.display = "block" : text.style.display = "none";
}