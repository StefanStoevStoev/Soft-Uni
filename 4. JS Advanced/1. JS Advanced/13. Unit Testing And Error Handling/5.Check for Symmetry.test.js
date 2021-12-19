const isSymmetric = require('../5.Check for Symmetry');
const { assert, expect, should } = require('chai');

describe('Test isSymmetric funcionality', () => {
    it('Should pass when symetryc array is provided', () => {
        let input = [1, 2, 3, 2, 1];
        let expectedResult = true;

        let actualResult = isSymmetric(input);
        assert.equal(actualResult, expectedResult);
    });
    it('Should fail when non symetryc array is provided', () => {
        let input = [1, 2, 3, 3, 1];
        let expectedResult = false;

        let actualResult = isSymmetric(input);
        assert.equal(actualResult, expectedResult);
    });
    it('Should fail when non array is provided as an argument', () => {

        assert.equal(isSymmetric(null), false);
        assert.equal(isSymmetric({}), false);
        assert.equal(isSymmetric(''), false);
        assert.equal(isSymmetric(0), false);
        assert.equal(isSymmetric(true), false);
        assert.equal(isSymmetric(undefined), false);
    });
    it('Should fail', () => {
        let actualResult = isSymmetric(['1', 1]);

        expect(actualResult).to.be.false;
    });
});