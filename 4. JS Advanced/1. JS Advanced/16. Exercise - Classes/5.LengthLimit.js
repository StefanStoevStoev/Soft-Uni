class Stringer {
    constructor(innerString, innerLength) {
        this.innerString = innerString;
        this.innerLength = innerLength;
        this.storeString = innerString;
    }

    increase(length) {

        this.innerLength += length;

        if (this.innerLength < this.storeString.length) {

            let addString = this.storeString.slice(this.innerString, length);
            this.innerString += addString;

        } else {
            this.innerString = this.storeString;
        }
    }

    decrease(length) {

        this.innerLength -= length;

        if (this.innerLength <= 0) {
            this.innerLength = 0;
            this.innerString = '';
        } else {

            this.innerString = this.innerString.slice(0, this.innerLength);

        }
    }

    toString() {
        if (this.innerLength < this.storeString.length) {
            return this.innerString + '...';
        }
        return this.innerString;
    }
}

let test = new Stringer("Test", 5);
console.log(test.toString()); // Test

test.decrease(3);
console.log(test.toString()); // Te...

test.decrease(5);
console.log(test.toString()); // ...

test.increase(3);
console.log(test.toString()); // Test