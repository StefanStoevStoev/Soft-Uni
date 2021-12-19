function solve(arr) {

    let finalArr = [];
    for (const iterator of arr) {
        let [name, level, items] = iterator.split(' / ');
        level = Number(level);
        items = items ? items.split(', ') : [];

        finalArr.push({ name, level, items });

    }
    console.log(JSON.stringify(finalArr));
}

solve(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
]);

// solve(['Jake / 1000 / Gauss, HolidayGrenade']);