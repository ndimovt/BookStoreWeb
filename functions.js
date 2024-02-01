function submitInfo(){
    var boname = document.getElementById("bname").value;
    var auname = document.getElementById("aname").value;
    var bookPrice = document.getElementById("price").value;

    var data = {
        authorName : auname,
        bookName : boname,
        price : bookPrice   
    };
    fetch("http://localhost:8003/add",{
        method: "POST",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(data =>{console.log('Success', data);
})
    .catch(error =>{
        console.error("Error", error);
});
}

function deleteRecord(){
    var name = document.getElementById("deleteName").value;
    
    fetch("http://localhost:8003/delete/" + encodeURIComponent(name),{
        method: "DELETE", 
        headers: {
            "Content-Type":"application/json"
        },
        body: JSON.stringify(name),
    })
    .then(response => response.json())
    .catch(error => {
        console.error("Error", error);
    })
}

function updateRecordByName(){
    var bookName = document.getElementById("updRecord").value;
    var newPrice = document.getElementById("newPrice").value;

    var newData = {
        bookName: bookName,
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
    .then(data => {console.log(data);})
    .catch(error => {console.log(error);});
}

