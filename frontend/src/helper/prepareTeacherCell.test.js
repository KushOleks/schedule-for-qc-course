import {
    buildGroupNumber,
    buildLessonWithRoom,
    prepareTeacherCardCell,
    prepareTeacherCardRegularCell,
    prepareTitleAndInner,
} from './prepareTeacherCell';
import {places} from '../constants/places';

const cardData = {
    room: '1 к. 11 ауд.',
    lessonType: 'testType',
    subjectForSite: 'test',
    group: {title: 'testGroup'},
};

describe('prepareTeacherCardCell function', () => {
    it('should return empty string if card is null or undefined', () => {
        expect(prepareTeacherCardCell(null)).toEqual('');
        expect(prepareTeacherCardCell(undefined)).toEqual('');
    });

    it('should return string with subject data', () => {
        const card = {
            subjectForSite: 'test subject',
        };
        expect(prepareTeacherCardCell(card)).toEqual('test subject');
    });

    it('should return undefined if subjectForSite is missing', () => {
        expect(prepareTeacherCardCell({})).toBeUndefined();
    });
});

describe('buildLessonWithRoom function', () => {
    it('should return string with label if place equals AUDITORY', () => {
        expect(buildLessonWithRoom(cardData, places.AUDITORY)).toEqual(
            `test\n(lesson_type_testtype_label, ${cardData.room})\n`,
        );
    });

    it('should return string without room if place equals ONLINE', () => {
        expect(buildLessonWithRoom(cardData, places.ONLINE)).toEqual(
            `test\nlesson_type_testtype_label\n`,
        );
    });

    it('should handle lessonType in upper case', () => {
        const upperCaseCard = {
            ...cardData,
            lessonType: 'LECTURE',
        };

        expect(buildLessonWithRoom(upperCaseCard, places.AUDITORY)).toEqual(
            `test\n(lesson_type_lecture_label, ${upperCaseCard.room})\n`,
        );
    });

    it('should treat unknown place as not ONLINE', () => {
        expect(buildLessonWithRoom(cardData, 'UNKNOWN_PLACE')).toEqual(
            `test\n(lesson_type_testtype_label, ${cardData.room})\n`,
        );
    });
});

describe('prepareTeacherCardRegularCell function', () => {
    it('should return string with label and group title for AUDITORY', () => {
        expect(prepareTeacherCardRegularCell(cardData, places.AUDITORY)).toEqual(
            `test\n(lesson_type_testtype_label, ${cardData.room})\n\ntestGroup\n`,
        );
    });

    it('should return string with label and group title for ONLINE', () => {
        expect(prepareTeacherCardRegularCell(cardData, places.ONLINE)).toEqual(
            `test\nlesson_type_testtype_label\n\ntestGroup\n`,
        );
    });
});

describe('buildGroupNumber function', () => {
    it('should return group title', () => {
        expect(buildGroupNumber(cardData)).toEqual('testGroup\n');
    });
});

describe('prepareTitleAndInner function', () => {
    it('should build title and inner for card without temporary schedule', () => {
        const options = {
            cards: [cardData],
            place: places.AUDITORY,
            title: '',
            inner: '',
        };

        expect(prepareTitleAndInner(options)).toEqual({
            title: `regular_lesson_label\rtest\n(lesson_type_testtype_label, ${cardData.room})\n\ntestGroup\n\r`,
            inner: `testGroup\n`,
        });
    });

    it('should build inner with vacation label when temporary schedule is vacation', () => {
        const options = {
            cards: [
                {
                    ...cardData,
                    temporary_schedule: {
                        vacation: true,
                        date: '2025-03-01',
                        teacher: {
                            name: 'Іван',
                            surname: 'Петренко',
                            patronymic: 'Іванович',
                        },
                        room: {name: '101'},
                        subjectForSite: 'Math',
                    },
                },
            ],
            place: places.AUDITORY,
            title: '',
            inner: '',
        };

        expect(prepareTitleAndInner(options)).toEqual({
            title: `regular_lesson_label\rtest\n(lesson_type_testtype_label, ${cardData.room})\n\ntestGroup\n\r`,
            inner: `2025-03-01\nvacation_label\n`,
        });
    });

    it('should build inner with teacher and room when temporary schedule is not vacation', () => {
        const options = {
            cards: [
                {
                    ...cardData,
                    temporary_schedule: {
                        vacation: false,
                        date: '2025-03-01',
                        teacher: {
                            name: 'Іван',
                            surname: 'Петренко',
                            patronymic: 'Іванович',
                        },
                        room: {name: '101'},
                        subjectForSite: 'Math',
                    },
                },
            ],
            place: places.AUDITORY,
            title: '',
            inner: '',
        };

        expect(prepareTitleAndInner(options)).toEqual({
            title: `regular_lesson_label\rtest\n(lesson_type_testtype_label, ${cardData.room})\n\ntestGroup\n\r`,
            inner: `2025-03-01\nПетренко Іван Іванович\nMath, 101\n`,
        });
    });

    it('should build inner without room name when temporary schedule room is missing', () => {
        const options = {
            cards: [
                {
                    ...cardData,
                    temporary_schedule: {
                        vacation: false,
                        date: '2025-03-01',
                        teacher: {
                            name: 'Іван',
                            surname: 'Петренко',
                            patronymic: 'Іванович',
                        },
                        room: null,
                        subjectForSite: 'Math',
                    },
                },
            ],
            place: places.AUDITORY,
            title: '',
            inner: '',
        };

        expect(prepareTitleAndInner(options)).toEqual({
            title: `regular_lesson_label\rtest\n(lesson_type_testtype_label, ${cardData.room})\n\ntestGroup\n\r`,
            inner: `2025-03-01\nПетренко Іван Іванович\nMath\n`,
        });
    });
});