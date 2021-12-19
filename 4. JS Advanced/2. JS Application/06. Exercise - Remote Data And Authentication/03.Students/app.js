async function onCreate(e) {
    e.preventDefault();
    const firstName = document.querySelector('input[name="firstName"]').value;
    const lastName = document.querySelector('input[name="lastName"]').value;
    const facultyNumber = document.querySelector('input[name="facultyNumber"]').value;
    const grade = document.querySelector('input[name="grade"]').value;
    const student = { firstName, lastName, facultyNumber, grade };
    const result = await createStudent(student);

    appendStudentInformation(firstName, 0);
    appendStudentInformation(lastName, 1);
    appendStudentInformation(facultyNumber, 2);
    appendStudentInformation(grade, 3);

    createContact(result);

}

async function appendInformation() {

    try {

        const res = await fetch(url);
        const data = await res.json();

        const arrayStudents = Object.values(data);

        const tBody = document.querySelector('tbody');

        for (let i = 0; i < arrayStudents.length; i++) {
            const tdStudent = document.createElement('td');
            tBody.appendChild(tdStudent);

        }

        let arrNames = [];
        let arrLastNames = [];
        let arrNumber = [];
        let arrGrade = [];
        for (const valueStudent of arrayStudents) {
            arrNames.push(valueStudent.firstName);
            arrLastNames.push(valueStudent.lastName);
            arrNumber.push(valueStudent.facultyNumber);
            arrGrade.push(valueStudent.grade);
        }

        appendStudentInformation(arrNames, 0);
        appendStudentInformation(arrLastNames, 1);
        appendStudentInformation(arrNumber, 2);
        appendStudentInformation(arrGrade, 3);

    } catch (err) {
        console.log(err.message);
    }
}

function appendStudentInformation(student, count) {

    const tdStudent = document.getElementsByTagName('td')[count];

    const studentLength = student.length;

    for (let i = 0; i < studentLength; i++) {

        const tr = document.createElement('tr');

        if (count == 0) {

            const firstName = typeof student == 'string' ? student : student.shift();
            tr.textContent = firstName;

        } else if (count == 1) {

            const lastName = typeof student == 'string' ? student : student.shift();
            tr.textContent = lastName;

        } else if (count == 2) {

            const fn = typeof student == 'string' ? student : student.shift();
            tr.textContent = fn;

        } else if (count == 3) {
            const grade = typeof student == 'string' ? student : student.shift();
            tr.textContent = grade;
        }

        tdStudent.appendChild(tr);
    }
}

async function createStudent(student) {
    const res = await fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(student)
    });
    const result = await res.json();
    return result;
}


const url = 'http://localhost:3030/jsonstore/collections/students';
appendInformation();
document.getElementById('submit').addEventListener('click', onCreate);