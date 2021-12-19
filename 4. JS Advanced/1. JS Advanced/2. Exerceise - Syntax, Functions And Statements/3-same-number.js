function sameNumber(numbers) {

    let flags = true;
    let sum = 0;
    const letters = numbers.toString();

    for (let i = 0; i < letters.length; i++) {
        let nextNumber = Number(letters.charAt(i));

        if (letters.charAt(0) != nextNumber) {
            flags = false;
        }
        sum += nextNumber;
    }
    console.log(flags);
    console.log(sum);
}

sameNumber(1234);