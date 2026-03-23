import {firstStringLetterCapital} from './strings';

describe('firstStringLetterCapital function', () => {

    it('should capitalize first letter', () => {
        expect(firstStringLetterCapital('hello')).toEqual('Hello');
    });

    it('should capitalize only first letter in sentence', () => {
        expect(firstStringLetterCapital('hello world')).toEqual('Hello world');
    });

    it('should not change already capitalized string', () => {
        expect(firstStringLetterCapital('Hello')).toEqual('Hello');
    });

    it('should return empty string if input is empty', () => {
        expect(firstStringLetterCapital('')).toEqual('');
    });

    it('should handle string starting with number', () => {
        expect(firstStringLetterCapital('1hello')).toEqual('1hello');
    });

    it('should handle single character', () => {
        expect(firstStringLetterCapital('a')).toEqual('A');
    });

});