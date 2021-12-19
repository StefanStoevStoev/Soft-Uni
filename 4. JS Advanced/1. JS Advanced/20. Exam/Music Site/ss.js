describe('library', () => {

    describe('calcPriceOfBook', () => {
        it('price', () => {
            expect(library.calcPriceOfBook('proba', 1990)).to.equal(`Price of proba is 20.00`);
        });

        it('price', () => {
            expect(library.calcPriceOfBook('proba', 1950)).to.equal(`Price of proba is 10.00`);
        });

        it('1980', () => {
            expect(library.calcPriceOfBook('proba', 1980)).to.equal(`Price of proba is 10.00`);
        });

        it('year', () => {
            expect(() => library.calcPriceOfBook('proba', 'a')).to.throw(`Invalid input`);
        });

        it('not string', () => {
            expect(() => library.calcPriceOfBook(1, 2000)).to.throw(`Invalid input`);
        });

        it('undefined', () => {
            expect(() => library.calcPriceOfBook(undefined, 2000)).to.throw(`Invalid input`);
        });

        it('undefined', () => {
            expect(() => library.calcPriceOfBook('proba', undefined)).to.throw(`Invalid input`);
        });

        it('undefined', () => {
            expect(() => library.calcPriceOfBook(undefined, undefined)).to.throw(`Invalid input`);
        });

    });


    describe('findBook', () => {

        it('array', () => {
            expect(() => library.findBook([], 'proba')).to.throw("No books currently available");
        });

        it('correct', () => {
            expect(library.findBook(['proba', 'proba1', 'proba2'], 'proba1')).to.equal("We found the book you want.");
        });

        it('no book', () => {
            expect(library.findBook(['proba', 'proba1', 'proba2'], 'proba6')).to.equal("The book you are looking for is not here!");
        });

    });

    describe('arrangeTheBooks', () => {
        it('string', () => {
            expect(() => library.arrangeTheBooks('a')).to.throw("Invalid input");
        });

        it('undefined', () => {
            expect(() => library.arrangeTheBooks(undefined)).to.throw("Invalid input");
        });

        it('-', () => {
            expect(() => library.arrangeTheBooks(-3)).to.throw("Invalid input");
        });

        it('floating pint', () => {
            expect(() => library.arrangeTheBooks(2.5)).to.throw("Invalid input");
        });

        it('succsess', () => {
            expect(library.arrangeTheBooks(30)).to.equal("Great job, the books are arranged.");
        });

        it('40 books', () => {
            expect(library.arrangeTheBooks(40)).to.equal("Great job, the books are arranged.");
        });

        it('unsuccsefull', () => {
            expect(library.arrangeTheBooks(51)).to.equal("Insufficient space, more shelves need to be purchased.");
        });

    });

});