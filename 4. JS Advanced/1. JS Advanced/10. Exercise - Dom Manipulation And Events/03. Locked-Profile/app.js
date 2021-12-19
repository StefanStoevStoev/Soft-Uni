function lockedProfile() {

    Array.from(document.querySelectorAll('.profile button')).forEach(e => e.addEventListener('click', onTuggle));

    function onTuggle(a) {

        const profile = a.target.parentElement;
        const isActive = profile.querySelector('input[type="radio"][value="unlock"]').checked;

        if (isActive) {
            const infoDiv = Array.from(a.target.parentElement.querySelectorAll('div')).find(d => d.id.includes('HiddenFields'));

            if (a.target.textContent == 'Show more') {
                infoDiv.style.display = 'block';
                a.target.textContent = 'Hide it';
            } else {
                infoDiv.style.display = '';
                a.target.textContent = 'Show more'
            }
        }
    }
}