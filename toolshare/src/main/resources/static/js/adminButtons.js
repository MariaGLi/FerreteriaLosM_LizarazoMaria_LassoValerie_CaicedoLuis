let menuBtn = document.querySelectorAll(".menuBtn");

menuBtn.forEach(e => {
    e.addEventListener("click",function() {
        menuBtn.forEach(x => {
            x.removeAttribute("id");
        });
        showOptions(e.textContent);
        
        e.setAttribute("id","btnActive");
    });
});

function showOptions(type){
    let subMenu = document.querySelector(".subMenu");
    subMenu.innerHTML=``;
    if (type=="Control panel") {
        subMenu.innerHTML+=`
            <div class="optionsbtn">
                <button onclick="listUsers()">List Users</button>
                <button onclick="invoices()">Invoices</button>
                <button>Rental History</button>
            </div>
        `;
    }
    if (type=="Supervision") {
        subMenu.innerHTML+=`
            <div class="optionsbtn">
                <button>State Tools</button>
                <button>Report Damage</button>
            </div>
        `;
    }
    if (type=="Reports") {
        subMenu.innerHTML+=`
            <div class="optionsbtn">
                <button>Most Rented</button>
            </div>
        `;
    }
}

function logout(){
    localStorage.removeItem('token');
}