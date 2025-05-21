let toolsInput= [];
document.addEventListener("DOMContentLoaded", () =>{
    getAllTools();

    const searchInput= document.getElementById("searchInput");

    searchInput.addEventListener("input", function(){
        const search= searchInput.value.toLowerCase();
        const results= toolsInput.filter(tool =>
            tool.name.toLowerCase().includes(search)
        );
        renderTools(results);
    });
})

function getAllTools() {
    let link = "http://localhost:8080/api/customer/toolsAvailable";
    connection(link);
}

function connection(link){
    
    let options = {
        method: 'GET',
        headers:{
            'Authorization': `Bearer ${localStorage.getItem("token")}`,
            'Content-Type': 'application/json; charset=UTF-8'
        }
    }

    fetch(link,options)
    .then(res => res.json())
    .then(json =>{
        if (json) {
            console.log(json);
            toolsInput= json;
            renderTools(toolsInput);
        }
        else{
            alert("ocurrió un error");
        }
    })
    .catch(error =>
        console.error("An error occurred while connecting to the server.")
    )
}

function renderTools(list){
    let contentUsers = document.querySelector(".tools");
    contentUsers.innerHTML = ``;
    list.forEach(e => {
        contentUsers.innerHTML += `
        <div class="toolss">
            <img src="../img/logoM3-removebg-preview.png" alt="">
            <div class="name">${e.name}</div>
            <div class="status">${e.status}</div>
        </div>
        `;
    });
}