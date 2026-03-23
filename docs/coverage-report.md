# Coverage Report

## Загальне покриття

### Jest / Code Coverage
- Statements/Instructions: 30.06%
- Branches: 9.16%
- Functions/Methods: 8.47%
- Lines: 32.02%

### Mutation Testing (Stryker)
- Mutation score (of total): 26.79%
- Mutation score (of covered): 92.80%
- Killed mutants: 231
- Survived mutants: 18
- Timeout: 1
- No coverage: 616

## Аналіз

У межах лабораторної роботи було розширено тестове покриття для helper-функцій frontend-частини проєкту.  
Було дописано нові unit-тести для таких файлів:

- `prepareLessonCell.js`
- `prepareTeacherCell.js`
- `shortTitle.js`
- `sortArray.js`
- `search.js`
- `strings.js`

Найкраще покриття отримали:
- `prepareLessonCell.js` — 100%
- `prepareTeacherCell.js` — 100%
- `shortTitle.js` — 100%
- `sortArray.js` — 100%

Mutation testing показав, що значна частина мутантів для протестованих helper-функцій успішно знищується.  
Це означає, що тести перевіряють не лише факт виконання коду, а й коректність логіки.

Найбільше непокритих ділянок залишилось у великих компонентах і модулях, які не були основним фокусом цього варіанту.  
Також частина мутантів залишилась у файлах `disableComponent.js`, `schedule.js`, `renderTeacher.js`, `search.js`, `strings.js`, але загальний результат mutation testing було покращено.

## Що було зроблено в mutation testing

Було налаштовано Stryker для файлів helper-модуля.  
Після первинного запуску були виявлені survived mutants.  
Після дописування нових тестів кількість killed mutants зросла, а mutation score покращився.

## Скріни
<img width="772" height="304" alt="image" src="https://github.com/user-attachments/assets/c29cedf2-46cd-4cc6-9c50-09d9e52c70f2" />
<img width="880" height="848" alt="image" src="https://github.com/user-attachments/assets/57a892ed-5173-4883-a1b5-4fec23d96165" />
<img width="2048" height="1279" alt="image" src="https://github.com/user-attachments/assets/3d0bb74a-15b4-4e40-b042-6f3920d82fc1" />
<img width="880" height="639" alt="image" src="https://github.com/user-attachments/assets/efb375f6-8e5d-4c47-82c7-be214ad965c2" />


