'use strict';
let garageId = document.querySelector("#numberInput");
let garageName = document.querySelector("#garageName");
let garageLocation = document.querySelector("#garageLocation");

let inputBtn = document.querySelector("#inputBtn");


// A function that saves the value of the input field
let deleteGarage = () => {

    console.log("button clicked");

    let garageNameValue = garageName.value; // Make a new variable called inputValue, equal to value of input field
    //let idValue = numberInput.value;
    let garageLocationValue = garageLocation.value;





    let newObject = {
        //  id = idValue,
        garageName = garageName.value,
        garageLocationValue = garageLocation.value,

    };

    // Run fetch function
    postFetch(newObject);


};
// Delete Request - ID of the thing we want to delete
// Isnt going to be submitted as a body, it is going to be submitted as a URL parameter 

// Get by ID    - URL or Query parameters
// Update by ID - URL or Query parameters

let deleteRequest = (type, category) => {

    fetch(`http://localhost:9000/garage/delete/${type}/${category}}`, {
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