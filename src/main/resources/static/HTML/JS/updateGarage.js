`use strict`;
let garageId = document.querySelector("#numberInput");
let garageName = document.querySelector("#garageName");
let garageLocation = document.querySelector("#garageLocation");

let inputBtn = document.querySelector("#inputBtn");


let putData = () => {
    let garageNameValue = garageName.value;

    let garageLocationValue = garageLocation.value;




    inputgarageName.value = "";
    inputgarageLocation.value = "";


    let newObject = {

        garageName = garageName.value,
        garageLocationValue = garageLocation.value,


    }

    putFetch(newObject);

    return newObject
};


let putFetch = (object) => {
    fetch("http://localhost:9000/garage/update", {
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



inputBtn.addEventListener('Click', updateGarage);
