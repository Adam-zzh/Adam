package com.huamiao.example.service.excel;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ExcelService {

    void exportExcelProduct() throws IOException;

    void exportExcel() throws IOException;

    void importExcel(MultipartFile file) throws IOException;
}
