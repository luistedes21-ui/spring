const btnSend = document.getElementById("form-send");

btnSend.onclick = e => {
    const email = document.getElementById("form-email");
    const name = document.getElementById("form-name");
    const message = document.getElementById("form-message");
    const body = { 
        name: name.value, 
        email: email.value, 
        message: message.value 
    };
    console.log(JSON.stringify(body));
    const headers = new Headers({
        "Content-Type": "application/json"
    });
    fetch('https://formu-educanow.herokuapp.com/send',{
        method: 'POST',
        headers,
        body: JSON.stringify(body)
    }).then(response => {
        if(response.ok){
            return response.json();
        }
        throw new Error('Request Failed!');
    },networkError => console.log(networkError.message))
    .then(jsonResponse => {
        name.value = "";
        email.value = "";
        message.value = "";
        Swal.fire(
            'Correo enviado',
            'Tu mensaje ha sido enviado satisfactoriamente',
            'success')
        console.log(jsonResponse);
    });
};