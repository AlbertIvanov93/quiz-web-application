INSERT INTO topic (id, name)
VALUES (1, 'Токарные станки');
INSERT INTO topic (id, name)
VALUES (2, 'Фрезерные станки');
INSERT INTO topic (id, name)
VALUES (3, 'Горизонтально-расточные станки');

INSERT INTO question (title, topic_id, answer, number)
VALUES ('Что можно назвать токарным станком?',
        1,
        'Все вышеперечисленное',
        1);
INSERT INTO question_options (question_title, option)
VALUES ('Что можно назвать токарным станком?',
        'Станок для обработки наружных, внутренних и торцовых поверхностей деталей типа тел вращения, а также для нарезания резьбы');
INSERT INTO question_options (question_title, option)
VALUES ('Что можно назвать токарным станком?',
        'Станок для обработки резанием (точением) заготовок (изделий) из металлов и других материалов в виде тел вращения');
INSERT INTO question_options (question_title, option)
VALUES ('Что можно назвать токарным станком?',
        'Станок, у которого главное движение осуществляется вращением заготовки, движение подачи — режущим инструментом');
INSERT INTO question_options (question_title, option)
VALUES ('Что можно назвать токарным станком?',
        'Все вышеперечисленное');

INSERT INTO question (title, topic_id, answer, number)
VALUES ('Назовите основные параметры токарных станков',
        1,
        'Все вышеперечисленное',
        2);
INSERT INTO question_options (question_title, option)
VALUES ('Назовите основные параметры токарных станков',
        'Наибольший диаметр обрабатываемой заготовки');
INSERT INTO question_options (question_title, option)
VALUES ('Назовите основные параметры токарных станков',
        'Наибольшее расстояние между центрами');
INSERT INTO question_options (question_title, option)
VALUES ('Назовите основные параметры токарных станков',
        'Наибольший диаметр обрабатываемой заготовки, устанавливаемой над суппортом');
INSERT INTO question_options (question_title, option)
VALUES ('Назовите основные параметры токарных станков',
        'Все вышеперечисленное');

INSERT INTO question (title, topic_id, answer, number)
VALUES ('Назовите, что есть в токарном станке',
        1,
        'Две бабки',
        3);
INSERT INTO question_options (question_title, option)
VALUES ('Назовите, что есть в токарном станке',
        'Одна бабка');
INSERT INTO question_options (question_title, option)
VALUES ('Назовите, что есть в токарном станке',
        'Одна бабка и один дедка');
INSERT INTO question_options (question_title, option)
VALUES ('Назовите, что есть в токарном станке',
        'Две бабки');
INSERT INTO question_options (question_title, option)
VALUES ('Назовите, что есть в токарном станке',
        'Два дедки');

INSERT INTO question (title, topic_id, answer, number)
VALUES ('Что применятся в токарном станке во избежание прогиба заготовки?',
        1,
        'Люнет',
        4);
INSERT INTO question_options (question_title, option)
VALUES ('Что применятся в токарном станке во избежание прогиба заготовки?',
        'Упор');
INSERT INTO question_options (question_title, option)
VALUES ('Что применятся в токарном станке во избежание прогиба заготовки?',
        'Подпор');
INSERT INTO question_options (question_title, option)
VALUES ('Что применятся в токарном станке во избежание прогиба заготовки?',
        'Люнет');
INSERT INTO question_options (question_title, option)
VALUES ('Что применятся в токарном станке во избежание прогиба заготовки?',
        'Ничего не применяется');

INSERT INTO question (title, topic_id, answer, number)
VALUES ('Какую опцию применяют на токарных станках, если требуется ускорить обработку и необходима переустановка детали?',
        1,
        'Контршпиндель',
        5);
INSERT INTO question_options (question_title, option)
VALUES ('Какую опцию применяют на токарных станках, если требуется ускорить обработку и необходима переустановка детали?',
        'Контрсуппорт');
INSERT INTO question_options (question_title, option)
VALUES ('Какую опцию применяют на токарных станках, если требуется ускорить обработку и необходима переустановка детали?',
        'Контршпиндель');
INSERT INTO question_options (question_title, option)
VALUES ('Какую опцию применяют на токарных станках, если требуется ускорить обработку и необходима переустановка детали?',
        'Контрлюнет');
INSERT INTO question_options (question_title, option)
VALUES ('Какую опцию применяют на токарных станках, если требуется ускорить обработку и необходима переустановка детали?',
        'Контрпатрон');

