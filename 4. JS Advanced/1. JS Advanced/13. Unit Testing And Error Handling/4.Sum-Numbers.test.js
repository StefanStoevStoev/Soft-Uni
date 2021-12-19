const assert = require('chai').assert;
const sum = require('../4.Sum-Numbers');

describe('Test sum functionality', () => {
    it('Should add positive numbers', () => {
        let input = [1, 2, 3, 4, 5];
        let expectedResult = 15;

        let actualResult = sum(input);
        // if (expectedResult == actualResult) {
        //     console.log('Passing');
        // } else {
        //     throw new Error('Sum should be 15');
        // }
        assert.strictEqual(actualResult, expectedResult);

    });

    it('Should return false when adding positive numbers', () => {
        let input = [10, 20, 30];
        let expectedResult = 15;

        let actualResult = sum(input);

        assert.notEqual(actualResult, expectedResult);

    });
    it('Should pass when adding negative numbers', () => {
        let input = [-1, -2, -3];
        let expectedResult = -6;

        let actualResult = sum(input);

        assert.equal(actualResult, expectedResult);

    });
});