package com.albert.quizintratool.controller.admin;

import com.albert.quizintratool.service.ExcelFileCreator;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;



@Controller
@RequestMapping("/userresults")
@RequiredArgsConstructor
@Slf4j
public class UserResultsController {

    private final ExcelFileCreator excelFileCreator;

    @GetMapping
    public String getTopicsPage() {
        return "/userresults";
    }

/*    @GetMapping("/download")
    public @ResponseBody void downloadResults(HttpServletResponse response) throws IOException {
        File file = new File("src/main/resources/static/results/results.txt");
        response.getOutputStream();

        Workbook workbook = excelFileCreator.createWorkbook();



        InputStream in = new FileInputStream(file);

        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(workbook, response.getOutputStream());
    }*/

    @GetMapping(value="/download")
    public ResponseEntity<ByteArrayResource> downloadResults() {
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            Workbook workbook = excelFileCreator.createWorkbook();
            HttpHeaders header = new HttpHeaders();
            header.setContentType(new MediaType("application", "force-download"));
            header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProductTemplate.xlsx");
            workbook.write(stream);
            workbook.close();
            return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()),
                    header, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
