function timeToWalk(steps, lengthOfStep, speed){
    let distance = steps * lengthOfStep;
    
    let additionalMinits = Math.floor(distance / 500);
    let kmH = speed * 1000;

    let hoursReminder = (distance / kmH);

    let hours = (Math.floor(distance / kmH)).toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});
    let minits = Math.floor(hoursReminder * 60 + additionalMinits).toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});
    let minitsFull = Math.floor(hoursReminder * 60);
    let seconds = Math.round((hoursReminder * 60 - minitsFull) * 60).toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});

    console.log(`${hours}:${minits}:${seconds}`)
}
timeToWalk(4000, 0.60, 5);

