function dayOfWeek(a) {
    let day = a;
    let result = 0;

    switch (day) {
        case 'Monday': result = 1; break;
        case 'Tuesday': result = 2; break;
        case 'Wednesday': result = 3; break;
        case 'Thursday': result = 4; break;
        case 'Friday': result = 5; break;
        case 'Saturday': result = 6; break;
        case 'Sunday': result = 7; break;
        default: result = null; break;
    }
    if (result == null) {
        console.log('error');
    } else {
        console.log(result);
    }
}