INSERT INTO question (title, topic_id, answer, number)
VALUES ('Какой необходимо предложить станок заказчику, если он планирует выпускать шпильки диаметром 10 мм в количестве 10 штук в месяц?',
        1,
        'Универсальный токарный станок с ручным управлением',
        6);
INSERT INTO question_options (question_title, option)
VALUES ('Какой необходимо предложить станок заказчику, если он планирует выпускать шпильки диаметром 10 мм в количестве 10 штук в месяц?',
        'Четырехосевой токарный станок с ЧПУ');
INSERT INTO question_options (question_title, option)
VALUES ('Какой необходимо предложить станок заказчику, если он планирует выпускать шпильки диаметром 10 мм в количестве 10 штук в месяц?',
        'Универсальный токарный станок с ручным управлением');
INSERT INTO question_options (question_title, option)
VALUES ('Какой необходимо предложить станок заказчику, если он планирует выпускать шпильки диаметром 10 мм в количестве 10 штук в месяц?',
        'Трехосевой токарный станок с ЧПУ');
INSERT INTO question_options (question_title, option)
VALUES ('Какой необходимо предложить станок заказчику, если он планирует выпускать шпильки диаметром 10 мм в количестве 10 штук в месяц?',
        'Пятиосевой токарный станок с ЧПУ');

INSERT INTO question (title, topic_id, answer, number)
VALUES ('Какую операцию невозможно сделать на универсальном токарном станке?',
        1,
        'Нарезать зубчатое колесо',
        7);
INSERT INTO question_options (question_title, option)
VALUES ('Какую операцию невозможно сделать на универсальном токарном станке?',
        'Нарезать внутреннюю резьбу');
INSERT INTO question_options (question_title, option)
VALUES ('Какую операцию невозможно сделать на универсальном токарном станке?',
        'Просверлить отверстие');
INSERT INTO question_options (question_title, option)
VALUES ('Какую операцию невозможно сделать на универсальном токарном станке?',
        'Проточить поверхность');
INSERT INTO question_options (question_title, option)
VALUES ('Какую операцию невозможно сделать на универсальном токарном станке?',
        'Нарезать зубчатое колесо');

INSERT INTO question (title, topic_id, answer, number)
VALUES ('Назовите главное движение в токарном станке',
        1,
        'Вращение заготовки',
        8);
INSERT INTO question_options (question_title, option)
VALUES ('Назовите главное движение в токарном станке',
        'Вращение инструмента');
INSERT INTO question_options (question_title, option)
VALUES ('Назовите главное движение в токарном станке',
        'Перемещение суппорта');
INSERT INTO question_options (question_title, option)
VALUES ('Назовите главное движение в токарном станке',
        'Вращение заготовки');
INSERT INTO question_options (question_title, option)
VALUES ('Назовите главное движение в токарном станке',
        'Перемещение задней бабки');

INSERT INTO question (title, topic_id, answer, number)
VALUES ('Что необходимо трехосевому токарному центру с ЧПУ, чтобы выполнить фрезерную операцию?',
        1,
        'Приводной инструмент',
        9);
INSERT INTO question_options (question_title, option)
VALUES ('Что необходимо трехосевому токарному центру с ЧПУ, чтобы выполнить фрезерную операцию?',
        'Приводной инструмент');
INSERT INTO question_options (question_title, option)
VALUES ('Что необходимо трехосевому токарному центру с ЧПУ, чтобы выполнить фрезерную операцию?',
        'Люнет');
INSERT INTO question_options (question_title, option)
VALUES ('Что необходимо трехосевому токарному центру с ЧПУ, чтобы выполнить фрезерную операцию?',
        'Контршпиндель');
INSERT INTO question_options (question_title, option)
VALUES ('Что необходимо трехосевому токарному центру с ЧПУ, чтобы выполнить фрезерную операцию?',
        'Четырехкулачковый патрон');

INSERT INTO question (title, topic_id, answer, number)
VALUES ('Назовите компанию из Китая, с которой мы сотрудничаем по токарным станкам',
        1,
        'DMTC',
        10);
INSERT INTO question_options (question_title, option)
VALUES ('Назовите компанию из Китая, с которой мы сотрудничаем по токарным станкам',
        'DMTC');
INSERT INTO question_options (question_title, option)
VALUES ('Назовите компанию из Китая, с которой мы сотрудничаем по токарным станкам',
        'ACCUT');
INSERT INTO question_options (question_title, option)
VALUES ('Назовите компанию из Китая, с которой мы сотрудничаем по токарным станкам',
        'GUBEN');
INSERT INTO question_options (question_title, option)
VALUES ('Назовите компанию из Китая, с которой мы сотрудничаем по токарным станкам',
        'SIECC');