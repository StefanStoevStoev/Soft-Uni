function roadRadar(speed, zone) {
    switch (zone) {
        case 'motorway': printMessage(speed, 130); break;
        case 'interstate': printMessage(speed, 90); break;
        case 'city': printMessage(speed, 50); break;
        case 'residential': printMessage(speed, 20); break;
    }
    function printMessage(speed, allowedSpeed) {

        let status = 'reckless driving';

        if (speed > allowedSpeed) {
            let difference = speed - allowedSpeed;
            if (difference <= 20) {
                status = 'speeding';
            } else if (difference <= 40) {
                status = 'excessive speeding';
            }
            console.log(`The speed is ${difference} km/h faster than the allowed speed of ${allowedSpeed} - ${status}`)
        } else {
            console.log(`Driving ${speed} km/h in a ${allowedSpeed} zone`);
        }
    }
}


roadRadar(200, 'motorway');