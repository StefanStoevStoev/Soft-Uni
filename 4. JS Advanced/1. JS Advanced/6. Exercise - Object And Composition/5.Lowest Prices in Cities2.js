function solve(arr) {

    let catalogue = {};

    arr.forEach(element => {
        let [town, product, price] = element.split(" | ");
        price = Number(price);

        if (!catalogue[product]) {
            catalogue[product] = {}
        } else if (price < catalogue[product][0]) {

        }
        catalogue[product][town] = price;

    });

    let result = [];

    for (const key in catalogue) {
        let townSorted = Object.entries(catalogue[key]).sort((a, b) => a[1] - b[1]);
        let cheapestTown = townSorted[0];
        result.push(`${key} -> ${cheapestTown[1]} (${cheapestTown[0]})`);
    }
    return result.join('\n');
};



console.log(solve(['Sample Town | Sample Product | 2000',
    'New York | Sample Product | 1000.1',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Burger | 10'
]));