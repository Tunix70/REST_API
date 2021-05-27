<h2>Задание</h2>

[![Build Status](https://travis-ci.com/Tunix70/REST_API.svg?branch=master)](https://travis-ci.com/Tunix70/REST_API)

Необходимо реализовать REST API, которое взаимодействует с файловым
хранилищем и предоставляет возможность получать доступ к файлам и
истории загрузок.

Сущности:<br>
User<br>
Account<br>
AccountStatus<br> 
Event<br>
File<br>
FileStatus (enum ACTIVE, BANNED, DELETED)<br>
User -> List<File> files + List<Events> + Account account<br>

Требования:
- Все CRUD операции для каждой из сущностей
- Придерживаться подхода MVC
- Для сборки проекта использовать Maven
- Для взаимодействия с БД - Hibernate
- Для конфигурирования Hibernate - аннотации
- Инициализация БД должна быть реализована с помощью flyway
- Взаимодействие с пользователем необходимо реализовать с помощью
Postman (https://www.getpostman.com/)
- Репозиторий должен иметь бейдж сборки travis(https://travis-ci.com/)
- Рабочее приложение должно быть развернуто на heroku.com

Технологии: Java, MySQL, Hibernate, HTTP, Servlets, Maven, Flyway.
