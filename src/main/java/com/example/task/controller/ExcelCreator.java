package com.example.task.controller;

import com.example.task.model.CountryListModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;

public class ExcelCreator {
    private static final Logger logger = LoggerFactory.getLogger(ExcelCreator.class);
    public static void CreateExcelAll(){
        try {
            // Получаем URL XML-файла
            URL url = new URL("https://www.international.gc.ca/world-monde/assets/office_docs/international_relations-relations_internationales/sanctions/sema-lmes.xml").toURI().toURL();
            // Создаем объект Unmarshaller для преобразования XML в Java-объекты
            JAXBContext jaxbContext = JAXBContext.newInstance(CountryListController.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Преобразуем XML в Java-объекты
            CountryListController  sanctionsList = (CountryListController) jaxbUnmarshaller.unmarshal(url);

            // Создаем новую книгу Excel
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sanctions");

            // Заголовки столбцов
            String[] headers = {"№","Schedule", "Фамилия", "Имя","Наименования", "Дата рождения", "Гражданство"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Добавляем данные из Java-объектов в Excel
            List<CountryListModel> records = sanctionsList.getRecords();
            int rowNum = 1;
            for (CountryListModel record : records) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(record.getItem());
                row.createCell(1).setCellValue(record.getSchedule());
                row.createCell(2).setCellValue(record.getGivenName());
                row.createCell(3).setCellValue(record.getLastName());
                row.createCell(4).setCellValue(record.getEntity());
                row.createCell(5).setCellValue(record.getDateOfBirth());
                row.createCell(6).setCellValue(record.getCountry());
            }

            // Сохраняем книгу Excel в файл
            FileOutputStream fileOut = new FileOutputStream("src/main/resources/sanctions.xlsx");
            workbook.write(fileOut);
            fileOut.close();

            // Закрываем книгу Excel
            workbook.close();
        } catch (Exception e) {logger.error("An error occurred", e);}
    }
}