let menuBtn = document.querySelectorAll(".menuBtn");

let toolsInput= []
let selectTools=[]

document.addEventListener("DOMContentLoaded", () =>{
    getAllTools()
    console.log(localStorage.getItem("id")) // id client
    const searchInput= document.getElementById("searchInput");
    
    searchInput.addEventListener("input", function(){
        const search= searchInput.value.toLowerCase();
        const results= toolsInput.filter(tool =>
            tool.name.toLowerCase().includes(search)
        );
        renderTools(results);
    });

    const send= document.getElementById("send")
    send.addEventListener("click", (f)=>{
        f.preventDefault()

        const startDate = document.getElementById("startD").value
        const andDate= document.getElementById("andDate").value
        
        const newReservation= {
            "startDate": startDate,
            "endDate": andDate,
            "requestDate": "2024-06-06",
            "idClient": localStorage.getItem("id"),
            "idToolEC": selectTools.map(t=> t.id)
        }

        fetch("http://localhost:8080/reservations/addReservation",{
            method: "POST",
            headers: {
                'Authorization': `Bearer ${localStorage.getItem("token")}`,
                'Content-Type': 'application/json; charset=UTF-8'
            },
            body: JSON.stringify(newReservation)
        })
        .then(res => res.json())
    
        .then(json=>{
            alert("your reservation has been successfully registered")
            selectTools=[]
            renderSelectedT()
            
        })
        .catch(error=>{
            alert("An error occurred while connecting to the server.", error)
        })
    })
})

menuBtn.forEach(e => {
    e.addEventListener("click",function() {
        menuBtn.forEach(x =>  x.removeAttribute("id"));
            e.setAttribute("id","btnActive");
            
            const section= e.textContent.trim()
            if(section === "Reservations"){
                document.getElementById("searchInput").style.display= "none"
                document.querySelector(".tools").style.display="none"
                document.getElementById("addTool").style.display="block"
                document.querySelector(".contInvoices").style.display="none"
                document.querySelector(".paySection").style.display="none"
            }
            if (e.textContent.trim()=="Tools") {
                document.getElementById("searchInput").style.display= "block";
                document.querySelector(".tools").style.display="flex"
                document.getElementById("addTool").style.display="none"
                document.querySelector(".contInvoices").style.display="none"
                document.querySelector(".paySection").style.display="none"
            }
            if (e.textContent.trim()=="Invoices") {
                document.querySelector(".tools").style.display="none"
                document.getElementById("addTool").style.display="none"
                document.getElementById("searchInput").style.display= "none"
                document.querySelector(".contInvoices").style.display="flex"
                document.querySelector(".paySection").style.display="none"
            }
            if(e.textContent.trim()=="Payments"){
                document.querySelector(".tools").style.display="none"
                document.getElementById("addTool").style.display="none"
                document.getElementById("searchInput").style.display= "none"
                document.querySelector(".contInvoices").style.display="none"
                document.querySelector(".paySection").style.display="block"
            }
    })
})


function addTool(toolId) {
    const i= toolsInput.findIndex(t => t.id === toolId) // delete tool and inventory
    if(i !== -1){
        const selected = toolsInput.splice(i, 1)[0]
        selectTools.push(selected) // select tool and add list
        renderTools(toolsInput)
        renderSelectedT()
    }
    
}

function renderSelectedT() {
    let contentUsers = document.getElementById("selectedTools");
    contentUsers.innerHTML = ``;

    selectTools.forEach((t,i)=>{
        contentUsers.innerHTML += `
            <div class="selectedTool">
                <p>${t.name} - ${t.priceDay}</p>
                <button onclick="removeTool(${t.id})" class="delete">Delete</button>
            </div>
        `
    })
}

function removeTool(id) {
    const i= selectTools.findIndex(t => t.id ===id)
    if (i!==-1) {
        const removed= selectTools.splice(i, 1)[0]
        toolsInput.push(removed)
        renderTools(toolsInput)
        renderSelectedT()   
    }
    
}

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
        console.error("An error occurred while connecting to the server.", error)
    )
}

function renderTools(list){
    let contentUsers = document.querySelector(".tools");
    contentUsers.innerHTML = ``;
    list.forEach(e => {
        console.log(e)
        console.log(e.image)
        contentUsers.innerHTML += `
        <div class="toolss">
            <div class="addCont">
                <button class="addButton" data-id="${e.id}">+</button>
            </div>
            <div class="name"><h2>${e.name}</h2></div>  
            <img src="${e.image}" alt="" class="img">          
            <div class="name">${e.category}<br>${e.description}</br><br>${e.type}</br></div>                
            <div class="price">
                <h4 class="textPrice">$${e.priceDay}</h4>
                <div class="status">${e.status}</div>
            </div>
        </div>
        `;
    });

    document.querySelectorAll(".addButton").forEach((btn)=> {
        const idTool= parseInt(btn.getAttribute("data-id"))
        btn.addEventListener('click', ()=> addTool(idTool))
    })
}

