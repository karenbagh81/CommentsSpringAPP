# CommentsSpringAPP

В MySQL Workbench создать базу под названием test_spring

Загрузить CommentsSpringAPP в Intelij IDEA и сделать Run/Debug

Открыть приложении Postman

Для добавления комментария в базу сделать Put запрос с url - ом localhost:8080/comment/save в теле запроса json { "comment" : "комент"}

Для получения списка добавленных комментариев нужно сделать Get запрос с url - ом localhost:8080/comment

Для получения списка добавленных уведомлений нужно сделать Get запрос с url - ом localhost:8080/notification

----JUnit тестирование Rest API----

test/java/com/test/controller открыть класс CommentControllerTest

1. Запустите тестовый метод
saveCommentShouldReturnFasterThanOneSecond() - этот тест показывает насколько быстро добавляется комментария....

2. Запустите тестовый метод
saveCommentThousandTimes()- этот тест показывает насколько быстро добавляются 1000 комментариев и
в консоле отображаются статистика
процент удачно добавленных комментариев и процент удачно добавленных уведомлений.
