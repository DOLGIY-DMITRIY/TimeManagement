let create = document.getElementById("create");

create.addEventListener('click', function(){
    const username = document.getElementById("username");
    const password = document.getElementById("pass");

    if(username.value == '' || password.value == ''){
        document.getElementById("warning").innerHTML = "Sorry, your username or password is empty! Fix that!";
    } else {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", '/signup', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() { // Call a function when the state changes.
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                var result = JSON.parse(xhr.response);
                console.log(result);
            }
        }
        xhr.send("username=" + username.value + "&password=" + password.value);
    }
})

// var xhr = new XMLHttpRequest();
// xhr.open("POST", '/signup', true);
// xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
// // xhr.send("timeStart=" + startsAt + "&timeEnd=" + endsAt + "&description=" + description);
// xhr.send("username=dima&password=12345678");
// console.log(xhr.response);

