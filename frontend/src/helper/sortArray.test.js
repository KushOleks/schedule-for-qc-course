import {sortByName} from './sortArray';

describe('sortByName function', () => {

    it('should return sorted array', () => {
        const array = [
            { name: '1 к. 11 ауд.' },
            { name: '1 к. 18 ауд.' },
            { name: '1 к. 15 ауд.' }
        ];

        const expectedArray = [
            { name: '1 к. 11 ауд.' },
            { name: '1 к. 15 ауд.' },
            { name: '1 к. 18 ауд.' }
        ];

        expect(sortByName(array)).toEqual(expectedArray);
    });

    it('should handle empty array', () => {
        expect(sortByName([])).toEqual([]);
    });

    it('should handle array with one element', () => {
        const array = [{ name: 'only one' }];
        expect(sortByName(array)).toEqual(array);
    });

    it('should handle elements with same names', () => {
        const array = [
            { name: 'same' },
            { name: 'same' }
        ];
        expect(sortByName(array)).toEqual(array);
    });

    it('should sort alphabetically', () => {
        const array = [
            { name: 'b' },
            { name: 'a' },
            { name: 'c' }
        ];

        const expected = [
            { name: 'a' },
            { name: 'b' },
            { name: 'c' }
        ];

        expect(sortByName(array)).toEqual(expected);
    });

});