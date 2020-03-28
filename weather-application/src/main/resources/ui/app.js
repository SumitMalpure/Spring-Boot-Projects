var forecastMsg = document.querySelector('#forecastMsg');
var button = document.querySelector('.submit');
var cityInput = 'London';

function getOption() {
    var selectElement =
        document.querySelector('.citydropdown');
    console.log(selectElement);

    var inputCity = selectElement.value;
    if (inputCity == 'London') {
        cityInput = 'London,us'
    }
    if (inputCity == 'Bangalore' || inputCity == 'Pune') {
        cityInput == inputCity + ',in'
    }

    console.log(cityInput);

    fetch('http://localhost:8083/weather-forecast/city/' + cityInput)
        .then(response => response.json())
        .then(data => {

            var forecastMessageValue = data['forecastMessage'];
            forecastMsg.innerHTML = forecastMessageValue;
            var forecastarr= data['forecastList'];
            var forecastdiv = document.createElement('div');
            forecastarr.forEach(function(forecastobj){
                var lowTempLabel=document.createTextNode('Low Temperature:');
                var breakElement= document.createElement('br');
                var lowTempValue=document.createTextNode(forecastobj['lowTemp']);
                var highTempLabel=document.createTextNode('High Temperature:');
                var highTempValue=document.createTextNode(forecastobj['highTemp']);
                var forecastDateLabel=document.createTextNode('Forecast Date:');
                var foreCastDateValue=document.createTextNode(forecastobj['forecastDate']);

                forecastdiv.appendChild(forecastDateLabel);
                forecastdiv.appendChild(foreCastDateValue);
                forecastdiv.appendChild(breakElement);
                forecastdiv.appendChild(lowTempLabel);
                forecastdiv.appendChild(lowTempValue);
                forecastdiv.appendChild(breakElement);
                forecastdiv.appendChild(highTempLabel);
                forecastdiv.appendChild(highTempValue);
                forecastdiv.appendChild(breakElement);

              
            } )

            document.getElementById('forecastcontainer').appendChild(forecastdiv);


        })
        .catch(err => alert(err));

}