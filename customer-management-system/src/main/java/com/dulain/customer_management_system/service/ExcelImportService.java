package com.dulain.customer_management_system.service;

import com.dulain.customer_management_system.entity.Customer;
import com.dulain.customer_management_system.repository.CustomerRepository;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Very lightweight streaming import for big Excel / CSV files (≈ 1 M rows).
 * For demo simplicity, expect <b>CSV-like data</b> inside the first sheet:
 *   name,dob(yyyy-MM-dd),nic
 */
@Service
public class ExcelImportService {

    private final CustomerRepository repo;

    public ExcelImportService(CustomerRepository repo) {
        this.repo = repo;
    }

    @Async
    public void importFile(InputStream in) throws Exception {
        OPCPackage pkg = OPCPackage.open(in);
        XSSFReader reader = new XSSFReader(pkg);
        try (InputStream sheet = ((XSSFReader.SheetIterator) reader.getSheetsData()).next();
             BufferedReader br = new BufferedReader(new InputStreamReader(sheet))) {

            String line;
            boolean header = true;
            List<Customer> batch = new ArrayList<>(1000);

            while ((line = br.readLine()) != null) {
                if (header) { header = false; continue; }     // skip CSV header
                String[] p = line.split(",");
                if (p.length < 3) continue;

                Customer c = new Customer();
                c.setName(p[0]);
                c.setDateOfBirth(LocalDate.parse(p[1]));
                c.setNic(p[2]);
                batch.add(c);

                if (batch.size() >= 1000) {
                    repo.saveAll(batch);
                    batch.clear();
                }
            }
            if (!batch.isEmpty()) repo.saveAll(batch);
        }
    }
}