function solve(a, b) {
    const gcd = function (a, b) {
        return !b ? a : gcd(b, a % b);
    }
    console.log(gcd(a, b));
}
solve(5, 15);
solve(2154, 458);
