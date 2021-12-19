function solve(arr) {
    const town = {};
    for (let iterator of arr) {
        let [name, population] = iterator.split(' <-> ');
        population = Number(population);

        if (town[name] != undefined) {
            population += town[name];
        } else {
            town[name] = population;
        }

    }
    for (let iterator in town) {
        console.log(`${iterator} : ${town[iterator]}`);
    }
}

solve(['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000'
]);