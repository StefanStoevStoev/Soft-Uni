function rectangle(width, height, color) {
    let rect = {
        width,
        height,
        color: color[0].toUpperCase() + color.slice(1, color.lenght),
        calcArea: function() {
            return this.height * this.width;
        }
    }
    return rect;
}


let rect = rectangle(4, 5, 'red');
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
console.log(rect.calcArea());