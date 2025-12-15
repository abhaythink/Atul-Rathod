

let t = document.getElementById('tabled');
let pre=document.getElementById('previous');
let next=document.getElementById('next')

async function load() {
    let res = await fetch("https://jsonplaceholder.typicode.com/posts");
    let data = await res.json();
    console.log(res);

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
    data.forEach(post => {
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

load();
