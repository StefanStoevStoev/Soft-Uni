function encodeAndDecodeMessages() {

    let input = document.querySelectorAll('#main button')[0].addEventListener('click', initialMessage);

    function initialMessage(a) {
        let text = a.target.parentElement.querySelector('textarea').value;
        let param = 1;
        let encodeText = encode(text, param);

        document.querySelectorAll('#main textarea')[1].value = encodeText;
        a.target.parentElement.querySelector('textarea').value = '';
        let output = document.querySelectorAll('#main button')[1].addEventListener('click', nextMesage);

        function nextMesage(e) {
            let newParameter = -1;
            e.target.parentElement.querySelector('textarea').value = text;
        }

    }

    function encode(text, param) {
        let encodedText = []
        for (const char of text) {
            let charCode = char.charCodeAt(0) + param;
            encodedText += String.fromCharCode(charCode);
        }
        return encodedText;
    }
}