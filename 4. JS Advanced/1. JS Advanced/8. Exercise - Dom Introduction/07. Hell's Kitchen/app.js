function solve() {
    document.querySelector('#btnSend').addEventListener('click', onClick);

    function onClick() {
        const firstArr = document.querySelector('#inputs textarea').value;

        let arr = JSON.parse(firstArr);

        let obj = {};

        let maxAvg = 0;
        let maxSalary = 0;
        let keyResturantName = '';

        for (let i = 0; i < arr.length; i++) {
            let salary = [];
            let nestedObj = [];
            let keyList = arr[i].split(" - ");
            let valueList = keyList[1].split(', ');

            for (let k = 0; k < valueList.length; k++) {
                let valueParameters = valueList[k].split(' ');
                nestedObj.push({ names: valueParameters[0], salary: valueParameters[1] });
                salary.push(Number(valueParameters[1]));
            }

            avgSalary = salary.reduce((a, b) => a + b, 0) / salary.length;

            if (avgSalary > maxAvg) {
                keyResturantName = keyList[0];
                maxAvg = avgSalary.toFixed(2);
                maxSalary = Math.max(...salary).toFixed(2);
            }
            obj[keyList[0]] = nestedObj;
        }

        document.querySelector('#bestRestaurant p').textContent = `Name: ${keyResturantName} Average Salary: ${maxAvg} Best Salary: ${maxSalary}`

        for (const value of obj[keyResturantName]) {
            let sal = value.salary;
            let names = value.names;
            document.querySelector('#workers p').textContent += `Name: ${names} With Salary: ${sal} `
        }
    }
}