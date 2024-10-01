package com.albert.quizintratool.config;

import com.albert.quizintratool.model.Question;
import com.albert.quizintratool.model.Role;
import com.albert.quizintratool.model.Topic;
import com.albert.quizintratool.model.User;
import com.albert.quizintratool.repository.QuestionRepository;
import com.albert.quizintratool.repository.TopicRepository;
import com.albert.quizintratool.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;


@Configuration
public class DataConfig {

    @Bean
    public CommandLineRunner userLoader(UserRepository userRepository, PasswordEncoder encoder) {
        User hayrulin = new User("artur","Артур", "Хайрулин", encoder.encode("1234"), Role.USER);
        User admin = new User("admin","admin", "admin", encoder.encode("password"), Role.ADMIN);
        User test = new User("test","test", "test", encoder.encode("1234"), Role.USER);
        test.getRoles().add(Role.ADMIN);

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                userRepository.save(hayrulin);
                userRepository.save(admin);
                userRepository.save(test);
            }
        };
    }



    @Bean
    public CommandLineRunner questionLoader(QuestionRepository questionRepo, TopicRepository topicRepo) {
        Topic lathe = new Topic("Токарные станки");
        Topic milling = new Topic("Фрезерные станки");
        Topic horizontalMilling = new Topic("Горизонтально-расточные станки");
        Topic complex = new Topic("Общий тест");

        //ГРСы
        //Заглушка
        Set<String> options0 = new HashSet<>() {{
            add("1");
            add("2");
            add("3");
            add("4");
        }};

        //Токарные станки
        Set<String> options1 = new HashSet<>() {{
            add("Станок для обработки наружных, внутренних и торцовых поверхностей деталей типа тел вращения, а также для нарезания резьбы");
            add("Станок для обработки резанием (точением) заготовок (изделий) из металлов и других материалов в виде тел вращения");
            add("Станок, у которого главное движение осуществляется вращением заготовки, движение подачи — режущим инструментом");
            add("Все вышеперечисленное");
        }};

        Set<String> options2 = new HashSet<>() {{
            add("Наибольший диаметр обрабатываемой заготовки");
            add("Наибольшее расстояние между центрами");
            add("Наибольший диаметр обрабатываемой заготовки, устанавливаемой над суппортом");
            add("Все вышеперечисленное");
        }};

        Set<String> options3 = new HashSet<>() {{
            add("Одна бабка");
            add("Одна бабка и один дедка");
            add("Две бабки");
            add("Два дедки");
        }};

        Set<String> options4 = new HashSet<>() {{
            add("Упор");
            add("Подпор");
            add("Люнет");
            add("Ничего не применяется");
        }};

        Set<String> options5 = new HashSet<>() {{
            add("Контрсуппорт");
            add("Контршпиндель");
            add("Контрлюнет");
            add("Контрпатрон");
        }};

        Set<String> options6 = new HashSet<>() {{
            add("Четырехосевой токарный станок с ЧПУ");
            add("Универсальный токарный станок с ручным управлением");
            add("Трехосевой токарный станок с ЧПУ");
            add("Пятиосевой токарный станок с ЧПУ");
        }};

        Set<String> options7 = new HashSet<>() {{
            add("Нарезать внутреннюю резьбу");
            add("Просверлить отверстие");
            add("Проточить поверхность");
            add("Нарезать зубчатое колесо");
        }};

        Set<String> options8 = new HashSet<>() {{
            add("Вращение инструмента");
            add("Перемещение суппорта");
            add("Вращение заготовки");
            add("Перемещение задней бабки");
        }};

        Set<String> options9 = new HashSet<>() {{
            add("Приводной инструмент");
            add("Люнет");
            add("Контршпиндель");
            add("Четырехкулачковый патрон");
        }};

        Set<String> options10 = new HashSet<>() {{
            add("DMTC");
            add("ACCUT");
            add("GUBEN");
            add("SIECC");
        }};

        Set<String> options11 = new HashSet<>() {{
            add("Трансмиссия");
            add("Гитара");
            add("Задний редуктор");
            add("Линейка");
        }};

        Set<String> options12 = new HashSet<>() {{
            add("Барабан");
            add("Револьверная голова");
            add("Турель");
            add("Ножевая башня");
        }};

        //Фрезерные станки
        Set<String> options13 = new HashSet<>() {{
            add("Станок, у которого происходит вращательное движение фрезы с одновременным поступательным перемещением (подачей) обрабатываемой детали");
            add("Станок, у которого происходит вращение заготовки с одновременным перемещением режущего инструмента");
            add("Станок, предназначенный для создания отверстий в различных материалах с помощью вращающегося режущего инструмента – сверла");
            add("Станок, предназначенный для получения металлических деталей путем холодной гибки металлических заготовок");
        }};

        Set<String> options14 = new HashSet<>() {{
            add("Размер стола");
            add("Частота вращение шпинделя");
            add("Грузоподъемность стола");
            add("Все вышеперечисленное");
        }};

        Set<String> options15 = new HashSet<>() {{
            add("Перемещение стола");
            add("Вращение шпинделя");
            add("Перемещение салазок");
            add("Перемещение фрезы");
        }};

        Set<String> options16 = new HashSet<>() {{
            add("Цилиндрической");
            add("Фасонной");
            add("Отрезной");
            add("Дисковой");
        }};

        Set<String> options17 = new HashSet<>() {{
            add("3+1");
            add("3+2");
            add("X/Y/Z");
            add("5-1");
        }};

        Set<String> options18 = new HashSet<>() {{
            add("Тип крепления инструмента");
            add("Тип крепления заготовки");
            add("Регулятор частоты вращения");
            add("Система охлаждения шпинделя");
        }};

        Set<String> options19 = new HashSet<>() {{
            add("Ось Х");
            add("Ось Y");
            add("Ось Z");
            add("Ось С");
        }};

        Set<String> options20 = new HashSet<>() {{
            add("3");
            add("5");
            add("3+1");
            add("3+2");
        }};

        Set<String> options21 = new HashSet<>() {{
            add("RANK");
            add("DESUN-SEIKI");
            add("JIRFINE");
            add("FLLS");
        }};

        Set<String> options22 = new HashSet<>() {{
            add("ACCUT");
            add("DMTC");
            add("TOMAN");
            add("LIEBHERR");
        }};

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                topicRepo.save(lathe);
                topicRepo.save(milling);
                topicRepo.save(horizontalMilling);
                topicRepo.save(complex);

                //ГРСы
                //Заглушка
                Question grs = new Question("Угадай", horizontalMilling, options0, "3");
                grs.setImage("1.png");
                questionRepo.save(grs);

                //Токарные станки
                questionRepo.save(new Question("Что можно назвать токарным станком?", lathe, options1, "Все вышеперечисленное"));
                questionRepo.save(new Question("Назовите основные параметры токарных станков", lathe, options2, "Все вышеперечисленное"));
                questionRepo.save(new Question("Назовите, что есть в токарном станке", lathe, options3, "Две бабки"));
                questionRepo.save(new Question("Что применятся в токарном станке во избежание прогиба заготовки?", lathe, options4, "Люнет"));
                questionRepo.save(new Question("Какую опцию применяют на токарных станках, если требуется ускорить обработку и необходима переустановка детали?", lathe, options5, "Контршпиндель"));
                questionRepo.save(new Question("Какой необходимо предложить станок заказчику, если он планирует выпускать шпильки диаметром 10 мм в количестве 10 штук в месяц?", lathe, options6, "Универсальный токарный станок с ручным управлением"));
                questionRepo.save(new Question("Какую операцию невозможно сделать на универсальном токарном станке?", lathe, options7, "Нарезать зубчатое колесо"));
                questionRepo.save(new Question("Назовите главное движение в токарном станке", lathe, options8, "Вращение заготовки"));
                questionRepo.save(new Question("Что необходимо трехосевому токарному центру с ЧПУ, чтобы выполнить фрезерную операцию?", lathe, options9, "Приводной инструмент"));
                questionRepo.save(new Question("Назовите компанию из Китая, с которой мы сотрудничаем по токарным станкам", lathe, options10, "DMTC"));
                questionRepo.save(new Question("Как называется набор сменных зубчатых шестерен в токарном станке?", lathe, options11, "Гитара"));
                questionRepo.save(new Question("Как называется устройство с инструментами в токарном станке?", lathe, options12, "Револьверная голова"));

                //Фрезерные станки
                questionRepo.save(new Question("Что можно назвать фрезерным станком?", milling, options13, "Станок, у которого происходит вращательное движение фрезы с одновременным поступательным перемещением (подачей) обрабатываемой детали"));
                questionRepo.save(new Question("Назовите основные параметры фрезерного станка", milling, options14, "Все вышеперечисленное"));
                questionRepo.save(new Question("Назовите главное движение во фрезерном станке", milling, options15, "Вращение шпинделя"));
                questionRepo.save(new Question("Какой фрезы не бывает?", milling, options16, "Отрезной"));
                questionRepo.save(new Question("Как будет называться фрезерный станок с ЧПУ с накладным поворотным столом?", milling, options17, "3+1"));
                questionRepo.save(new Question("Конус шпинделя это?", milling, options18, "Тип крепления инструмента"));
                questionRepo.save(new Question("Как обозначается вращение планшайбы наклонно-поворотного стола?", milling, options19, "Ось С"));
                questionRepo.save(new Question("Сколько осей нужно для изготовления крыльчатки?", milling, options20, "5"));
                questionRepo.save(new Question("Какой у \"ИНТРАТУЛ\" основной партнер на фрезерное оборудование с ЧПУ", milling, options21, "FLLS"));
                questionRepo.save(new Question("Какой китайский партнер специализируется на производстве зубофрезерных станков с ЧПУ?", milling, options22, "TOMAN"));
            }
        };
    }
}
