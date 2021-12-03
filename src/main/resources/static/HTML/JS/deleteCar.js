'use strict';
let carId = document.querySelector("#numberInput");
let carName = document.querySelector("#carName");
let carRegistration = document.querySelector("#carRegistration");

let inputBtn = document.querySelector("#inputBtn");


// A function that saves the value of the input field
let deleteCar = () => {

    console.log("button clicked");

    let carNameValue = carName.value; // Make a new variable called inputValue, equal to value of input field
    //let idValue = numberInput.value;
    let carRegistrationValue = carRegistration.value;





    let newObject = {
        //  id = idValue,
        carName = carNameValue,
        regNumber = carRegistrationValue,

    };

    // Run fetch function
    postFetch(newObject);


};
// Delete Request - ID of the thing we want to delete
// Isnt going to be submitted as a body, it is going to be submitted as a URL parameter 

// Get by ID    - URL or Query parameters
// Update by ID - URL or Query parameters

let deleteRequest = (type, category) => {

    fetch("http://localhost:9000/car/delete", {
        method: `DELETE`
    })
        .then((response) => {
            if (response.status !== 200) {
                console.error(`Status: ${response.statusText}`);
                return;
            }
            response.json()
                .then((data) => {
                    console.log(data);
                });
        });

};

deleteRequest(7);