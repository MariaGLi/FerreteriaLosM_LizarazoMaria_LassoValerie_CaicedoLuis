function invoices(){
    let content = document.querySelector(".content");
    content.innerHTML=``;

    let link = "http://localhost:8080/api/admin/invoices";
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
                <h2>Invoices</h2>
            `;
            json.forEach(e => {
                content.innerHTML+=`
                <div class="invoice">
                    <div class="invoiceHeader">
                        <div class="title" id="ToolShare">${e.name_store}</div>
                        <div class="nit"><strong>NIT: </strong>${e.nit}</div>
                        <div class="address"><strong>Address: </strong>${e.address}</div>
                        <div class="number_invioce"><strong>Number invioce: </strong>${e.number_invoice}</div>
                        <div class="cellphone"><strong>Cellphone: </strong>${e.cellphone}</div>
                        <div class="registration_date"><strong>Registration date: </strong>${e.registration_date}</div>
                        <div class="invoice_generation_date"><strong>Invoice_generation_date: </strong>${e.invoice_generation_date}</div>
                        <div class="expiration_date"><strong>Expiration_date: </strong>${e.expiration_date}</div> 
                    </div>
                    <div class="img">
                        <img src="../images/logoFerreteria.png" alt="" class="logo">
                    </div>
                    <div class="tools${e.id} tools">
                    </div>
                    <div class="person">
                        <div class="title">Cient</div>
                        <div class="names"><strong>Name: </strong>${e.person.name}</div>
                        <div class="lastName"><strong>lastName: </strong>${e.person.lastName}</div>
                        <div class="email"><strong>Email: </strong>${e.person.email}</div>
                        <div class="cellphone"><strong>Cellphone: </strong>${e.person.cellphone}</div>
                        <div class="reservation">
                            <div class="title">Reservation</div>
                            <div class="start_date"><strong>Start date: </strong>${e.payment.reservation.start_date}</div>
                            <div class="end_date"><strong>End date: </strong>${e.payment.reservation.end_date}</div>
                        </div>
                    </div>
                    <div class="payment">
                        <div class="title">Payment</div>
                        <div class="payment_method"><strong>Method: </strong>${e.payment.payment_method}</div>
                        <div class="price_total"><strong>Price total: </strong>${e.payment.price_total}</div>
                        <div class="payment_date"><strong>Date: </strong>${e.payment.payment_date}</div>
                        <div class="status"><strong>Status: </strong>${e.payment.status}</div>
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
                            <div class="names"><strong>name: </strong>${t.toolsEquipmentConstruction.name}</div>
                            <div class="description"><strong>Description: </strong>${t.toolsEquipmentConstruction.description}</div>
                            <div class="priceDay"><strong>Price day: </strong>${t.toolsEquipmentConstruction.priceDay}</div>
                            <div class="quantity"><strong>quantity: </strong>${t.quantity}</div>
                            <div class="total_value"><strong>Total value: </strong>${t.total_value}</div>
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