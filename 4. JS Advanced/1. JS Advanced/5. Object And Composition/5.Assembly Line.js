function createAssemblyLine() {
    let myCar = {
        make: 'Toyota',
        model: 'Avensis',
        temp: 21,
        tempSettings: 21,
        adjustTemp: function() {
            if (this.temp < this.tempSettings) {
                this.temp++;
            } else {
                this.temp--;
            }
        },
        currentTrack: { name: null, artist: null },
        nowPlaying: function() {
            console.log(`Now playing '${this.currentTrack.name1}' by ${this.currentTrack.artist}`);
        },
        checkDistance: function(distance) {
            if (distance < 0.1) {
                console.log("Beep! Beep! Beep!");
            } else if (0.1 <= distance < 0.25) {
                console.log("Beep! Beep!");
            } else if (0.25 <= distance < 0.5) {
                console.log("Beep!");
            } else {
                console.log(" ");
            }
        }
    };

}

const assemblyLine = createAssemblyLine();

const myCar = {
    make: 'Toyota',
    model: 'Avensis',
    temp: 21,
    tempSettings: 21,
    adjustTemp: function() {
        if (this.temp < this.tempSettings) {
            this.temp++;
        } else {
            this.temp--;
        }
    },
    currentTrack: { name: null, artist: null },
    nowPlaying: function() {
        console.log(`Now playing '${this.currentTrack.name1}' by ${this.currentTrack.artist}`);
    },
    checkDistance: function(distance) {
        if (distance < 0.1) {
            console.log("Beep! Beep! Beep!");
        } else if (0.1 <= distance < 0.25) {
            console.log("Beep! Beep!");
        } else if (0.25 <= distance < 0.5) {
            console.log("Beep!");
        } else {
            console.log(" ");
        }
    }
};

assemblyLine.hasAudio(myCar);
myCar.currentTrack = {
    name: 'Never Gonna Give You Up',
    artist: 'Rick Astley'
};
myCar.nowPlaying();