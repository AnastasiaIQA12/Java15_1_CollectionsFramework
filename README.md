# Домашнее задание к занятию «Collections Framework. CRUD и тестирование систем, управляющих набором объектов»
## Задача №1 - Issues
### Легенда
Вы работаете в супер-амбициозной команде, которая разрабатывает [Test Management System (TMS)](https://en.wikipedia.org/wiki/Test_management_tool). И поскольку многим знаком сервис GitHub 😎, была поставлена задача сделать систему управления Issue максимально похожей на ту, что есть в GitHub. В качестве примера мы возьмём [список Issue JUnit5](https://github.com/junit-team/junit5/issues):

![issues](https://user-images.githubusercontent.com/72652840/135619458-cf421d9f-e5cd-4059-9d56-66f2dbad5c92.png)

Какие функции должны быть реализованы:
1. Добавление Issue (набор полей и типы данных для дата-класса `Issue` определяете сами)
1. Отображение списка открытых и закрытых Issue (два отдельных метода, каждый из которых возвращает список из Issue)
1. Фильтрация* (3 отдельных метода):
    1. По имени автора (кто создал); т.е. метод фильтрации, принимающий, например, автора, и возвращающий список подходящих Issue.
    1. По Label'у (нужно проанализировать механику и подобрать нужный метод самостоятельно).
    1. По Assignee (на кого назначено).
1. Сортировка (самостоятельно проанализировать, какие сортировки нужно реализовать). 
1. Закрытие/открытие Issue по id (фактически, это и есть update).

**Важно**: пункты, не указанные в списке, делать не нужно.

Примечание*: фильтрация - это операция возврата только тех объектов, которые удовлетворяют заданному условию (завёрнутых в коллекцию). В рамках стандартной библиотеки Java для этого существует специальный интерфейс `Predicate`. 

Внутри репозитория (конечно же нужно всё разделить на manager и repository) все issue должны храниться в виде `List` (реализацию - `ArrayList` или `LinkedList` - выберите сами). Также вам надо написать дата-класс `Issue`.

На основании раздела CRUD спроектируйте наборы тестов и протестируйте разные состояния системы.

**Итого**: должен быть репозиторий на GitHub, в котором расположен ваш Java-код и автотесты к нему, GitHub Actions и т.д..
