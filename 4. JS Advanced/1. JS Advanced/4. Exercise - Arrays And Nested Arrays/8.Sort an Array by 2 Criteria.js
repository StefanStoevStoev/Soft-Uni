function solve(arr){
    arr.sort((a, b) => a.localeCompare(b));
    arr.sort((a, b) => a.length - b.length);

    return arr.join('\n');
}

console.log(solve(['alpha', 
'beta', 
'gamma']));

// console.log(solve(['Isacc', 
// 'Theodor', 
// 'Jack', 
// 'Harrison', 
// 'George']));

// console.log(solve(['test', 
// 'Deny', 
// 'omen', 
// 'Default']));