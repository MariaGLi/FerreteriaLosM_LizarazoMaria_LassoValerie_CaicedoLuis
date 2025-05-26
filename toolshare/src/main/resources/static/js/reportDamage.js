function reportDamage(){
    let content = document.querySelector(".content");
    content.innerHTML=``;

    let link = "http://localhost:8080/api/admin/damageReport";

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
            content.innerHTML+=`
                <h2>Damage Reports</h2>
            `;
            json.forEach(e => {
                content.innerHTML+=`
                    <div class="damageReport">
                        <div class="damage">
                            <div class="title titleTool">Damage</div>
                            <div><strong>description: </strong>${e.description}</div>
                            <div><strong>Report Date: </strong>${e.reportDate}</div>
                            <div><strong>Solution date: </strong>${e.solutionDate}</div>
                            <div><strong>Status: </strong>${e.status}</div>
                        </div>
                        <div class="tool">
                            <div class="title titleTool">Equipment Construction</div>
                            <div class="names"><strong>name: </strong>${e.tool.name}</div>
                            <div class="type"><strong>Type: </strong>${e.tool.type}</div>
                            <div class="description"><strong>Description: </strong>${e.tool.description}</div>
                        </div>
                        <div class="reservationDamage">
                            <div class="title titleTool">Reservation</div>
                            <div class="start_date"><strong>Start date: </strong>${e.reservation.start_date}</div>
                            <div class="end_date"><strong>End date: </strong>${e.reservation.end_date}</div>
                        </div>
                        <div class="ContUpdate">
                            <button class="button${e.id}" onclick="showForm(${e.id})">Update</button>
                        </div>
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
let button = "";
function showForm(id){
    
    let form = document.getElementById("form");
    form.innerHTML=`
        <div class="update">
            <div class="input">
                <input class="descrip" type="text" placeholder="Description Damage">
            </div>
            <div class="input">
                <input class="solutionDate" type="date">
            </div>
            <div class="input">
                <select id="statusDamage">
                    <option value="None" selected>None</option>
                    <option value="Pending">Pending</option>
                    <option value="Under">Under</option>
                    <option value="Resolved">Resolved</option>
                </select>
            </div>
            <button class="submit" onclick="updateDamage(${id})">Update</button>
        </div>
    `;

    button = document.querySelector(`.button${id}`);

}
document.addEventListener('click',function(e) {
    const form= document.getElementById("form");

    if(!form) return;

    if (!form.contains(e.target) && !e.target.className.startsWith("button")) {
        form.innerHTML=``;
    }
});
function updateDamage(id) {
    let descrip = document.querySelector(".descrip").value;
    let solution_date = document.querySelector(".solutionDate").value;   
    let statusDamage = document.querySelector("#statusDamage").value;
    
    let data = {};
    if (descrip != '') {
        data.description = descrip;
    }
    if (solution_date != '') {
        data.solutionDate = solution_date;
    }
    if (statusDamage != 'None') {
        data.status = statusDamage;
    }

    console.log(data);
    

    let options = {
        method: 'PATCH',
        body: JSON.stringify(data),
        headers:{
            'Authorization': `Bearer ${localStorage.getItem("token")}`,
            'Content-Type': 'application/json; charset=UTF-8'
        }
    }

    fetch(`http://localhost:8080/api/admin/damageReport/${id}`,options)
    .then(res => res.json())
    .then(json =>{
        if (json) {
            alert("Damage Report has been update");
            let form = document.getElementById("form");
            form.innerHTML=``;
            reportDamage();
        }
        else{
            alert("An error occurred while registering")
        }
    })
    .catch(error => console.error("An error occurred while connecting to the server."));

    
    let form = document.getElementById("form");
    form.innerHTML=``;
    reportDamage();
}