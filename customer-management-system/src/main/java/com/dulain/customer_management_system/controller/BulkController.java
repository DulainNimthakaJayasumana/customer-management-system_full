package com.dulain.customer_management_system.controller;

import com.dulain.customer_management_system.service.ExcelImportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/bulk")
@CrossOrigin
public class BulkController {

    private final ExcelImportService excel;

    public BulkController(ExcelImportService excel) {
        this.excel = excel;
    }

    /** Upload file → async parse → 202 Accepted */
    @PostMapping("/customers")
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) throws Exception {
        excel.importFile(file.getInputStream());
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}