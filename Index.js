

let t = document.getElementById('tabled');
let start = 0;
let last = 5;
let data = [];




async function loadData() {
    let res = await fetch("https://jsonplaceholder.typicode.com/posts");
     data = await res.json();
    console.log(res);
    load();
    
}

 function load() {
    t.innerHTML="";
    

    let table = document.createElement('table');
    table.border='1px'
    table.cellPadding="20px"
    let header = document.createElement('tr');
    header.innerHTML = `
        <th>ID</th>
        <th>Title</th>
        <th>Body</th>
    `;
    table.appendChild(header);
    data.slice(start,last).forEach(post => {
        let row = document.createElement('tr');
        row.innerHTML = `
            <td>${post.id}</td>
            <td>${post.title}</td>
            <td>${post.body}</td>
        `;
        table.appendChild(row);
    });

    t.appendChild(table);
}

document.getElementById('next').addEventListener('click', () => { if (last < data.length) { start += 5; last += 5; load(); } });
document.getElementById('prev').addEventListener('click', () => { if (start > 0) { start -= 5; last -= 5; load(); } });


loadData();
