//http://localhost:8080/InventoryManagement/all

let menuBtn = document.querySelectorAll(".menuBtn");

menuBtn.forEach(e => {
    e.addEventListener("click",function() {
        menuBtn.forEach(x =>  x.removeAttribute("id"));
            e.setAttribute("id","btnActive");

            if(e.textContent.trim() === "+"){
                document.querySelector(".tools").innerHTML = `
                    <div id="addTool">
                        <form action="" method="post" class="form">
                            <div class="newTool">
                                <label for="name">Name</label>
                                <input type="text" class="enterTool" id="name" required>
                            </div>
                            <div class="newTool">
                                <label for="type">Type</label>
                                <select id="type" class="enterTool" required>
                                    <option value="Tool">Tool</option>
                                    <option value="EquipmentConstruction">Equipment Construction</option>
                                </select>
                            </div>
                            <div class="newTool">
                                <label for="category">Category</label>
                                <input type="text" class="enterTool" id="category" required>
                            </div>
                            <div class="newTool" required>
                                <label for="dateRegister">Date Register</label>
                                <input type="date" class="enterTool"  id="dateRegister">
                            </div>
                            <div class="newTool">
                                <label for="price">$</label>
                                <input type="text" class="enterTool"  id="price" required>
                            </div>
                            <div class="newTool">
                                <label for="description">Description</label>
                                <input type="text" class="enterTool" id="description" required>
                            </div>
                            <div class="newTool">
                                <label for="urlImg">Url image</label>                        
                                <input type="url"class="enterTool"  id="urlImg" required>
                            </div>
                            <button type="submit" id="send">Send</button>
                        </form>
                    </div>
                `;
                document.getElementById("searchInput").style.display= "none";
                
                document.getElementById("send").addEventListener("click", function (f){
                    f.preventDefault();
                    
                    console.log(document.getElementById("urlImg").value)
                    const addTool= {
                        
                        "supplierId": 21,
                        "type": document.getElementById("type").value,       
                        "name": document.getElementById("name").value.trim(),
                        "category": document.getElementById("category").value.trim(),
                        "dateRegister": document.getElementById("dateRegister").value,
                        "priceDay": document.getElementById("price").value,
                        "description": document.getElementById("description").value.trim(),
                        "image": document.getElementById("urlImg").value.trim()
                    };

                    fetch("http://localhost:8080/InventoryManagement/toolsAdd",{
                        method: "POST",
                        headers: {
                            'Authorization': `Bearer ${localStorage.getItem("token")}`,
                            'Content-Type': 'application/json; charset=UTF-8'
                        },
                        body: JSON.stringify(addTool)
                    })
                    .then(res=>{    
                        if(res.ok){
                            alert("Good");
                            getAllTools();
                            document.querySelector("form").reset();
                            document.getElementById("addTool").style.display = "none";
                            document.getElementById("searchInput").style.display = "block";
                        } else {
                            alert("the tool was added")
                        }
                    })
                    .catch(error => {
                        alert("connection error", error);
                    });
                });


            } 
            if(e.textContent.trim()=== "Inventory"){
                document.getElementById("searchInput").style.display= "block";
                renderTools(toolsInput);
            }
            if(e.textContent.trim()=== "Reservations"){
                document.getElementById("searchInput").style.display= "none";
                
                fetch("http://localhost:8080/reservationManagement/pending",{
                    method: "GET",
                    headers:{
                        'Authorization': `Bearer ${localStorage.getItem("token")}`,
                        'Content-Type': 'application/json; charset=UTF-8'
                    }
                })
                .then(res=> res.json())
                .then(json=>{

                    if(json.length===0){
                        alert("they are no pending reservations")
                        return
                    }

                    let contentUsers = document.querySelector(".tools");
                    contentUsers.innerHTML = ``;
                    json.forEach(res=>{
                        contentUsers.innerHTML +=`
                            <div class="reservation">
                                <h4>Request date ${res.request_date}</h4>
                                <div class="dates">
                                    <div class="date">Start date</div>
                                    <div class="date">End date</div>
                                </div>
                                <div class="dates">
                                    <div class="date">${res.start_date}</div>
                                    <div class="date">${res.end_date}</div>
                                </div>
                                <select class="statusOption enterTool"  data-id="${res.id}" required>
                                    <option value="Pending">${res.status}</option>
                                    <option value="Accept">Accept</option>
                                    <option value="Reject">Reject</option>
                                </select>
                            </div>
                            `
                    })

                    document.querySelectorAll(".statusOption").forEach(f =>{
                        f.addEventListener("change", function(){
                            const reservationId= this.getAttribute("data-id")
                            const action = this.value

                            if (action === "Accept" || action=== "Reject") {
                                updateStatusReservation(reservationId, action)
                            }
                        })
                    })
                })
                
            }
            if (e.textContent.trim()==="Reservations Returns"){
                
                document.getElementById("searchInput").style.display= "none";
                fetch("http://localhost:8080/reservationManagement/return",{
                    method: "GET",
                    headers:{
                        'Authorization': `Bearer ${localStorage.getItem("token")}`,
                        'Content-Type': 'application/json; charset=UTF-8'
                    }
                })
                .then(res=> res.json())
                .then(json=>{

                    if(json.length===0){
                        alert("they are no return reservations")
                        return
                    }

                    let contentUsers = document.querySelector(".tools");
                    contentUsers.innerHTML = ``;
                    json.forEach(res=>{
                        contentUsers.innerHTML +=`
                            <div class="reservation">
                                <h4>Request date ${res.request_date}</h4>
                                <div class="dates">
                                    <div class="date">Start date</div>
                                    <div class="date">End date</div>
                                </div>
                                <div class="dates">
                                    <div class="date">${res.start_date}</div>
                                    <div class="date">${res.end_date}</div>
                                </div>
                                <select class="statusOption enterTool"  data-id="${res.id}" required>
                                    <option value="Pending">${res.status}</option>
                                    <option value="ReturnAccept">Accept</option>
                                    <option value="ReturnReject">Reject</option>
                                </select>
                            </div>
                            `
                    })

                    document.querySelectorAll(".statusOption").forEach(f =>{
                        f.addEventListener("change", function(){
                            const reservationId= this.getAttribute("data-id")
                            const action = this.value

                            if (action === "ReturnAccept" || action=== "ReturnReject") {
                                updateStatusReservation(reservationId, action)
                            }
                        })
                    })
                })
            }

            if(e.textContent.trim()==="Damage"){
                
                document.getElementById("searchInput").style.display= "none";
                fetch(`http://localhost:8080/reservationManagement/returnAccept`, {
                    method: "GET",
                    headers: {
                        'Authorization': `Bearer ${localStorage.getItem("token")}`,
                        'Content-Type': 'application/json; charset=UTF-8'
                    }
                })
                
                .then(res=> res.json())
                .then(json=>{

                    if(json.length===0){
                        alert("they are no damage")
                        return
                    }

                    let contentUsers = document.querySelector(".tools");
                    contentUsers.innerHTML = ``;

                    json.forEach(res=>{
                        //get id
                        var idReservationD= res.id;
                        var idClientD= res.id_user_client.id
                        
                        res.toolsECList.forEach(tool=>{
                            const uniqueid= `${tool.id}`
                            console.log(tool.id)
                            console.log(uniqueid)
                            const html = `
                                <form id="form-${uniqueid}" method="post" class="form">
                                    <div class="newTool">
                                        <h2>Reservation: ${idReservationD}</h2>
                                    </div>
                                    <div class="newTool">
                                        <h5>Name Client: ${res.id_user_client.name} ${res.id_user_client.last_name}</h4>
                                        <h5>Tool: ${tool.name}</h5>
                                        <h5>Cell: ${res.id_user_client.cellphone}</h5>
                                    </div>
                                    
                                    <div class="newTool">
                                        <label for="description">Description</label>
                                        <input type="text" class="enterTool" id="description-${uniqueid}" required>
                                    </div>

                                    <div class="newTool">
                                        <label for="status">Status Report</label>
                                        <select id="status-${uniqueid}" class="enterTool" required>
                                            <option value="Pending">Pending</option>
                                            <option value="Under">Under</option>
                                            <option value="Resolved">Resolved</option>
                                            
                                        </select>
                                    </div>
                                    <div class="newTool">
                                        <label for="dateReport">Date Report</label>
                                        <input type="date" class="enterTool"  id="dateRegister-${uniqueid}">
                                    </div>
                                    <button type="submit" id="send-${uniqueid}" class="send">Send</button>
                                </form>
                            `
                            contentUsers.insertAdjacentHTML("beforeend", html)

                            const idForm= document.getElementById(`form-${uniqueid}`)
                            idForm.addEventListener("submit", function (f){
                                f.preventDefault()

                                const description= document.getElementById(`description-${uniqueid}`).value.trim()
                                const statusR= document.getElementById(`status-${uniqueid}`).value
                                const reportDate= document.getElementById(`dateRegister-${uniqueid}`).value
                            
                                const newReport= {
                                    "reporDate": reportDate,
                                    "solutionDate": "",
                                    "description": description,
                                    "status": statusR,
                                    "idClient": idClientD,
                                    "idToolEC": tool.id,
                                    "idReservation": idReservationD
                                }
                                
                                fetch("http://localhost:8080/damagedReport/report",{
                                    method: "POST",
                                    headers: {
                                        'Authorization': `Bearer ${localStorage.getItem("token")}`,
                                        'Content-Type': 'application/json; charset=UTF-8'
                                    },
                                    body: JSON.stringify(newReport)
                                })
                                .then(res=>{    
                                    if(res.ok){
                                        alert("New report added successfully.");
                                        document.getElementById(`form-${uniqueid}`).remove()
                                    } else {
                                        alert("Failed to create report.")
                                    }
                                })
                                .catch(error => {
                                    alert("Connection error: ", error);
                                })
                            })
                        })
                    })
                }
            )}
            if (e.textContent.trim()=== "Payments") {
                document.getElementById("searchInput").style.display= "none";
                fetch("http://localhost:8080/payment/paid",{
                    method: "GET",
                    headers:{
                        'Authorization': `Bearer ${localStorage.getItem("token")}`,
                        'Content-Type': 'application/json; charset=UTF-8'
                    }
                })
                .then(res=> res.json())
                .then(json=>{

                    if(json.length===0){
                        alert("they are no")
                        return
                    }

                    let contentUsers = document.querySelector(".tools");
                    contentUsers.innerHTML = ``;
                    json.forEach(res=>{
                        contentUsers.innerHTML +=`
                        <div class="reservation">
                            <h4>Payment vouchers</h4>
                            <div class="dates">
                                <div class="date">${res.payment_date}</div>
                                <div class="date">${res.payment_method}</div>
                                
                            </div>
                            <h4>$${res.price_total}</h4>
                            <div class="status">${res.status}</div>
                        </div>
                    `
                    })
                })
            }  
    })
})

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
    let link = "http://localhost:8080/InventoryManagement/all";
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
            <img src="${e.image}" alt="" class="imgTools">
            <div class="name">${e.name}</div>
            <div class="status">${e.status}</div>
        </div>
        `;
    });
}

function updateStatusReservation(id, action) {
    const url= `http://localhost:8080/reservationManagement/${action.toLowerCase()}/${id}`;

    fetch(url, {
        method: "PUT",
        headers: {
            'Authorization': `Bearer ${localStorage.getItem("token")}`,
            'Content-Type': 'application/json; charset=UTF-8'
        }
    })
    .then(res=>{
        if(res.ok){
            alert(`${action.toLowerCase()}ed successfully`)
            document.querySelector("#btnActive").click()
        } else {
            alert(`Failed to ${action.toLowerCase()} reservation`)
        }
    })
    .catch(error =>{
        console.error("error updating reservation: ", error)
    })
}

function logout(){
    localStorage.removeItem('token');
}