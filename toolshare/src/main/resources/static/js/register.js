function register(){
    let form = document.getElementById("form");
    form.addEventListener("submit", function(event){
        event.preventDefault();
        let name = document.querySelector(".name").value;
        let lastname = document.querySelector(".lastname").value;
        let cellphone = document.querySelector(".cellphone").value;
        let email = document.querySelector(".email").value;
        let username = document.querySelector(".username").value;
        let password = document.querySelector(".password").value;
        
        let data = {
            name: name,
            lastname: lastname,
            cellphone: cellphone,
            email: email,
            username: username,
            password: password,
            type: "Customer"
        };

        let options = {
            method: 'POST',
            body: JSON.stringify(data),
            headers:{'Content-Type': 'application/json; charset=UTF-8'}
        }

        fetch("http://localhost:8080/api/auth/register",options)
        .then(res => res.json())
        .then(json =>{
            if (json) {
                alert("Account successfully created");
                form.setAttribute('action',"./login.html");
                form.removeEventListener("submit",arguments.callee);
                form.submit();
            }
            else{
                alert("An error occurred while registering");
            }
        })
        .catch(error => console.error("An error occurred while connecting to the server."));
    });
}