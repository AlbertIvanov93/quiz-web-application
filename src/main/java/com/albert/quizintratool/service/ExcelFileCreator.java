package com.albert.quizintratool.service;

import com.albert.quizintratool.model.Question;
import com.albert.quizintratool.model.Result;
import com.albert.quizintratool.repository.QuestionRepository;
import com.albert.quizintratool.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExcelFileCreator {

    private final ResultRepository resultRepository;
    private final QuestionRepository questionRepository;
    private static int questionStartColumn = 5;
    private static int resultStartRow = 7;
    private static String questionIdName = "ID";
    private static String topicName = "Тема";
    private static String questionName = "Вопрос";
    private static String optionName = "Вариант ответа";
    private static String userName = "Пользователь";
    private static String beginName = "Начало теста";
    private static String endName = "Окончание теста";
    private static String scoreName = "Правильных ответов";
    private static String maxScoreName = "Количество вопросов";

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


    public Workbook createWorkbook() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Результаты");

        Row idRow = sheet.createRow(0);
        Row topicRow = sheet.createRow(1);
        Row questionRow = sheet.createRow(2);
        Row option1Row = sheet.createRow(3);
        Row option2Row = sheet.createRow(4);
        Row option3Row = sheet.createRow(5);
        Row option4Row = sheet.createRow(6);
        Row resultNamesRow = sheet.createRow(7);
        Row[] optionRows = new Row[]{option1Row, option2Row, option3Row, option4Row};

        //стили для ячеек
        sheet.setDefaultColumnWidth(25);

        CellStyle greenCell = workbook.createCellStyle();
        greenCell.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        greenCell.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle redCell = workbook.createCellStyle();
        redCell.setFillForegroundColor(IndexedColors.RED.getIndex());
        redCell.setFillPattern(FillPatternType.SOLID_FOREGROUND);


        // заполнить подписи строк к вопросам
        Cell questionIdNameCell = idRow.createCell(questionStartColumn);
        questionIdNameCell.setCellValue(questionIdName);
        Cell topicNameCell = topicRow.createCell(questionStartColumn);
        topicNameCell.setCellValue(topicName);
        Cell questionNameCell = questionRow.createCell(questionStartColumn);
        questionNameCell.setCellValue(questionName);
        Cell option1Cell = option1Row.createCell(questionStartColumn);
        option1Cell.setCellValue(optionName);
        Cell option2Cell = option2Row.createCell(questionStartColumn);
        option2Cell.setCellValue(optionName);
        Cell option3Cell = option3Row.createCell(questionStartColumn);
        option3Cell.setCellValue(optionName);
        Cell option4Cell = option4Row.createCell(questionStartColumn);
        option4Cell.setCellValue(optionName);

        // заполнить все возможные вопросы и варианты ответов
        Iterable<Question> questions = questionRepository.findAll();
        questions.forEach(question -> {
            int column = Math.toIntExact(question.getId()) + questionStartColumn;
            Cell idCell = idRow.createCell(column);
            idCell.setCellValue(Math.toIntExact(question.getId()));
            Cell topicCell = topicRow.createCell(column);
            topicCell.setCellValue(question.getTopic().getName());
            Cell questionCell = questionRow.createCell(column);
            questionCell.setCellValue(question.getTitle());
            Set<String> options = question.getOptions();

            int counter = 0;
            for (String option : options) {
                Cell optionCell = optionRows[counter].createCell(column);
                optionCell.setCellValue(option);
                counter++;
                if (option.equals(question.getAnswer())) {
                    optionCell.setCellStyle(greenCell);
                }
            }
        });

        //заполнить подписи к результатам пользователей
        Cell resultIdNameCell = resultNamesRow.createCell(0);
        resultIdNameCell.setCellValue(questionIdName);
        Cell UserNameCell = resultNamesRow.createCell(1);
        UserNameCell.setCellValue(userName);
        Cell beginNameCell = resultNamesRow.createCell(2);
        beginNameCell.setCellValue(beginName);
        Cell endNameCell = resultNamesRow.createCell(3);
        endNameCell.setCellValue(endName);
        Cell scoreNameCell = resultNamesRow.createCell(4);
        scoreNameCell.setCellValue(scoreName);
        Cell maxScoreNameCell = resultNamesRow.createCell(5);
        maxScoreNameCell.setCellValue(maxScoreName);

        //заполнить все результаты пользователей
        Iterable<Result> results = resultRepository.findAll();
        results.forEach(result -> {
            //информация о пользователе
            Row resultRow =  sheet.createRow((int) (result.getId() + resultStartRow));
            Cell resultIdCell = resultRow.createCell(0);
            resultIdCell.setCellValue(result.getId());
            Cell userNameCell = resultRow.createCell(1);
            userNameCell.setCellValue(result.getUser().getFirstName() + " " + result.getUser().getLastName());
            Cell beginDateCell = resultRow.createCell(2);
            beginDateCell.setCellValue(formatter.format(result.getBeginDate()));
            Cell endDateCell = resultRow.createCell(3);
            endDateCell.setCellValue(formatter.format(result.getEndDate()));
            Cell scoreCell = resultRow.createCell(4);
            scoreCell.setCellValue(result.getScore());
            Cell maxScoreCell = resultRow.createCell(5);
            maxScoreCell.setCellValue(result.getMaxScore());

            //ответы на вопросы
            result.getResultMap().forEach((question, answer) -> {
                Cell answerCell = resultRow.createCell((int) (question.getId() + questionStartColumn));
                answerCell.setCellValue(answer);
                if (answer.equals(question.getAnswer())) {
                    answerCell.setCellStyle(greenCell);
                } else {
                    answerCell.setCellStyle(redCell);
                }
            });
        });


        return workbook;
    }
}
