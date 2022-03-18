let logoutBtn = document.querySelector('#logout-btn');

logoutBtn.addEventListener('click', () => {
    localStorage.removeItem('jwt');

    window.location = '/index.html';
});

window.addEventListener('load', (event) => {
    populateAssignmentsTable();
});

async function populateAssignmentsTable() {
    const URL = 'http://localhost:8080/assignments';

    let res = await fetch(URL, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${localStorage.getItem('jwt')}` // Include our JWT into the request
        }
        // credentials: 'include' // This is if you're using HttpSession w/ JSESSIONID cookies
    })

    if (res.status === 200) {
        let assignments = await res.json();

        for (let assignment of assignments) {
            let tr = document.createElement('tr');

            let td1 = document.createElement('td');
            td1.innerText = assignment.id;

            let td2 = document.createElement('td');
            td2.innerText = assignment.assignmentName;

            let td3 = document.createElement('td');
            td3.innerText = (assignment.graderUsername ? assignment.grade : 'Not graded');
            td3.style.color = (assignment.graderUsername ? td3.style.color : 'RGB(255, 0, 0)');

            let td4 = document.createElement('td');
            td4.innerText = assignment.studentUsername;

            let td5 = document.createElement('td');
            td5.innerText = (assignment.graderUsername ? assignment.graderUsername : 'Not graded');
            td5.style.color = (assignment.graderUsername ? td5.style.color : 'RGB(255, 0, 0)');

            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
            tr.appendChild(td5);

            let tbody = document.querySelector('#assignments-tbl > tbody');
            tbody.appendChild(tr);
        }
    }
    
}
