function solve(arr, number){
    let position =  arr.length - number % arr.length;

    let endArr = arr.slice(0, position);
    let beginArr = arr.slice(position, arr.length);

    let arrNew = beginArr.concat(endArr);

    console.log(arrNew.join(' '));
}

solve(['1', 
'2', 
'3', 
'4'], 
2);

// solve(['Banana', 
// 'Orange', 
// 'Coconut', 
// 'Apple'], 
// 15);