# План автоматизации тестирования веб-сервиса по покупке тура

## Перечень автоматизируемых сценариев:

### Проверка записи в БД:
 - записывает при валидных данных;
 - не записывает в БД при невалидных данных.

### Проверка поддержки СУБД:
 - MySQL;
 - PostgreSQL.

### Тестирование формы оплаты:
#### Позитивные сценарии:
- с карты, которая будет одобрена (4444 4444 4444 4441);
- с картой, которая будет отклонена (4444 4444 4444 4442);
- граничные значения срока действия карты "Год" (в текущем месяце карта должна быть действительна).

#### Негативные сценарии:
- случайно сгенерированный номер карты;
- дата с истёкшим сроком действия карты;
- оставить поле пустым и нажать на кнопку "Продолжить" (проверить все поля по очереди);
- отправка пустой формы;
- некорректный месяц, например: "13";
- месяц со значением "00";
- ввод в поле "Владелец" имени на кирилице;
- ввод в поле "Владелец" цифр;
- ввод в поле "Владелец" спецсимволов;

### Тестирование формы оплаты в кредит:
#### Позитивные сценарии:
- с карты, которая будет одобрена (4444 4444 4444 4441);
- с картой, которая будет отклонена (4444 4444 4444 4442);
- граничные значения срока действия карты "Год" (в текущем месяце карта должна быть действительна).

#### Негативные сценарии:
- случайно сгенерированный номер карты;
- дата с истёкшим сроком действия карты;
- оставить поле пустым и нажать на кнопку "Продолжить" (проверить все поля по очереди);
- отправка пустой формы;
- некорректный месяц, например: "13";
- месяц со значением "00";
- ввод в поле "Владелец" имени на кирилице;
- ввод в поле "Владелец" цифр;
- ввод в поле "Владелец" спецсимволов;


## перечень используемых инструментов с обоснованием выбора:
- язык программирования Java, имеет ряд преимуществ: 
  - объектно-ориентированный язык;
  - язык Java не зависит от платформы;
  - безопасность;
  - надёжность;
  - большая экосистема, включающая множество библиотек и инструментов;
- IntelliJ IDEA Community Edition - функциональная среда разработки для автотестов на Java;
- Gradle - производительная система автоматической сборки;
- JUnit 5 - фреймворк, предназначенный для автоматического тестирования программ;
- Selenide - фреймворк, который облегчает написание автотестов (лаконичный синтаксис, умные ожидания, простая конфигурация);
- Faker - инструмент генерации тестовых данных;
- Lombok - библиотека java, которая делает код лаконичнее;
- MySQL - библиотека для работы с БД;
- Postgres - библиотека для работы с БД;
- Docker - ПО с поддержкой контейниризации для развёртывания БД в MySQL и PostgreSQL;
- Git - система контроля версий позволяющая команде разработчиков и тестировщиков писать, исправлять, дополнять и хранить автотесты;
- GitHub - платформа для совместной разработки;
- Appveyor - система непрерывной интеграции, которая служит для автоматизированной проверки кода, при его загрузке в общий репозиторий.

## перечень и описание возможных рисков при автоматизации:
- риск некорректной настройки запуска симулятора;
- риск некорректной настройки БД;
- трудности при поиске локаторов элементов на страницах;
- увеличение накладных расходов на автоматизацию (возможно данную функциональность дешевле протестировать руками);
- автоматизированные тесты могут занимать много времени на выполнение.

## интервальная оценка с учётом рисков в часах:
- настройка и запуск БД и симулятора - 12 часов;
- написание автотестов - 60 часов;
- подготовка отчетов о проведении тестирования - 18 часов.

## план сдачи работ: когда будут готовы автотесты, результаты их прогона:
- предоставить план автоматизации дипломному руководителю до 09.04.2023г;
- разработать автотесты до 24.04.2023г;
- написать отчёт по автоматизации до 01.05.2023г.