`use strict`;
console.log("page connected");

let carId = document.querySelector("#numberInput");
let carName = document.querySelector("#carName");
let carRegistration = document.querySelector("#carRegistration");

let inputBtn = document.querySelector("#inputBtn");
console.log(inputBtn);

let putData = () => {


    let carNameValue = carName.value;

    let carRegistrationValue = carRegistration.value;




    inputcarName.value = "";
    inputcarRegistration.value = "";


    let newObject = {

        carName = carNameValue,
        regNumber = carRegistrationValue,


    };

    putFetch(newObject);

    return newObject
};


let putFetch = (object) => {
    fetch("http://localhost:9000/car/update", {
        method: "PUT",
        headers: {
            "Content-type": "application/JSON",
        },
        body: JSON.stringify(object),
    }).then((response) => {
        if (response.status !== 202) {
            console.error(`Status: ${response.status}`);
            return;
        }
        response.json().then((data) => {
            console.log(data);
        });
    });
};



inputBtn.addEventListener('Click', updateCar);
