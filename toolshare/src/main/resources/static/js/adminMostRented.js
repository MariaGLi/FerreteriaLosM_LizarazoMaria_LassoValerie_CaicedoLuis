function mostRented(){
    let content = document.querySelector('.content');
    content.innerHTML=`
    <form class="formRent" action="">
        <div>
            <label for="start_date">Start date</label>
            <input class="start_date" type="date" required>
        </div>
        <div>
            <label for="end_date">End date</label>
            <input class="end_date" type="date" required>
        </div>
        <button class="sub" onclick="mostRentedDate()">✓</button>
    </form>
    <h2>Most Rented</h2>
    <div class="most">
        <div class="mostRented">

        </div>
    </div>
    `;

    let data = {};
    apiMostRented(data);
}

function mostRentedDate(){
    let form = document.querySelector(".formRent");
    form.addEventListener("submit", function(event){
        event.preventDefault();

        let start_date = document.querySelector(".start_date").value;
        let end_date = document.querySelector(".end_date").value;
        console.log(end_date);
        

        let data = {
            startDate:start_date,
            endDate:end_date
        }
        
        apiMostRented(data);
    });
}

function apiMostRented(data) {

    let options = {
        method: 'POST',
        body: JSON.stringify(data),
        headers:{
            'Authorization': `Bearer ${localStorage.getItem("token")}`,
            'Content-Type': 'application/json; charset=UTF-8'
        }
    }

    fetch(`http://localhost:8080/api/admin/mostRented`,options)
    .then(res => res.json())
    .then(json =>{
        if (json) {
            let most = document.querySelector('.most');
            most.innerHTML=`
                <div class="mostRented">

                </div>
            `;

            let mostRented = document.querySelector('.mostRented');
            mostRented.innerHTML=``;
            
            for (let i = 0; i < 3; i++) {
                mostRented.innerHTML+=`
                    <div class="rented">
                        <h3>${json[i].name}</h3>
                        <div><strong>Description: </strong>${json[i].description}</div>
                        <div><strong>Quantity: </strong>${json[i].quantity}</div>
                        <div><strong>Total: </strong>${json[i].quantity}</div>
                    </div>
                `;
            }

            most.innerHTML+=`
                <div class="porcentaje" style="--porcentaje1:${json[0].percentage}; --porcentaje2:${json[1].percentage}; --porcentaje3:${json[2].percentage};">
                    <h3>percentage of rent</h3>
                    <br>
                    <svg>
                        <circle pathlength="100"/>
                        <circle pathlength="100"/>
                        <circle pathlength="100"/>
                        <circle pathlength="100"/>
                    </svg>
                    <br>
                    <li class="li1">${json[0].name} ${json[0].percentage}%</li>
                    <li class="li2">${json[1].name} ${json[1].percentage}%</li>
                    <li class="li3">${json[2].name} ${json[2].percentage}%</li>
                    <li class="li4">Others ${Math.round(100 - (json[0].percentage + json[1].percentage + json[2].percentage))}%</li>
                </div>
            `;
        }
        else{
            alert("An error occurred")
        }
    })
    .catch(error => console.error("An error occurred while connecting to the server."));
}