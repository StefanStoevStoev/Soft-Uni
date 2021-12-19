function solve(year, month, day) {

    let newDate = new Date(year, month + 1, day - 1);

    let newMonth = newDate.getMonth() - 1;

    console.log(newDate.getFullYear() + '-' + newMonth + '-' + newDate.getDate());
}
// let newDate = new Date(year, month, day - 1);
solve(2016, 9, 30);
solve(2016, 10, 1);
// newDate.getFullYear() + '-' + newDate.getMonth() + '-' + newDate.getDay()
// .toLocaleDateString('pt-br', { year: 'numeric', month: 'numeric', day: '2-digit' }).split('/').reverse().join('-');
// (`${year}, ${month}, ${day - 1}`);
// year, month, dayNew