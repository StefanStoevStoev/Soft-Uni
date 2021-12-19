function solve(arr, criteria) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
        compareTo(other, criteria1) {
            if (typeof this[criteria1] === 'string') {
                return this[criteria1].localeCompare(other[criteria1]);
            } else {
                return this[criteria1] - other[criteria1];
            }
        }
    };

    let newArray = [];

    for (const elements of arr) {
        let token = elements.split('|');

        let destination = token[0];
        let price = Number(token[1]);
        let status = token[2];

        let ticketAdd = new Ticket(destination, price, status);
        // console.log(ticketAdd);
        newArray.push(ticketAdd);
    }
    newArray.sort((a, b) => a.compareTo(b, criteria));
    return newArray;
}

// console.log(solve(['Philadelphia|94.20|available',
//         'New York City|95.99|available',
//         'New York City|95.99|sold',
//         'Boston|126.20|departed'
//     ],
//     'destination'
// ));

console.log(solve(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'
    ],
    'status'
));