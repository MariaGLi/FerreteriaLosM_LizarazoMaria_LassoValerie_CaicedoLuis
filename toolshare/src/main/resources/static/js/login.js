
function login(){
    let form = document.getElementById("form");
    form.addEventListener("submit", function(event){
        event.preventDefault();

        let username = document.querySelector(".username").value;
        let password = document.querySelector(".password").value;
        
        let data = {
            username: username,
            password: password
        };

        let options = {
            method: 'POST',
            body: JSON.stringify(data),
            headers:{'Content-Type': 'application/json; charset=UTF-8'}
        }

        fetch("http://localhost:8080/api/auth/login",options)
        .then(res => res.json())
        .then(json =>{
            if (json) {
                console.log("session started");
                console.log(json.token);
                console.log(json.type);
                if (json.type == 'Admin') {
                    form.setAttribute('action',"./admin.html");
                    localStorage.setItem('token',json.token);
                    form.removeEventListener("submit",arguments.callee);
                    form.submit();
                }

                if (json.type == 'Supplier') {
                    form.setAttribute('action',"./Supplier.html");
                    localStorage.setItem('token',json.token);
                    form.removeEventListener("submit",arguments.callee);
                    form.submit();
                }
            }
            else{
                console.log("An error has occurred while logging in.");
            }
        })
        .catch(error => console.log("An error occurred while connecting to the server."));
    })

    
}