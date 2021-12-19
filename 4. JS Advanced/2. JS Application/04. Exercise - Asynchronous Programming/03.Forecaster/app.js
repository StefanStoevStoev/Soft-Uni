async function attachEvents() {

    if (document.querySelector('div.forecast-info') !== null) {
        document.querySelector('div.forecast-info').replaceChildren();
    };

    if (document.querySelector('div.forecasts') !== null) {
        document.querySelector('div.forecasts').replaceChildren();

    };

    document.getElementById('submit').addEventListener('click', loadTownData);

}

async function loadTownData() {
    document.getElementById('forecast').style.display = 'contents';
    if (document.querySelector('div.forecast-info') !== null) {
        document.querySelector('div.forecast-info').replaceChildren();
    };

    if (document.querySelector('div.forecasts') !== null) {
        document.querySelector('div.forecasts').replaceChildren();
    };

    let location1 = document.getElementById('location');

    const urlForecaster = `http://localhost:3030/jsonstore/forecaster/today/${location1.value}`;

    const urlUpcoming = `http://localhost:3030/jsonstore/forecaster/upcoming/${location1.value}`;

    document.getElementById('location').value = '';
    try {

        const res1 = await fetch(urlForecaster);
        const data1 = await res1.json();
        appendForecastData(data1);

        const res2 = await fetch(urlUpcoming);
        const data2 = await res2.json();

        appendThreeDayData(data2.forecast);

    } catch (error) {
        const div = document.querySelector('div.label');
        div.textContent = 'Wrong town name';

    }
}

async function appendForecastData(data) {

    const divS = document.querySelector('div.label');
    divS.textContent = 'Current conditions';


    const div = document.createElement('div');
    div.className = 'forecasts';
    const current = document.getElementById('current');
    current.appendChild(div);

    div.style.display = 'inline';
    div.style.background = 'white';

    const spanCondSymb = document.createElement('span');
    spanCondSymb.classList.add('condition', 'symbol');
    spanCondSymb.innerHTML = data.forecast.condition == undefined ? '' : conditionSymbol(data.forecast.condition);
    div.appendChild(spanCondSymb);

    spanCondSymb.style.background = 'white';

    const spanCond = document.createElement('span');
    spanCond.classList.add('condition');
    div.appendChild(spanCond);

    spanCond.style.background = 'white';

    const spanForecastTown = document.createElement('span');
    spanForecastTown.className = 'forecast-data';
    spanForecastTown.textContent = `${data.name}`;
    spanCond.appendChild(spanForecastTown);

    const spanForecastDeg = document.createElement('span');
    spanForecastDeg.className = 'forecast-data';
    spanForecastDeg.innerHTML = `${data.forecast.low}\xB0/${data.forecast.high}\xB0`;
    spanCond.appendChild(spanForecastDeg);

    const spanForecastCond = document.createElement('span');
    spanForecastCond.className = 'forecast-data';
    spanForecastCond.innerHTML = `${data.forecast.condition}`;
    spanCond.appendChild(spanForecastCond);

}

async function appendThreeDayData(data) {

    const div = document.createElement('div');
    const divUpcoming = document.getElementById('upcoming');
    div.className = 'forecast-info';
    divUpcoming.appendChild(div);

    for (let i = 0; i < data.length; i++) {

        const span = document.createElement('span');
        span.className = 'upcoming';
        div.appendChild(span);

        const spanSymbol = document.createElement('span');
        spanSymbol.className = 'symbol';
        spanSymbol.innerHTML = conditionSymbol(data[i].condition);
        span.appendChild(spanSymbol);


        const spanDeg = document.createElement('span');
        spanDeg.className = 'forecast-data';
        spanDeg.innerHTML = `${data[i].low}&#176/${data[i].high}&#176`;
        span.appendChild(spanDeg);

        const spanCondition = document.createElement('span');
        spanCondition.className = 'forecast-data';
        spanCondition.innerHTML = `${data[i].condition}`;
        span.appendChild(spanCondition);

    }
}

function conditionSymbol(data) {
    if (data == 'Rain') {
        return '&#x2614';
    } else if (data == 'Overcast') {
        return '&#x2601';
    } else if (data == 'Partly sunny') {
        return '&#x26C5';
    } else if (data == 'Sunny') {
        return '&#x2600';
    }
}


attachEvents();