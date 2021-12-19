function attachEventsListeners() {

    const ratios = {
        days: 1,
        hours: 24,
        minutes: 1440,
        seconds: 86400
    }

    function convert(value, input) {
        const result = value / ratios[input];

        return {
            days: result,
            hours: result * ratios.hours,
            minutes: result * ratios.minutes,
            seconds: result * ratios.seconds
        }
    }
    const dayInput = document.getElementById('days');
    const hourInput = document.getElementById('hours');
    const minuteInput = document.getElementById('minutes');
    const secondInput = document.getElementById('seconds');

    document.getElementById('daysBtn').addEventListener('click', onConvert);
    document.getElementById('hoursBtn').addEventListener('click', onConvert);
    document.getElementById('minutesBtn').addEventListener('click', onConvert);
    document.getElementById('secondsBtn').addEventListener('click', onConvert);

    function onConvert(a) {
        const input = a.target.parentElement.querySelector('input[type="text"]');
        const time = convert(Number(input.value), input.id);

        dayInput.value = time.days;
        hourInput.value = time.hours;
        minuteInput.value = time.minutes;
        secondInput.value = time.seconds;
    }
}