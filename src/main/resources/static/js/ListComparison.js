'use strict';


const listCreationButton = document.querySelector('.listcreationsubmit');

if (listCreationButton) console.log('button exists');

const constructAjaxListCreation = function () {
        var data = {
            type: 'integer',
            length:34
        }


       var radioInputs = document.getElementsByName('listElementType');
       for(var i = 0; i < radioInputs.length; i++) {
           if (radioInputs[i].checked) {
                if (radioInputs[i].value) {
                    data.type=radioInputs[i].value;
                }
           }
       }

       const listLength = document.querySelector('#ListLength');

       if (listLength.value!='') {
            data.length=parseInt(listLength.value);
       }


       fetch(`ListComparison/createList`,{
            method:"POST",
            body: JSON.stringify(data),
            headers: {"Content-type": "application/json; charset=UTF-8"}
       })
       .then(response => {if (!response.ok) {
                            throw new Error(`Something went wrong. Status:${response.status}`);
                         }
                         return response.json();
        })
        .then(data => console.log(data))
        .catch(error => console.log(error.message));


}



listCreationButton.addEventListener('click',function (event) {
    event.preventDefault();

    console.log(constructAjaxListCreation());


});