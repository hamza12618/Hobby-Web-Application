"use strict";
console.log("page connected");

let carId = document.querySelector("#numberInput");
let carName = document.querySelector("#carName");
let carRegistration = document.querySelector("#carRegistration");

let inputBtn = document.querySelector("#inputBtn");

console.log(inputBtn);

let readByID = () => {
    fetch(`http://localhost:9000/car/getBycarId`).then((response) => {
        if (response.status !== 200) {
            console.error(`status: ${response.status}`);


            return;
        }
        response.json().then((data) => {
            for (let obj of data) {
                console.log(obj);
                createCar(obj);
            }
        }).catch((error) => {
            console.error(`${error}`);
        })
    })
}


console.log("fetched");



let readAll = () => {
    fetch("http://localhost:9000/car/getAll").then((response) => {
        if (response.status !== 200) {
            console.error(`status: ${response.status}`);
            return;

        }
    })
}
readAll();