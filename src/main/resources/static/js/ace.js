

function addPro(){
const myButton = document.querySelector('#submitProduct');
const clonedButton = myButton.cloneNode(true);
myButton.parentNode.replaceChild(clonedButton, myButton);
clonedButton.addEventListener('click', (event) => {
  event.preventDefault(); // Prevent any default action (e.g., form submission)
  event.stopPropagation(); // Stop event propagation to prevent other listeners
  // Optionally, you can log a message to indicate that the button is disabled
  console.log('Button is disabled.');
});

            console.log('-----------');
            var name = document.getElementById('productName').value;
            var quantity = document.getElementById('quantity').value;
            var price = document.getElementById('price').value;
            var type = document.getElementById('type').value;
//            var alert_enabled = document.getElementById('alert_enabled').value;
            var alert_enabled = 'Enable';
            let data = {
                "name": name,
                "quantity": quantity,
                "price": price,
                "type": type,
                "alert_enabled": alert_enabled
            };
            base_path = "http://localhost:8080";
                  data = JSON.stringify(data);
                  console.log('-----------');
                  console.log(data);

var url = base_path + '/addProduct';
     //fetch method
        getServerResponse(data, url, 'POST').then((response) => {

        }).catch(e => {
            console.error(e);
        });

         location.reload();
}



function addMer(){
const myButton = document.querySelector('#submitMerchant');
const clonedButton = myButton.cloneNode(true);
myButton.parentNode.replaceChild(clonedButton, myButton);
clonedButton.addEventListener('click', (event) => {
  event.preventDefault(); // Prevent any default action (e.g., form submission)
  event.stopPropagation(); // Stop event propagation to prevent other listeners
  // Optionally, you can log a message to indicate that the button is disabled
  console.log('Button is disabled.');
});

            console.log('-----------');
            var name = document.getElementById('merchantName').value;
            var location = document.getElementById('location').value;
            let data = {
                "name": name,
                "location": location
            };
            base_path = "http://localhost:8080";
            console.log('-----------' + data);
                  data = JSON.stringify(data);
                  console.log('-----------');
                  console.log(data);
var url = base_path + '/addMerchant';
     //fetch method
        getServerResponse(data, url, 'POST').then((response) => {

        }).catch(e => {
            console.error(e);
        });
          location.reload();
}

function addPay(){
const myButton = document.querySelector('#submitPayment');
const clonedButton = myButton.cloneNode(true);
myButton.parentNode.replaceChild(clonedButton, myButton);
clonedButton.addEventListener('click', (event) => {
  event.preventDefault(); // Prevent any default action (e.g., form submission)
  event.stopPropagation(); // Stop event propagation to prevent other listeners
  // Optionally, you can log a message to indicate that the button is disabled
  console.log('Button is disabled.');
});

            console.log('-----------');
            var merchant_name = document.getElementById('merchant_name').value;
            var bill_no = document.getElementById('bill_no').value;
            var total_amount = document.getElementById('total_amount').value;
            var amount_paid = document.getElementById('amount_paid').value;
            var amount_unpaid = document.getElementById('amount_unpaid').value;
            var date = document.getElementById('date').value;


            // Split the string into day, month, and year parts
            var dateParts = date.split('/');

            // Create a new Date object (Note: Month is zero-based in JavaScript, so we subtract 1 from the month)
            var jsDate = new Date(dateParts[2], dateParts[1] - 1, dateParts[0]);





            var payment_method = document.getElementById('payment_method').value;

            let data = {
                "merchant_name": merchant_name,
                "bill_no": bill_no,
                "total_amount": total_amount,
                "amount_paid": amount_paid,
                "amount_unpaid": amount_unpaid,
                "date": jsDate,
                "payment_method": payment_method,
            };
            base_path = "http://localhost:8080";
            console.log('-----------' + data);
                  data = JSON.stringify(data);
                  console.log('-----------');
                  console.log(data);
var url = base_path + '/addPayment';
     //fetch method
        getServerResponse(data, url, 'POST').then((response) => {

        }).catch(e => {
            console.error(e);
        });
          location.reload();
}