package com.example.task.api;
import com.example.task.controller.ExcelCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        //логгер: Открыть файл
        final Logger logger = LoggerFactory.getLogger(TaskApplication.class);
        SpringApplication.run(TaskApplication.class, args);
        ExcelCreator.CreateExcelAll();
    };


}
