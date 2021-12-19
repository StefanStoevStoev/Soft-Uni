function solve(arr) {
    let board = [
        [false, false, false],
        [false, false, false],
        [false, false, false]
    ]

    for (let i = 0; i < arr.length; i++) {
        let token = arr[i].split('\s+');
        let x = token[0];
        let y = token[1];
        if (i % 2 == 0 && board[x][y] == false) {
            board[x][y] = 'X';
        } else if (i % 2 != 0 && board[x][y] == false) {
            board[x][y] = 'O';
        } else {
            console.log("This place is already taken. Please choose another!");
        }

        if (board[x][0] == board[x][1] == board[x][2] && board != false) {
            console.log(`Player ${board[x][y]} wins`);
        }
    }
};