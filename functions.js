function submitInfo(){
    var boname = document.getElementById("bname");
    var auname = document.getElementById("aname");
    var bookPrice = document.getElementById("price");

    var data = {
        authorName : auname.value,
        bookName : boname.value,
        price : bookPrice.value   
    };
    fetch("http://localhost:8003/add",{
        method: "POST",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(data =>{console.log('Success', data);})

    .catch(error =>{ console.error("Error", error);});
    boname.value = "";
    auname.value = "";
    bookPrice.value = "";
}

function updateRecordByName(){
    var bName = document.getElementById("updRecord").value;
    var newPrice = document.getElementById("newPrice").value;

    var newData = {
        bookName: bName,
        price: newPrice
    };

    fetch("http://localhost:8003/updatePrice",{
        method: "PUT",
        headers: {
            "Content-Type":"application/json"
        },
        body: JSON.stringify(newData),
    })
    .then(response => response.json())
    .then(data => {console.log(data);
    document.getElementById("updRecord").value = "";
    document.getElementById("newPrice").value = "";})
    .catch(error => {console.log(error);});
    bName.value ="";
    newPrice.value = "";
}

function getInfo(){
    window.open("allBooks.html", "width=75%", "heigth=75%");
}

function specificSearch(){
    window.open("byAuthor.html", "width=75%", "heigth=75%");
}

function openUpdate(){
    window.open("update.html", "width=75%", "heigth=75%");
}
function openAdd(){
    window.open("insert.html", "width=75%", "heigth=75%");
}

/*function populateTable(){
    let name = document.getElementById("specAuthor").value;
    fetch("http://localhost:8003/printAll", {
        method: "GET",
        headers:{
        "Accept":"application/json"},
    })
    .then(response => response.json())
    .then(data => {
        data.forEach(item => {
            let bookObj  = {
                authorName: item.authorName,
                bookName: item.bookName,
                price: item.price
            };
            console.log(bookObj);
        });
    })
}*/

function populateTable() {
    fetch("http://localhost:8003/printAll", {
        method: "GET",
        headers: {
            "Accept": "application/json"
        }
    })
    .then(response => response.json())
    .then(data => {
        const tableBody = document.querySelector("#dataTable tbody");
        tableBody.innerHTML = "";

        data.forEach(item => {
            let row = tableBody.insertRow();
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);

            cell1.textContent = item.authorName;
            cell2.textContent = item.bookName;
            cell3.textContent = item.price;

            let button = document.createElement("button");
            button.textContent = "Delete";
            button.addEventListener("click", () => {
                let bookId = item.id;
                console.log(bookId);
                fetch("http://localhost:8003/delete/" + encodeURIComponent(bookId), {
                    method: "DELETE",
                    headers: {
                        "Content-Type": "application/json"
                    }
                })
                .then(response => {
                    if (response.ok) {
                        populateTable();
                    } else {
                        console.error("Error:", response.statusText);
                    }
                })
                .catch(error => {
                    console.error("Error:", error);
                });
            });
            cell4.appendChild(button);
        });
    })
    .catch(error => console.error(error));
}

function findByName(){
    let name = document.getElementById("specAuthor").value;
    fetch("http://localhost:8003/find/" + encodeURIComponent(name),{
        method: "GET",
        headers:{
            "Accept":"application/json"
        }
    })
    .then(response => response.json())
    .then(data => {
        const table = document.querySelector("#dataTable tbody").innerHTML = "";
        data.forEach(item => {
            let row = table.insertRow();
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);

            cell1.textContent = item.bookName;
            cell2.textContent = item.price;
        });
    }).catch(error => console.error(error));
}
