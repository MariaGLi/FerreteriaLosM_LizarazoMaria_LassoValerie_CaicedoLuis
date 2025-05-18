let btn = document.querySelectorAll("#filterBtn");

btn.forEach(e => {
    e.addEventListener("click",function() {
        btn.forEach(x => {
            x.removeAttribute("class");
        });
        e.setAttribute("class","select");
    });
});

let menuBtn = document.querySelectorAll(".menuBtn");

menuBtn.forEach(e => {
    e.addEventListener("click",function() {
        menuBtn.forEach(x => {
            console.log("hola");
            
            x.removeAttribute("id");
        });
        e.setAttribute("id","btnActive");
    });
});

getAllUsers();
function getAllUsers() {
    let link = "http://localhost:8080/api/admin/users";
    connection(link);
}

function getAllUsersFilter(filtro) {
    let link = `http://localhost:8080/api/admin/users?role=${filtro}`;
    connection(link);
}
function connection(link){
    
    let options = {
        method: 'POST',
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
                <div class="user">
                    <img src="../img/logoM3-removebg-preview.png" alt="">
                    <div class="name">${e.name} ${e.lastName}</div>
                    <button class="info">Info</button>
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