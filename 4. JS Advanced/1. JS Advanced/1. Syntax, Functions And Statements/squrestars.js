function squreOfStars(number){

    if(number == ''){
        number = 5;
    }
    let strings = '';
    for (let i = 0; i < number; i++) {

        for (let k = 0; k < number; k++) {
            strings += '* ';
            
        }
        strings += '\n';
    }
    console.log(strings);
}
squreOfStars('');