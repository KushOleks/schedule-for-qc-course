import {search} from './search';

const items = [
    {
        name: '1 к. 19 аудиторія',
        type: {
            description: 'Практична',
        },
        grouped: true,
    },
    {
        name: '1 к. 21 ауд.',
        type: {
            description: 'Лекційна',
        },
        grouped: false,
    },
];

const arr = ['name', 'type.description', 'групова'];

describe('behavior of search function', () => {
    test('shows all items if search term is empty', () => {
        expect(search(items, '', arr).length).toBe(items.length);
    });

    test('shows all items if search term contains only spaces', () => {
        expect(search(items, '   ', arr).length).toBe(items.length);
    });

    test('shows items which include search term', () => {
        expect(search(items, 'аудиторія', arr)).toEqual(
            expect.arrayContaining([
                expect.objectContaining({name: expect.stringContaining('аудиторія')}),
            ]),
        );
    });

    test('shows items which include search term in deep object', () => {
        expect(search(items, 'Лекційна', arr)).toEqual(
            expect.arrayContaining([
                expect.objectContaining({
                    type: expect.objectContaining({
                        description: expect.stringContaining('Лекційна'),
                    }),
                }),
            ]),
        );
    });

    test('shows grouped item when search term equals grouped keyword', () => {
        expect(search(items, 'групова', arr)).toEqual(
            expect.arrayContaining([expect.objectContaining({grouped: true})]),
        );
    });

    test('shows grouped item when search term equals grouped keyword in upper case', () => {
        expect(search(items, 'ГРУПОВА', arr)).toEqual(
            expect.arrayContaining([expect.objectContaining({grouped: true})]),
        );
    });

    test('finds values case-insensitively', () => {
        expect(search(items, 'лекційна', arr)).toEqual(
            expect.arrayContaining([
                expect.objectContaining({
                    type: expect.objectContaining({
                        description: 'Лекційна',
                    }),
                }),
            ]),
        );
    });

    test('finds values when search term has extra spaces around it', () => {
        expect(search(items, '  Лекційна  ', arr)).toEqual(
            expect.arrayContaining([
                expect.objectContaining({
                    type: expect.objectContaining({
                        description: 'Лекційна',
                    }),
                }),
            ]),
        );
    });

    test('returns empty array when term is not found', () => {
        expect(search(items, 'exclude9012', arr)).toEqual([]);
    });

    test('does not fail when deep object property does not exist', () => {
        const customItems = [
            {
                name: 'test item',
                grouped: false,
            },
        ];

        expect(search(customItems, 'Практична', ['name', 'type.description'])).toEqual([]);
    });

    test('finds match in simple property when deep property is missing', () => {
        const customItems = [
            {
                name: 'special room',
                grouped: false,
            },
        ];

        expect(search(customItems, 'special', ['name', 'type.description'])).toEqual(
            expect.arrayContaining([
                expect.objectContaining({name: 'special room'}),
            ]),
        );
    });
});