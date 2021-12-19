// function solve(array) {

//     let arr = [];
//     for (const iterator of array) {

//         let [command, str] = iterator.split(' ');

//         let ss = arrFunc[command];

//         function arrFunc(str) {
//             return {
//                 add: (str) => arr.push(str),
//                 remove: (str) => arr.filter(x => x != str),
//                 print: () => console.log(arr.join(','))
//             }
//         }
//     }
// }

function processCommands(commands) {
    let commandProcessor = function() {
        let list = [];
        return {
            add: (newItem) => list.push(newItem),
            remove: (item) => list = list.filter(x => x != item),
            print: () => console.log(list.join(","))
        }
    };

    let func2 = commandProcessor();
    for (let cmd of commands) {
        let [cmdName, arg] = cmd.split(' ');
        func2[cmdName](arg);
    }
}
processCommands(['add hello', 'add again', 'remove hello', 'add again', 'print']);
processCommands(['add pesho', 'add george', 'add peter', 'remove peter', 'print']);
// solve(['add hello', 'add again', 'remove hello', 'add again', 'print'])