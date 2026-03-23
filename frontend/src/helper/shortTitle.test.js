import {getShortTitle} from './shortTitle';

describe('getShortTitle function', () => {
    it('should return short title with 2 symbols', () => {
        const title = '23(203)';
        expect(getShortTitle(title, 2)).toEqual('23...');
    });

    it('should return short title with 6 symbols', () => {
        const title = '27(207)';
        expect(getShortTitle(title, 6)).toEqual('27(207...');
    });

    it('should return empty string for empty title', () => {
        expect(getShortTitle('', 5)).toEqual('');
    });

    it('should return empty string when max length is 0', () => {
        expect(getShortTitle('Hello', 0)).toEqual('...');
    });

    it('should return full title when title length equals max length', () => {
        expect(getShortTitle('Hello', 5)).toEqual('Hello');
    });

    it('should return full title when title is shorter than max length', () => {
        expect(getShortTitle('Hi', 5)).toEqual('Hi');
    });

    it('should return only dots when title is not empty and max length is 0', () => {
        expect(getShortTitle('Test', 0)).toEqual('...');
    });
});