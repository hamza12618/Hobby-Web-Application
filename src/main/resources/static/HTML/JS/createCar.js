"use strict";
console.log("page connected");

let carId = document.querySelector("#numberInput");
let carName = document.querySelector("#carName");
let carRegistration = document.querySelector("#carRegistration");

let inputBtn = document.querySelector("#inputBtn");

console.log(inputBtn);

let createCar = () => {

    console.log("button clicked");

    let carNameValue = carName.value; // Make a new variable called inputValue, equal to value of input field
    //let idValue = numberInput.value;
    let carRegistrationValue = carRegistration.value;




    let newObject = {
        //  id = idValue,
        carName: carNameValue,
        regNumber: carRegistrationValue,

    };
    console.log(newObject);

    // Run fetch function
    postFetch(newObject);


};

// POST request - Creating data and pushing it into a database
// POST request we also need to pass in a BODY of data
// Data we get back will likely be using the data we sent

// This is the object we are creating to post to the backend

let postFetch = (object) => {
    fetch("http://localhost:9000/car/create", {
        method: "POST", // We are specifying we are POSTing data
        headers: {
            "Content-type": "application/JSON", // Telling the server we are sending JSON
        },
        body: JSON.stringify(object), // We will be creating an object and passing it in here
    }).then((response) => {
        if (response.status !== 201) {
            console.error(`Status: ${response.status}`);
            return;
        }
        console.log(response);
    });
};

// Event Listener ALWAYS GO AT BOTTOM

inputBtn.addEventListener('click', createCar);