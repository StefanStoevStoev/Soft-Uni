function solve(arr) {

    let min = 1000;

    let newArr = [];
    let newObj = {};

    for (const iterator of arr) {
        let obj = {};
        let token = iterator.split(' | ');

        let productName = token[1];
        let productPrice = Number(token[2]);
        let townName = token[0];

        if (newObj[token[1]] !== undefined) {

            if (obj.productPrice < min) {

                obj.productName = productName;
                obj.productPrice = productPrice;
                obj.townName = townName;
                min = obj.productPrice;

            }
        } else {
            obj.productName = productName;
            obj.productPrice = productPrice;
            obj.townName = townName;

        }
        newObj[`${token[1]}`] = obj;

        newArr[0] = 15;
    }
    let arr2 = Object.values(newObj);

    for (const objec of arr2) {
        console.log(objec);
    }


    // let arr1 = [];
    // arr1 = Object.values(newObj);

    // arr1.forEach(element => {
    //     console.log(`${element.productName} -> ${element.productPrice} (${element.townName})`);
    // });

}

solve(['Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10'
]);