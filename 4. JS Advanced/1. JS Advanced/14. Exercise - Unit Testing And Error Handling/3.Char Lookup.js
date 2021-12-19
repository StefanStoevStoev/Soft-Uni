function lookupChar(string, index) {
    if (typeof(string) !== 'string' || !Number.isInteger(index)) {
        return undefined;
    }
    if (string.length <= index || index < 0) {
        return "Incorrect index";
    }

    // let ss = typeof(4.4);
    // console.log(ss);
    return string.charAt(index);
}

console.log(lookupChar('Wfdfd', 45));
module.exports = lookupChar;