function solve(arr) {

    let baseArry = [];
    let number = 1;
    for (let i = 0; i < arr.length; i++) {

        if (arr[i] == 'add') {
            baseArry.push(number);
        } else if (arr[i] == 'remove') {
            baseArry.pop();
        }
        number++;
    }
    return (baseArry.length != 0 ? baseArry.join('\n') : 'Empty');
}

solve(['add',
    'add',
    'add',
    'add']
)

// solve(['remove', 
// 'remove', 
// 'remove']
// )

// solve(['add',
//     'remove']
// );