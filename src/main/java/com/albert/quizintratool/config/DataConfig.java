package com.albert.quizintratool.config;

import com.albert.quizintratool.model.Question;
import com.albert.quizintratool.model.Role;
import com.albert.quizintratool.model.Topic;
import com.albert.quizintratool.model.User;
import com.albert.quizintratool.repository.QuestionRepository;
import com.albert.quizintratool.repository.TopicRepository;
import com.albert.quizintratool.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


@Configuration
@Slf4j
public class DataConfig {

    @Bean
    public CommandLineRunner userLoader(UserRepository userRepository, PasswordEncoder encoder) {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String propsFileName = rootPath + "security.properties";
        Properties appProps = new Properties();
        try (FileInputStream input = new FileInputStream(propsFileName)) {
            appProps.load(input);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        User eliseev = new User(appProps.getProperty("user.login.eliseev"), "Алексей", "Елисеев", encoder.encode(appProps.getProperty("user.password.eliseev")), Role.USER);
        User kraynov = new User(appProps.getProperty("user.login.kraynov"), "Андрей", "Крайнов", encoder.encode(appProps.getProperty("user.password.kraynov")), Role.USER);
        User romantsov = new User(appProps.getProperty("user.login.romantsov"), "Евгений", "Романцов", encoder.encode(appProps.getProperty("user.password.romantsov")), Role.USER);
        User fedorov = new User(appProps.getProperty("user.login.fedorov"), "Алексей", "Федоров", encoder.encode(appProps.getProperty("user.password.fedorov")), Role.USER);
        User frolova = new User(appProps.getProperty("user.login.frolova"), "Анна", "Фролова", encoder.encode(appProps.getProperty("user.password.frolova")), Role.USER);
        User khrustalev = new User(appProps.getProperty("user.login.khrustalev"), "Олег", "Хрусталев", encoder.encode(appProps.getProperty("user.password.khrustalev")), Role.USER);
        User alimbaev = new User(appProps.getProperty("user.login.alimbaev"), "Курман", "Алимбаев", encoder.encode(appProps.getProperty("user.password.alimbaev")), Role.USER);
        User akhmetov = new User(appProps.getProperty("user.login.akhmetov"), "Владимир", "Ахметов", encoder.encode(appProps.getProperty("user.password.akhmetov")), Role.USER);
        User bugaets = new User(appProps.getProperty("user.login.bugaets"), "Антон", "Бугаец", encoder.encode(appProps.getProperty("user.password.bugaets")), Role.USER);
        User vlasova = new User(appProps.getProperty("user.login.vlasova"), "Мария", "Власова", encoder.encode(appProps.getProperty("user.password.vlasova")), Role.USER);
        User geychik = new User(appProps.getProperty("user.login.geychik"), "Ярослав", "Гейчик", encoder.encode(appProps.getProperty("user.password.geychik")), Role.USER);
        User dubenskiy = new User(appProps.getProperty("user.login.dubenskiy"), "Владислав", "Дубенский", encoder.encode(appProps.getProperty("user.password.dubenskiy")), Role.USER);
        User medvedeva = new User(appProps.getProperty("user.login.medvedeva"), "Ольга", "Медведева", encoder.encode(appProps.getProperty("user.password.medvedeva")), Role.USER);
        User ivliev = new User(appProps.getProperty("user.login.ivliev"), "Игорь", "Ивлиев", encoder.encode(appProps.getProperty("user.password.ivliev")), Role.USER);
        User ignateva = new User(appProps.getProperty("user.login.ignateva"), "Анастасия", "Игнатьева", encoder.encode(appProps.getProperty("user.password.ignateva")), Role.USER);
        User lyapinskiy = new User(appProps.getProperty("user.login.lyapinskiy"), "Антон", "Ляпинский", encoder.encode(appProps.getProperty("user.password.lyapinskiy")), Role.USER);
        User mikitenko = new User(appProps.getProperty("user.login.mikitenko"), "Анатолий", "Микитенко", encoder.encode(appProps.getProperty("user.password.mikitenko")), Role.USER);
        User motornyy = new User(appProps.getProperty("user.login.motornyy"), "Владимир", "Моторный", encoder.encode(appProps.getProperty("user.password.motornyy")), Role.USER);
        User mukhametzyanov = new User(appProps.getProperty("user.login.mukhametzyanov"), "Рашид", "Мухаметзянов", encoder.encode(appProps.getProperty("user.password.mukhametzyanov")), Role.USER);
        User neupokoev = new User(appProps.getProperty("user.login.neupokoev"), "Александр", "Неупокоев", encoder.encode(appProps.getProperty("user.password.neupokoev")), Role.USER);
        User novikov = new User(appProps.getProperty("user.login.novikov"), "Владислав", "Новиков", encoder.encode(appProps.getProperty("user.password.novikov")), Role.USER);
        User palkin = new User(appProps.getProperty("user.login.palkin"), "Владимир", "Палкин", encoder.encode(appProps.getProperty("user.password.palkin")), Role.USER);
        User rodionov = new User(appProps.getProperty("user.login.rodionov"), "Дмитрий", "Родионов", encoder.encode(appProps.getProperty("user.password.rodionov")), Role.USER);
        User ryabova = new User(appProps.getProperty("user.login.ryabova"), "Юлия", "Рябова", encoder.encode(appProps.getProperty("user.password.ryabova")), Role.USER);
        User slepenkov = new User(appProps.getProperty("user.login.slepenkov"), "Анатолий", "Слепенков", encoder.encode(appProps.getProperty("user.password.slepenkov")), Role.USER);
        User smirnov = new User(appProps.getProperty("user.login.smirnov"), "Сергей", "Смирнов", encoder.encode(appProps.getProperty("user.password.smirnov")), Role.USER);
        User hayrullin = new User(appProps.getProperty("user.login.hayrullin"),"Артур", "Хайруллин", encoder.encode(appProps.getProperty("user.password.hayrullin")), Role.USER);
        User shakhov = new User(appProps.getProperty("user.login.shakhov"), "Артем", "Шахов", encoder.encode(appProps.getProperty("user.password.shakhov")), Role.USER);
        User shvaybovich = new User(appProps.getProperty("user.login.shvaybovich"), "Людмила", "Швайбович", encoder.encode(appProps.getProperty("user.password.shvaybovich")), Role.USER);
        User shevchenko = new User(appProps.getProperty("user.login.shevchenko"), "Алексей", "Шевченко", encoder.encode(appProps.getProperty("user.password.shevchenko")), Role.USER);
        User shkatov = new User(appProps.getProperty("user.login.shkatov"), "Михаил", "Шкатов", encoder.encode(appProps.getProperty("user.password.shkatov")), Role.USER);
        User shlapak = new User(appProps.getProperty("user.login.shlapak"), "Екатерина", "Шлапак", encoder.encode(appProps.getProperty("user.password.shlapak")), Role.USER);
        User shumaev = new User(appProps.getProperty("user.login.shumaev"), "Алексей", "Шумаев", encoder.encode(appProps.getProperty("user.password.shumaev")), Role.USER);
        User yushin = new User(appProps.getProperty("user.login.yushin"), "Андрей", "Юшин", encoder.encode(appProps.getProperty("user.password.yushin")), Role.USER);

        User admin = new User(appProps.getProperty("user.login.admin"), "admin", "admin", encoder.encode(appProps.getProperty("user.password.admin")), Role.ADMIN);
        User test = new User(appProps.getProperty("user.login.test"), "test", "test", encoder.encode(appProps.getProperty("user.password.test")), Role.USER);
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                userRepository.save(bugaets);
                userRepository.save(vlasova);
                userRepository.save(eliseev);
                userRepository.save(ignateva);
                userRepository.save(kraynov);
                userRepository.save(lyapinskiy);
                userRepository.save(mikitenko);
                userRepository.save(motornyy);
                userRepository.save(rodionov);
                userRepository.save(romantsov);
                userRepository.save(ryabova);
                userRepository.save(fedorov);
                userRepository.save(frolova);
                userRepository.save(hayrullin);
                userRepository.save(khrustalev);
                userRepository.save(shvaybovich);
                userRepository.save(shevchenko);
                userRepository.save(shkatov);
                userRepository.save(geychik);
                userRepository.save(dubenskiy);
                userRepository.save(ivliev);
                userRepository.save(neupokoev);
                userRepository.save(novikov);
                userRepository.save(smirnov);
                userRepository.save(shakhov);
                userRepository.save(alimbaev);
                userRepository.save(akhmetov);
                userRepository.save(medvedeva);
                userRepository.save(mukhametzyanov);
                userRepository.save(palkin);
                userRepository.save(slepenkov);
                userRepository.save(shlapak);
                userRepository.save(shumaev);
                userRepository.save(yushin);

                userRepository.save(admin);
                userRepository.save(test);
            }
        };
    }



    @Bean
    public CommandLineRunner questionLoader(QuestionRepository questionRepo, TopicRepository topicRepo) {
        Topic lathe = new Topic("Токарные станки");
        Topic milling = new Topic("Фрезерные станки");
        Topic horizontalLathe = new Topic("Токарно-карусельные станки");
        Topic other = new Topic("Прочие станки");
        Topic complex = new Topic("Общий тест");

        //Токарные станки
        Set<String> lathe1 = new HashSet<>() {{
            add("Станок для обработки наружных, внутренних и торцовых поверхностей деталей типа тел вращения, а также для нарезания резьбы");
            add("Станок для обработки резанием (точением) заготовок (изделий) из металлов и других материалов в виде тел вращения");
            add("Станок, у которого главное движение осуществляется вращением заготовки, движение подачи — режущим инструментом");
            add("Все вышеперечисленное");
        }};

        Set<String> lathe2 = new HashSet<>() {{
            add("Наибольший диаметр обрабатываемой заготовки");
            add("Наибольшее расстояние между центрами");
            add("Наибольший диаметр обрабатываемой заготовки, устанавливаемой над суппортом");
            add("Все вышеперечисленное");
        }};

        Set<String> lathe3 = new HashSet<>() {{
            add("Одна бабка");
            add("Одна бабка и один дедка");
            add("Две бабки");
            add("Два дедки");
        }};

        Set<String> lathe4 = new HashSet<>() {{
            add("Упор");
            add("Подпор");
            add("Люнет");
            add("Ничего не применяется");
        }};

        Set<String> lathe5 = new HashSet<>() {{
            add("Контрсуппорт");
            add("Контршпиндель");
            add("Контрлюнет");
            add("Контрпатрон");
        }};

        Set<String> lathe6 = new HashSet<>() {{
            add("Четырехосевой токарный станок с ЧПУ");
            add("Универсальный токарный станок с ручным управлением");
            add("Трехосевой токарный станок с ЧПУ");
            add("Пятиосевой токарный станок с ЧПУ");
        }};

        Set<String> lathe7 = new HashSet<>() {{
            add("Нарезать внутреннюю резьбу");
            add("Просверлить отверстие");
            add("Проточить поверхность");
            add("Нарезать зубчатое колесо");
        }};

        Set<String> lathe8 = new HashSet<>() {{
            add("Вращение инструмента");
            add("Перемещение суппорта");
            add("Вращение заготовки");
            add("Перемещение задней бабки");
        }};

        Set<String> lathe9 = new HashSet<>() {{
            add("Приводной инструмент");
            add("Люнет");
            add("Контршпиндель");
            add("Четырехкулачковый патрон");
        }};

        Set<String> lathe10 = new HashSet<>() {{
            add("DMTC");
            add("ACCUT");
            add("GUBEN");
            add("SIECC");
        }};

        Set<String> lathe11 = new HashSet<>() {{
            add("Трансмиссия");
            add("Гитара");
            add("Задний редуктор");
            add("Линейка");
        }};

        Set<String> lathe12 = new HashSet<>() {{
            add("Барабан");
            add("Револьверная голова");
            add("Турель");
            add("Ножевая башня");
        }};

        Set<String> lathe13 = new HashSet<>() {{
            add("Длина значительно больше диаметра");
            add("Длина значительно меньше диаметра");
            add("Длина равна диаметру");
            add("Все детали типа тело вращения");
        }};

        Set<String> lathe14 = new HashSet<>() {{
            add("Устройство автоматической подачи прутка через шпиндель в токарный станок с ЧПУ");
            add("Устройство для смены инструмента в токарном станке с ЧПУ");
            add("Конвейер для отвода стружки из зоны резания");
            add("Устройство для подачи СОЖ под давлением через инструмент");
        }};

        Set<String> lathe15 = new HashSet<>() {{
            add("1");
            add("2");
            add("3");
            add("4");
        }};

        Set<String> lathe16 = new HashSet<>() {{
            add("DESUN-SEIKI");
            add("FLLS");
            add("TOMAN");
            add("ACCUT");
        }};

        //токарно-карусельные станки
        Set<String> horizontalLathe1 = new HashSet<>() {{
            add("Вращательное");
            add("Поступательное");
            add("Вращательное и поступательное в горизонтальной плоскости");
            add("Вращательное и поступательное в вертикальной плоскости");
        }};

        Set<String> horizontalLathe2 = new HashSet<>() {{
            add("Можно безопасно устанавливать крупногабаритные заготовки");
            add("Занимает меньшие площади по сравнению с подобным токарным");
            add("Может обрабатывать легированные стали");
            add("Можно установить систему ЧПУ");
        }};

        Set<String> horizontalLathe3 = new HashSet<>() {{
            add("11");
            add("3");
            add("7");
            add("8");
        }};

        Set<String> horizontalLathe4 = new HashSet<>() {{
            add("9");
            add("5");
            add("11");
            add("2");
        }};

        Set<String> horizontalLathe5 = new HashSet<>() {{
            add("Наличие планшайбы");
            add("Возможность обрабатывать фасонные поверхности");
            add("Вертикальная ось вращения шпинделя");
            add("Возможность установки револьверной головы");
        }};

        Set<String> horizontalLathe6 = new HashSet<>() {{
            add("Револьверная голова");
            add("Приводной инструмент");
            add("Шлифовальная голова");
            add("Люнет");
        }};

        Set<String> horizontalLathe7 = new HashSet<>() {{
            add("Одностоечная с подвижной поперечиной");
            add("Двухстоечная");
            add("Одностоечная с неподвижной поперечиной");
            add("Трехстоечная");
        }};

        Set<String> horizontalLathe8 = new HashSet<>() {{
            add("DMTC");
            add("ACCUT");
            add("FULLTON");
            add("SIECC");
        }};

        Set<String> horizontalLathe9 = new HashSet<>() {{
            add("Боже упаси");
            add("Только токарная");
            add("Только токарная и фрезерная");
            add("Может");
        }};

        Set<String> horizontalLathe10 = new HashSet<>() {{
            add("DMTC");
            add("DMG");
            add("SIECC");
            add("OKUMA");
        }};

        //Фрезерные станки
        Set<String> milling1 = new HashSet<>() {{
            add("Станок, у которого происходит вращательное движение фрезы с одновременным поступательным перемещением (подачей) обрабатываемой детали");
            add("Станок, у которого происходит вращение заготовки с одновременным перемещением режущего инструмента");
            add("Станок, предназначенный для создания отверстий в различных материалах с помощью вращающегося режущего инструмента – сверла");
            add("Станок, предназначенный для получения металлических деталей путем холодной гибки металлических заготовок");
        }};

        Set<String> milling2 = new HashSet<>() {{
            add("Размер стола");
            add("Частота вращение шпинделя");
            add("Грузоподъемность стола");
            add("Все вышеперечисленное");
        }};

        Set<String> milling3 = new HashSet<>() {{
            add("Перемещение стола");
            add("Вращение шпинделя");
            add("Перемещение салазок");
            add("Перемещение фрезы");
        }};

        Set<String> milling4 = new HashSet<>() {{
            add("Цилиндрической");
            add("Фасонной");
            add("Отрезной");
            add("Дисковой");
        }};

        Set<String> milling5 = new HashSet<>() {{
            add("3+1");
            add("3+2");
            add("X/Y/Z");
            add("5-1");
        }};

        Set<String> milling6 = new HashSet<>() {{
            add("Тип крепления инструмента");
            add("Тип крепления заготовки");
            add("Регулятор частоты вращения");
            add("Система охлаждения шпинделя");
        }};

        Set<String> milling7 = new HashSet<>() {{
            add("Ось Х");
            add("Ось Y");
            add("Ось Z");
            add("Ось С");
        }};

        Set<String> milling8 = new HashSet<>() {{
            add("3");
            add("5");
            add("3+1");
            add("3+2");
        }};

        Set<String> milling9 = new HashSet<>() {{
            add("RANK");
            add("DESUN-SEIKI");
            add("JIRFINE");
            add("FLLS");
        }};

        Set<String> milling10 = new HashSet<>() {{
            add("ACCUT");
            add("DMTC");
            add("TOMAN");
            add("LIEBHERR");
        }};


        Set<String> milling11 = new HashSet<>() {{
            add("все вышеперечисленное");
            add("для фиксации станка на фундаменте");
            add("для фиксации заготовки");
            add("для фиксации фрезы в шпинделе");
        }};

        Set<String> milling12 = new HashSet<>() {{
            add("вертикально-фрезерный");
            add("горизонтально-фрезерный");
            add("зубофрезерный");
            add("продольно-фрезерный");
        }};

        Set<String> milling13 = new HashSet<>() {{
            add("RANK");
            add("DESUN-SEIKI");
            add("JIRFINE");
            add("FLLS");
        }};

        Set<String> milling14 = new HashSet<>() {{
            add("3");
            add("3+2");
            add("3+1");
            add("5");
        }};

        //прочее
        Set<String> other1 = new HashSet<>() {{
            add("Круглошлифовальный");
            add("Плоскошлифовальный");
            add("Внутришлифовальный");
            add("Обдирочно-шлифовальный");
        }};

        Set<String> other2 = new HashSet<>() {{
            add("об/мин");
            add("мм/мин");
            add("Н*м");
            add("кВА");
        }};

        Set<String> other3 = new HashSet<>() {{
            add("10");
            add("3,14");
            add("100");
            add("1000");
        }};

        Set<String> other4 = new HashSet<>() {{
            add("Тип крепления инструмента");
            add("Тип крепления заготовки");
            add("Регулятор частоты вращения");
            add("Система охлаждения шпинделя");
        }};

        Set<String> other5 = new HashSet<>() {{
            add("Шарнирно-винтовое присоединение");
            add("Шарико-винтовая передача");
            add("Что-то про прибыль");
            add("Ширина внутреннего пространства");
        }};

        Set<String> other6 = new HashSet<>() {{
            add("С разговора в курилке");
            add("С сообщения в ватсапе");
            add("С технического задания");
            add("«Мне тут сообщили»");
        }};

        Set<String> other7 = new HashSet<>() {{
            add("ACCUT");
            add("SIECC");
            add("DMTC");
            add("FLLS");
        }};

        Set<String> other8 = new HashSet<>() {{
            add("да");
            add("нет");
            add("не знаю");
            add("конечно нет");
        }};


        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                topicRepo.save(lathe);
                topicRepo.save(milling);
                topicRepo.save(complex);
                topicRepo.save(horizontalLathe);
                topicRepo.save(other);

                //Токарные станки
                questionRepo.save(new Question("Что можно назвать токарным станком?", lathe, lathe1, "Все вышеперечисленное"));
                questionRepo.save(new Question("Назовите основные параметры токарных станков", lathe, lathe2, "Все вышеперечисленное"));
                questionRepo.save(new Question("Назовите, что есть в токарном станке", lathe, lathe3, "Две бабки"));
                questionRepo.save(new Question("Что применятся в токарном станке во избежание прогиба заготовки?", lathe, lathe4, "Люнет"));
                questionRepo.save(new Question("Какую опцию применяют на токарных станках, если требуется ускорить обработку и необходима переустановка детали?", lathe, lathe5, "Контршпиндель"));
                questionRepo.save(new Question("Какой необходимо предложить станок заказчику, если он планирует выпускать шпильки диаметром 10 мм в количестве 10 штук в месяц?", lathe, lathe6, "Универсальный токарный станок с ручным управлением"));
                questionRepo.save(new Question("Какую операцию невозможно сделать на универсальном токарном станке?", lathe, lathe7, "Нарезать зубчатое колесо"));
                questionRepo.save(new Question("Назовите главное движение в токарном станке", lathe, lathe8, "Вращение заготовки"));
                questionRepo.save(new Question("Что необходимо трехосевому токарному центру с ЧПУ, чтобы выполнить фрезерную операцию?", lathe, lathe9, "Приводной инструмент"));
                questionRepo.save(new Question("Назовите компанию из Китая, с которой мы сотрудничаем по токарным станкам", lathe, lathe10, "DMTC"));
                questionRepo.save(new Question("Как называется набор сменных зубчатых шестерен в токарном станке?", lathe, lathe11, "Гитара"));
                questionRepo.save(new Question("Как называется устройство с инструментами в токарном станке?", lathe, lathe12, "Револьверная голова"));
                questionRepo.save(new Question("К классу валов относят детали, у которых:", lathe, lathe13, "Длина значительно меньше диаметра"));
                questionRepo.save(new Question("Что такое барфидер?", lathe, lathe14, "Устройство автоматической подачи прутка через шпиндель в токарный станок с ЧПУ"));
                questionRepo.save(new Question("Под каким номером изображен токарный станок с ЧПУ", lathe, lathe15, "1", "1.jpg"));
                questionRepo.save(new Question("Какой китайский партнер производит 5-осевые токарно-фрезерные станки?", lathe, lathe16, "DESUN-SEIKI"));

                //Токарно-карусельные станки
                questionRepo.save(new Question("Какие перемещения имеет стол токарно-карусельного станка?", horizontalLathe, horizontalLathe1, "Вращательное"));
                questionRepo.save(new Question("Какое основное преимущество токарно-карусельного станка от токарно-винторезного?", horizontalLathe, horizontalLathe2, "Можно безопасно устанавливать крупногабаритные заготовки"));
                questionRepo.save(new Question("Укажите цифру, которая обозначает ползун на рисунке", horizontalLathe, horizontalLathe3, "8", "4.png"));
                questionRepo.save(new Question("Укажите цифру, которая обозначает траверсу на рисунке", horizontalLathe, horizontalLathe4, "5", "4.png"));
                questionRepo.save(new Question("Какое основное отличие токарно-карусельного от токарно-винторезного станка?", horizontalLathe, horizontalLathe5, "Вертикальная ось вращения шпинделя"));
                questionRepo.save(new Question("Какой опции не бывает у токарно-карусельных станков?", horizontalLathe, horizontalLathe6, "Люнет"));
                questionRepo.save(new Question("Какой компоновки карусельного станка не может быть?", horizontalLathe, horizontalLathe7, "Трехстоечная"));
                questionRepo.save(new Question("Назовите компанию из Китая, с которыми мы НЕ сотрудничаем по токарно-карусельным станкам?", horizontalLathe, horizontalLathe8, "SIECC"));
                questionRepo.save(new Question("Может ли быть на токарно-карусельном станке шлифовальная функция?", horizontalLathe, horizontalLathe9, "Может"));
                questionRepo.save(new Question("Кто из наших китайских партнеров делает оптимальные карусельные станки цена-качество?", horizontalLathe, horizontalLathe10, "DMTC"));

                //Фрезерные станки
                questionRepo.save(new Question("Что можно назвать фрезерным станком?", milling, milling1, "Станок, у которого происходит вращательное движение фрезы с одновременным поступательным перемещением (подачей) обрабатываемой детали"));
                questionRepo.save(new Question("Назовите основные параметры фрезерного станка", milling, milling2, "Все вышеперечисленное"));
                questionRepo.save(new Question("Назовите главное движение во фрезерном станке", milling, milling3, "Вращение шпинделя"));
                questionRepo.save(new Question("Какой фрезы не бывает?", milling, milling4, "Отрезной"));
                questionRepo.save(new Question("Как будет называться фрезерный станок с ЧПУ с накладным поворотным столом?", milling, milling5, "3+1"));
                questionRepo.save(new Question("Конус шпинделя это?", milling, milling6, "Тип крепления инструмента"));
                questionRepo.save(new Question("Как обозначается вращение планшайбы наклонно-поворотного стола?", milling, milling7, "Ось С"));
                questionRepo.save(new Question("Сколько осей нужно для изготовления крыльчатки?", milling, milling8, "5"));
                questionRepo.save(new Question("Какой у \"ИНТРАТУЛ\" основной партнер на фрезерное оборудование с ЧПУ", milling, milling9, "FLLS"));
                questionRepo.save(new Question("Какой китайский партнер специализируется на производстве зубофрезерных станков с ЧПУ?", milling, milling10, "TOMAN"));
                questionRepo.save(new Question("Для чего используются изображенные на рисунке детали?", milling, milling11, "для фиксации заготовки", "2.png"));
                questionRepo.save(new Question("Какой тип станка изображен на рисунке?", milling, milling12, "горизонтально-фрезерный", "3.jpg"));
                questionRepo.save(new Question("Какой у нас основной партнер на фрезерное оборудование с ЧПУ?", milling, milling13, "FLLS"));
                questionRepo.save(new Question("Сколько осей имеет данная компоновка фрезерного станка?", milling, milling14, "5", "9.jpg"));
                questionRepo.save(new Question("Сколько осей имеет данная компоновка фрезерного станка?", milling, milling14, "3+2", "10.jpg"));

                //Прочее
                questionRepo.save(new Question("К какому виду относится данный станок?", other, other1, "Обдирочно-шлифовальный", "5.jpg"));
                questionRepo.save(new Question("К какому виду относится данный станок?", other, other1, "Внутришлифовальный", "6.jpg"));
                questionRepo.save(new Question("К какому виду относится данный станок?", other, other1, "Круглошлифовальный", "7.jpg"));
                questionRepo.save(new Question("К какому виду относится данный станок?", other, other1, "Плоскошлифовальный", "8.png"));
                questionRepo.save(new Question("Единица измерения крутящего момента шпинделя:", other, other2, "Н*м"));
                questionRepo.save(new Question("Сколько микрон в одном миллиметре?", other, other3, "1000"));
                questionRepo.save(new Question("Конус шпинделя это?", other, other4, "Тип крепления инструмента"));
                questionRepo.save(new Question("ШВП это?", other, other5, "Шарико-винтовая передача"));
                questionRepo.save(new Question("С чего начинается проработка станка у менеджера с техническим отделом?", other, other6, "С технического задания"));
                questionRepo.save(new Question("Какой китайский партнер специализируется на производстве заготовительного оборудования?", other, other7, "SIECC"));
                questionRepo.save(new Question("Зависит ли производительность и точность обработки деталей на металлорежущих станках от оснащения их технологической оснасткой?", other, other8, "да"));

            }
        };
    }
}