function ShowInvoices() {
    fetch("http://localhost:8080/invoices/all", {
        method: 'GET',
        headers:{
            'Authorization': `Bearer ${localStorage.getItem("token")}`,
            'Content-Type': 'application/json; charset=UTF-8'
        }
    })
    .then(res=> res.json())
    .then(json=>{
        const userid= parseInt(localStorage.getItem("id"))
        const userInvoice= json.filter(f=> f.id_client && f.id_client.id== userid)
        let cont= document.querySelector(".contInvoices")
        cont.innerHTML =``
        console.log(userInvoice)
        if(userInvoice.length===0){
            cont.innerHTML=`<p>no hay facturas disponibles para este usuario</p>`
            return;
        }
        
        userInvoice.forEach(e=>{
            cont.innerHTML+= `
                <div class="invoice">
                    <h4>${e.number_invoice}</h4>
                    <div class="dataInvoice">
                        <h6>Expiration date:</h6>
                        <h6>${e.expiration_date}</h6>
                    </div>
                    <div class="fechadecreacion">
                        <h6>Creation date:</h6>
                        <h6>${e.registration_date}</h6>
                    </div>
                    
                    <button type="button" class="view" onclick="downloadInvoice(${e.id})">
                            <img src="../images/icons8-descargar-96.png" alt="" class="imgDownload">
                    </button>
                </div>
            `
        })
    })
    .catch(error =>
        console.error("An error occurred while connecting to the server.", error)
    )
}
function downloadInvoice(idInvoice) {
    fetch(`http://localhost:8080/invoiceDownloads/${idInvoice}/download`,{
        headers: {
            'Authorization': `Bearer ${localStorage.getItem("token")}`
        }
    })
    .then(res=> res.blob())
    .then(blob =>{
        const url = window.URL.createObjectURL(blob)
        const a = document.createElement('a')
        a.href= url
        a.download="invoice_" + idInvoice + ".pdf"
        document.body.appendChild(a)
        a.click()
        a.remove()
    })
    .catch(error =>
        console.error("An error occurred while connecting to the server.", error)
    )
}

function showPayByStatusPending() {
    fetch("http://localhost:8080/pay/payPending", {
        method: 'GET',
        headers:{
            'Authorization': `Bearer ${localStorage.getItem("token")}`,
            'Content-Type': 'application/json; charset=UTF-8'
        }
    })
    .then(res=> res.json())
    .then(json=>{
        const userId= parseInt(localStorage.getItem("id"))

        const userPayment= json.filter(p=>
            p.id_reservations &&
            p.id_reservations.id_user_client &&
            p.id_reservations.id_user_client.id===userId
        )

        let payCont = document.querySelector(".paySection")
        payCont.innerHTML = ""
        console.log(json)
        if (userPayment.length===0) {
            alert("there are no outstanding payments")
            return
        }
        
        userPayment.forEach(f=>{
            console.log(f)
            let idPayment= f.id
            payCont.innerHTML+=`
            <form class="pay">
                <p class="text">Pay</p>
                <div class="contPrice">
                    <p>Price</p>
                    <p>${f.price_total}</p>
                </div>
                <div class="contMethod">
                    <label for="method">
                        <img src="../images/icons8-tarjetas-bancarias-100.png" alt="" class="methodImg">
                    </label>
                    <select id="select" class="enterMethod" required>
                        <option value="Nequi">Nequi</option>
                        <option value="Bancolombia">Bancolombia</option>
                        <option value="Davivienda">Davivienda</option>
                        <option value="PopularBank">Popular Bank</option>
                    </select>
                </div>
                <button type="button" id="send" ">Send</button>
            </form>
            `
            document.getElementById("send").addEventListener("click", function (f){
                f.preventDefault();
                const pay= {
                    "id": idPayment,
                    "payment_method": document.getElementById("select").value
                }

                fetch(`http://localhost:8080/pay/payBy/${idPayment}`,{
                    method: "PUT",
                    headers: {
                        'Authorization': `Bearer ${localStorage.getItem("token")}`,
                        'Content-Type': 'application/json; charset=UTF-8'
                    },
                    body: JSON.stringify(pay)
                })
                .then(res=> res.json())
                .then(json=>{
                    alert("Payment has been successfully completed")
                })
                .catch(error =>
                    console.error("An error occurred while connecting to the server.", error)
                )
            })
        })
    })
    .catch(error =>
        console.error("An error occurred while connecting to the server.", error)
    )
}

function sendPay(id) {

    
}