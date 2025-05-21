function rentalHistory(){
    let content = document.querySelector(".content");
    content.innerHTML=``;

    let link = "http://localhost:8080/api/admin/rentalHistory";

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
                <h2>Rental Hystory</h2>
            `;
            json.forEach(e => {
                content.innerHTML+=`
                    <div class="rentals">
                        <div class="reservation">
                            <div class="title">Reservation</div>
                            <div class="requestDate"><strong>Request date: </strong>${e.requestDate}</div>
                            <div class="start_date"><strong>Start date: </strong>${e.startDate}</div>
                            <div class="end_date"><strong>End date: </strong>${e.endDate}</div>
                            <div class="status"><strong>Status: </strong>${e.status}</div>
                        </div>
                        <div class="person personRental">
                            <div class="title">Cient</div>
                            <div class="names"><strong>Name: </strong>${e.person.name}</div>
                            <div class="lastName"><strong>lastName: </strong>${e.person.lastName}</div>
                            <div class="email"><strong>Email: </strong>${e.person.email}</div>
                            <div class="cellphone"><strong>Cellphone: </strong>${e.person.cellphone}</div>
                        </div>
                        <div class="tools${e.id} tools toolsRental">
                        </div>
                    </div>
                `;

                let tool = document.querySelector(`.tools${e.id}`);
                tool.innerHTML+=`
                    <div class="title titleTool">Equipment Construction</div>
                `;
                e.tools.forEach(t => {
                    tool.innerHTML+=`
                        <div class="tool">
                            <div class="names"><strong>name: </strong>${t.name}</div>
                            <div class="type"><strong>Type: </strong>${t.type}</div>
                            <div class="description"><strong>Description: </strong>${t.description}</div>
                            <div class="priceDay"><strong>Price day: </strong>${t.priceDay}</div>
                        </div>
                    `;
                });
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