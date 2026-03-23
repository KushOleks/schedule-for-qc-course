import {prepareLessonCardCell, prepareLessonSubCardCell} from './prepareLessonCell';
import {places} from '../constants/places';

describe('prepareLessonCardCell function', () => {
    it('should return empty string if card is null or undefined', () => {
        let card = null;
        expect(prepareLessonCardCell(card)).toEqual('');
        card = undefined;
        expect(prepareLessonCardCell(card)).toEqual('');
    });

    it('should return string with subject data', () => {
        const teacher = {
            name: 'Роман',
            surname: 'Романюк',
            patronymic: 'Романович',
            position: 'доцент',
        };
        const card = {
            subjectForSite: 'test subject',
            teacher,
        };

        expect(prepareLessonCardCell(card)).toEqual(
            `доц. ${teacher.surname} ${teacher.name} ${teacher.patronymic}\n${card.subjectForSite}\n`,
        );
    });
});

describe('prepareLessonSubCardCell function', () => {
    const cardData = {
        room: {id: 51, name: '1 к. 11 ауд.'},
        lessonType: 'testType',
    };

    describe('should return empty string', () => {
        it('if card is null or undefined', () => {
            let card = null;
            expect(prepareLessonSubCardCell(card, places.AUDITORY)).toEqual('');
            card = undefined;
            expect(prepareLessonSubCardCell(card, places.AUDITORY)).toEqual('');
        });

        it('if card is null or undefined but place equal ONLINE', () => {
            let card = null;
            expect(prepareLessonSubCardCell(card, places.ONLINE)).toEqual('');
            card = undefined;
            expect(prepareLessonSubCardCell(card, places.ONLINE)).toEqual('');
        });
    });

    describe('should return string with data', () => {
        it('if card is not null and place not equal ONLINE', () => {
            expect(prepareLessonSubCardCell(cardData, places.AUDITORY)).toEqual(
                `(lesson_type_${cardData.lessonType.toLowerCase()}_label, ${cardData.room.name})`,
            );
        });

        it('if card is not null and place equal ONLINE', () => {
            expect(prepareLessonSubCardCell(cardData, places.ONLINE)).toEqual(
                `lesson_type_${cardData.lessonType.toLowerCase()}_label`,
            );
        });
    });
});

describe('prepareLessonCardCell edge cases', () => {
    it('should throw error if teacher is missing', () => {
        const card = {
            subjectForSite: 'test subject',
        };

        expect(() => prepareLessonCardCell(card)).toThrow();
    });

    it('should return string with undefined subject if subjectForSite is missing', () => {
        const teacher = {
            name: 'Роман',
            surname: 'Романюк',
            patronymic: 'Романович',
            position: 'доцент',
        };

        const card = {
            teacher,
        };

        expect(prepareLessonCardCell(card)).toEqual(
            `доц. ${teacher.surname} ${teacher.name} ${teacher.patronymic}\nundefined\n`,
        );
    });
});

describe('prepareLessonSubCardCell edge cases', () => {
    it('should handle lessonType in upper case', () => {
        const card = {
            room: {id: 51, name: '1 к. 11 ауд.'},
            lessonType: 'LECTURE',
        };

        expect(prepareLessonSubCardCell(card, places.AUDITORY)).toEqual(
            `(lesson_type_${card.lessonType.toLowerCase()}_label, ${card.room.name})`,
        );
    });

    it('should treat unknown place as not ONLINE and include room', () => {
        const card = {
            room: {id: 51, name: '1 к. 11 ауд.'},
            lessonType: 'testType',
        };

        expect(prepareLessonSubCardCell(card, 'UNKNOWN_PLACE')).toEqual(
            `(lesson_type_${card.lessonType.toLowerCase()}_label, ${card.room.name})`,
        );
    });

    it('should return string with undefined room name if room exists without name', () => {
        const card = {
            room: {id: 51},
            lessonType: 'testType',
        };

        expect(prepareLessonSubCardCell(card, places.AUDITORY)).toEqual(
            `(lesson_type_${card.lessonType.toLowerCase()}_label, undefined)`,
        );
    });
});