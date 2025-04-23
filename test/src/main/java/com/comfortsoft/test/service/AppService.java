package com.comfortsoft.test.service;

import com.comfortsoft.test.dto.Request;
import com.comfortsoft.test.dto.Response;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class AppService {
    public Response getNthMin(Request request) {
        List<Long> numbers = readNumbersFromColumn(request.getPath());
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());

        numbers.forEach(number -> {
            queue.add(number);
            if (queue.size() > request.getNthMin()) {
                queue.poll();
            }
        });
        return new Response(queue.peek());
    }

    public List<Long> readNumbersFromColumn(String path) {
        List<Long> numbers = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(new File(path));
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    numbers.add((long) cell.getNumericCellValue());
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            throw new RuntimeException("IOException");
        }
        return numbers;
    }
}