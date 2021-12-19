function editElement(reference, match, replacer) {

    const initialText = reference.textContent;
    const re = new RegExp(match, 'm');
    const repl = initialText.replace(re, replacer);

    reference.textContent = repl;
}