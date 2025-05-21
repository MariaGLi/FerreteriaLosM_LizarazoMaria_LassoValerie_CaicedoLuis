function toolsStatus() {
    let content = document.querySelector(".content");
    content.innerHTML = ``;
    content.innerHTML += `
        <h2>Tools Status</h2>
        <div class="users">
            
        </div>
    `;

    let link = "http://localhost:8080/api/admin/stateTools";

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
            let contentUsers = document.querySelector(".users");
            contentUsers.innerHTML = ``;
            json.forEach(e => {
                contentUsers.innerHTML += `
                    <div class="tool toolStatus">
                        <div class="names"><strong>name: </strong>${e.name}</div>
                        <div class="description"><strong>Description: </strong>${e.description}</div>
                        <div class="category"><strong>Category: </strong>${e.category}</div>
                        <div class="priceDay"><strong>Price day: </strong>${e.price}</div>
                        <div class="status"><strong>Status: </strong>${e.status}</div>
                    </div>
                `;
            });
        }
        else{
            alert("ocurrió un error");
        }
    })
    .catch(error =>
        console.error("An error occurred while connecting to the server.")
    )
}