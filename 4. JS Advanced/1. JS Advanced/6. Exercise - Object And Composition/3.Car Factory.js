function solve(obj) {
    let newObj = {};

    newObj.model = obj.model;
    newObj.engine = {};

    if (obj.power <= 90) {
        newObj.engine.power = 90;
        newObj.engine.volume = 1800;
    } else if (obj.power <= 120) {
        newObj.engine.power = 120;
        newObj.engine.volume = 2400;
    } else if (obj.power <= 200) {
        newObj.engine.power = 200;
        newObj.engine.volume = 3500;
    }
    newObj.carriage = {};
    newObj.carriage.type = obj.carriage;
    newObj.carriage.color = obj.color;

    if (obj.wheelsize % 2 == 0) {
        let wheels = [obj.wheelsize - 1, obj.wheelsize - 1, obj.wheelsize - 1, obj.wheelsize - 1];
        newObj.wheels = wheels;
    } else {
        let wheels = [obj.wheelsize, obj.wheelsize, obj.wheelsize, obj.wheelsize];
        newObj.wheels = wheels;
    }
    return newObj;
};

// console.log(solve({
//         model: 'VW Golf II',
//         power: 90,
//         color: 'blue',
//         carriage: 'hatchback',
//         wheelsize: 14
//     }
// ));

console.log(solve({
    model: 'Opel Vectra',
    power: 110,
    color: 'grey',
    carriage: 'coupe',
    wheelsize: 17
}));