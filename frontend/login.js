function login(event) {
    event.preventDefault(); // block page refresh

    const fullName = document.getElementById("fullName").value.trim();
    const password = document.getElementById("password").value.trim();
    const error = document.getElementById("error");

    error.innerText = "";

    // Control empty or not
    if (fullName === "" || password === "") {
        error.innerText = "Username and password cannot be blank.";
        return;
    }

    const params = new URLSearchParams();
    params.append("fullName", fullName);
    params.append("password", password);

    fetch("http://localhost:8080/api/login", {
        method: "POST",
        body: params
    })
    .then(response => response.json())
    .then(data => {
        if (data === null) {
            error.innerText = "Invalid username or password.";
        } else {
            localStorage.setItem("userId", data.id);
            localStorage.setItem("userName", data.fullName);

            error.style.color = "green";
            error.innerText = "Login successful...";

         setTimeout(() => { window.location.href = "index.html"; }, 1000);
        }
    })
    .catch(() => {
        error.innerText = "Could not connect to the server.";
    });
}
