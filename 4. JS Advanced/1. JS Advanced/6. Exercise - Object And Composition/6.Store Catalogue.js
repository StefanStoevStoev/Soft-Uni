function solve(arr) {
    arr.sort();
    let obj = {};

    for (let i = 0; i < arr.length; i++) {

        let [product, price] = arr[i].split(' : ');

        price = Number(price);
        let initial = product[0].toUpperCase();
        if (obj[initial] === undefined) {
            obj[initial] = {};
        }
        obj[initial][product] = price;
    }
    let finalResult = [];
    for (const key in obj) {
        let newProduct = Object.entries(obj[key]).sort((a, b) => a[0].localeCompare(b[0]));
        finalResult.push(key);
        let productString = newProduct.map(x => `  ${x[0]}: ${x[1]}`)
            .join('\n');
        finalResult.push(productString);
    }
    return finalResult.join('\n');
}

solve(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10'
]);