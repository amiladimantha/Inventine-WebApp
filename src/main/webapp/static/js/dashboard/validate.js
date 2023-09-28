y = Array.prototype.slice.call(document.getElementsByTagName("input"));
z = Array.prototype.slice.call(document.getElementsByTagName("select"));
y = y.concat(z);

for (i = 0; i < y.length; i++) {

    validateInput(y[i]);

}

function validateInput(element){

    const id = element.getAttribute("id");
    const error_class = '#'+id+' + span.error';
    const error = document.querySelector(error_class);

    displayError(element,error,'#900');

}

function displayError(element,error,error_color){

    element.addEventListener('input', function (event) {

        const isValid = (element.validity.valid);

        if (isValid) {


            error.className = 'error';
            error.style.display = 'none';
            element.className = '';
            element.style.borderColor = 'green';
            element.previousElementSibling.style.color = 'green';

        } else {

            error.style.display = 'block';
            error.className = 'error active';
            error.style.backgroundColor = error_color;
            element.style.borderColor = error_color;
            element.previousElementSibling.style.color = error_color;

        }
    });

}

function serialize(formData){

    var requestData = '';

    for (i = 0; i < formData.length; i++) {

        if(i != 0){
            requestData += '&';
        }

        requestData += `${formData[i].name}=${formData[i].value}`;

    }

    return requestData;

}

function requestHandler(elements, url,success_msg,redirect_url) {

    const request = new XMLHttpRequest();

    request.onload = () => {
        let responseObject = null;

        try {
            responseObject = JSON.parse(request.responseText);
        } catch (e) {
            alert('Something went wrong!');
        }

        if (responseObject) {
            responseHandler (responseObject,success_msg,redirect_url);
        }
    };

    const requestData = serialize(elements);

    // requestData.append('ck',ck);

    request.open('post', url);
    request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    request.send(requestData);

};

function responseHandler (responseObject,success_msg,redirect_url) {

    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 2000,
        timerProgressBar: true,
        didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer)
            toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
    })

    if (responseObject.ok) {

        Toast.fire({
            icon: 'success',
            title: success_msg,
        })

        if (redirect_url == ''){

            setTimeout(function () {
                location.reload();
            }, 1000);

        } else{

            setTimeout(function () {
                location.href = redirect_url;
            }, 1000);

        }

    } else {

        const messages = document.createElement('ul');

        responseObject.messages.forEach((message) => {
            const li = document.createElement('li');
            li.innerHTML = message;
            messages.appendChild(li);
        });


        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            footer: messages,
        })

    }

}