function toUpper(input){

    let newInput = input.toUpperCase();

    let arrayList = newInput.split(/(?:\W|^)*(?:s*)(?:\W)/);

    let newArray = [];

    for (let i = 0; i < arrayList.length; i++) {

        let strings = arrayList[i];
        if(strings != ''){
            newArray.push(strings);
        }
    }

    console.log(newArray.join(', '));
}

toUpper('hello');