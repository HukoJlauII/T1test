# T1test
Тестовое задание для компании T1 Консалтинг

## Руководство пользователя
Для пользования REST API необходимо отправить GET-запрос по URL: http://localhost:8080/api/frequency?string='строка_на_ввод' \
Ограничения по вводимому параметру:длина строки от 1 до 32-х символов. \
Результат запроса: словарь с ключом в виде сивола и значением в виде количества вхождения символа в строку. Результат отсортирован по убыванию значения словаря.
## Пример запроса
### 1. Успешный запрос
[![2023-09-15-150641248.png](https://i.postimg.cc/jjvjRwCT/2023-09-15-150641248.png)](https://postimg.cc/JyD8qhbY)
### 2. Неудачный запрос
[![2023-09-15-151059622.png](https://i.postimg.cc/JhgjR2sM/2023-09-15-151059622.png)](https://postimg.cc/zLCyjpwc)
### 3. Ошибка пользовательского ввода
[![2023-09-15-150938504.png](https://i.postimg.cc/tg9hrxLG/2023-09-15-150938504.png)](https://postimg.cc/qNZhqzJ1)
## Документация API
Для удобства была разработана документация API с использованием Swagger \
Документация доступна по ссылке :link: [Доументация Swagger](http://localhost:8080/swagger-ui/index.html#/) \
Также была разработана документация JavaDoc \
Документация доступна по ссылке :link: [Доументация JavaDoc](http://localhost:63342/T1test/javadoc/com/example/t1test/package-summary.html)
## Тестирование
Для тестирования был использован JUnit4, весь имеющийся код покрыт тестами,тестовые файлы находятся в модуле **test**
### Результат тестирования
[![2023-09-15-152138876.png](https://i.postimg.cc/Jhz7nrfW/2023-09-15-152138876.png)](https://postimg.cc/CR9prgMv)
