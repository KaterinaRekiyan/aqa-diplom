# Тестирование покупки тура через комплексный веб-сервис, взаимодействующего с СУБД и API Банка.

## Документация
* [Дипломное задание](https://github.com/netology-code/qa-diploma)
* [План автоматизации тестирования](https://github.com/KaterinaRekiyan/aqa-diplom/blob/main/Documentation/Plan.md)
* [Отчётные документы по итогам тестирования](https://github.com/KaterinaRekiyan/aqa-diplom/blob/main/Documentation/Report.md) 
* [Отчётные документы по итогам автоматизации](https://github.com/KaterinaRekiyan/aqa-diplom/blob/main/Documentation/Summary.md)

## Процедура запуска автотестов
1. Нужно заранее установить и запустить [Docker Desktop](https://github.com/netology-code/aqa-homeworks/blob/master/docker/installation.md) на локальном компьютере.
2. Заранее установить и запустить [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows) на локальном компьютере.
3. Склонировать репозиторий командой в консоли: git clone https://github.com/KaterinaRekiyan/aqa-diplom.
4. Для запуска контейнеров выполнить команду в консоли: `docker-compose up`
5. Запустить приложение командой в консоли

для MySQL: `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar artifacts/aqa-shop.jar`

для PostgreSQL: `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar artifacts/aqa-shop.jar`

6. Запустить тесты командой в консоли

для MySQL: `./gradlew test "-Ddb.url=jdbc:mysql://localhost:3306/app" "-Ddb.username=app" "-Ddb.password=pass"`

для PostgreSQL: `./gradlew test "-Ddb.url=jdbc:postgresql://localhost:5432/app" "-Ddb.username=app" "-Ddb.password=pass"`

7. Создание Allure отчёта командой в консоли `./gradlew allureServe`

*Для остановки работы приложения команда: `Ctrl+C`
для остановки работы контейнеров команды в консоли: `docker-compose stop`, затем `docker-compose down`*
