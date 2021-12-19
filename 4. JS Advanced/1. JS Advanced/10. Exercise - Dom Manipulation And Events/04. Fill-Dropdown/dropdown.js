function addItem() {
    let textInput = document.getElementById('newItemText').value;
    let valueInput = document.getElementById('newItemValue').value;

    let option = document.createElement('option');
    option.textContent = textInput;
    option.value = valueInput;

    document.getElementById('menu').appendChild(option);
    document.getElementById('newItemText').value = '';
    document.getElementById('newItemValue').value = '';
}