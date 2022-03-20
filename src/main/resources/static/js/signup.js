let create = document.getElementById("create");

create.addEventListener('click', function(){
    const xhr = new XMLHttpRequest()
    xhr.open("POST", "/signup", true)
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function() { // Call a function when the state changes.
	    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
	    	let res = JSON.parse(xhr.response)
	    	console.log(res);
	    }
	}
    xhr.send("username=dima&password=12345678");
})

// var xhr = new XMLHttpRequest();
// xhr.open("POST", '/signup', true);
// xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
// // xhr.send("timeStart=" + startsAt + "&timeEnd=" + endsAt + "&description=" + description);
// xhr.send("username=dima&password=12345678");
// console.log(xhr.response);

