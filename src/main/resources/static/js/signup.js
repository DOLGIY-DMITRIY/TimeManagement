let create = document.getElementById("create");
let warning = document.getElementById("warning");
let res;

create.addEventListener('click', function(){
    const username = document.getElementById("username");
    const password = document.getElementById("pass");

    if(username.value == '' || password.value == ''){
        warning.innerHTML = "Sorry, your username or password is empty! Fix that!";
    } else {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", '/signup', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() { // Call a function when the state changes.
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                res = xhr.response
                if (res == '') {
                    warning.innerHTML = "Sorry, current username is already exist"
                } else{
                    window.localStorage.setItem('UID', res)
                    redirectToUserPage()
                }
            }
        }
        xhr.send("username=" + username.value + "&password=" + password.value);
    }
})

function redirectToUserPage(){
    window.location.href = "user"
    // var xhr = new XMLHttpRequest();
    // xhr.open("POST", '/redirect-to-user-page', true);
    // xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    // xhr.onreadystatechange = function() { // Call a function when the state changes.
    // // do smth
    // }
    // xhr.send("uid=" + window.localStorage.getItem("UID"));    
}

/*
var xhr = new XMLHttpRequest();
xhr.open("POST", '/signup', true);
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.onreadystatechange = function() { // Call a function when the state changes.
    // do smth
}
xhr.send("username=dima&password=12345678");
*/
