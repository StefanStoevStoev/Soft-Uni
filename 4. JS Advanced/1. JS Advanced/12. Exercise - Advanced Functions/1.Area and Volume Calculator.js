function solve(area1, volume1, input) {

    let parsed = JSON.parse(input);

    let result = []
    for (const num of parsed) {

        let area = area1.apply(num);
        let volume = volume1.apply(num);
        let obj = { area, volume };

        result.push(obj);
    }
    return result;
}

let str = '[ { "x": "1", "y": "2", "z": "10" }, { "x": "7", "y": "7", "z": "10" }, { "x": "5", "y": "2", "z": "10" }]'

console.log(solve(area, volume, str));


// let result = []
// for (const num of parsed) {

//     let x = Number(num.x);
//     let y = Number(num.y);
//     let z = Number(num.z);

//     function area() {
//         return Math.abs(this.x * this.y * this.z);
//     }
//     volume: function volume() {
//         return Math.abs(this.x * this.y);
//     }
//     let newResult = {
//         area,
//         volume
//     };
//     result.push(newResult);
// }

function area() {
    return Math.abs(this.x * this.y * this.z);
}
volume: function volume() {
    return Math.abs(this.x * this.y);
}