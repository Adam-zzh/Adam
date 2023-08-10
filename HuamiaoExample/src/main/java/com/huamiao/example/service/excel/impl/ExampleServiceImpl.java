//package com.huamiao.example.service.excel.impl;
//
//import cn.hutool.core.bean.BeanUtil;
//import cn.hutool.core.date.DateUtil;
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.read.builder.ExcelReaderBuilder;
//import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
//import com.alibaba.excel.support.ExcelTypeEnum;
//import com.huamiao.example.function.excel.ExcelImportManager;
//import com.huamiao.example.listener.excel.CommonReaderListener;
//import com.huamiao.example.model.excel.ExcelExportOrder;
//import com.huamiao.example.model.excel.ExportExcelOfOrder;
//import com.huamiao.example.model.excel.ExportExcelOfOrderProduct;
//import com.huamiao.example.model.excel.ImportExcelOfOrder;
//import com.huamiao.example.service.excel.ExcelService;
//import com.huamiao.example.strategy.CustomMergeStrategy;
//import com.huamiao.example.util.excel.EasyExcelUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈导出excel业务〉
// *
// */
//@Service
//@Slf4j
//public class ExcelServiceImpl implements ExcelService, ExcelImportManager<ImportExcelOfOrder> {
//
//    @Autowired
//    private ExcelExportOrderExtMapper excelExportOrderExtMapper;
//
//    @Autowired
//    private ExcelExportOrderMapper excelExportOrderMapper;
//
//    @Override
//    public void exportExcelProduct() throws IOException {
//        String filePath = "E:" + File.separator + "file" + DateUtil.format(DateUtil.date(), "yyyyMMdd");
//        String fileName = filePath + File.separator + "orderTest.xlsx";
//
//        System.out.println(fileName);
//
//        if(Files.notExists(Paths.get(filePath))) Files.createDirectories(Paths.get(filePath));
//        if(Files.notExists(Paths.get(fileName)))  Files.createFile(Paths.get(fileName));
//        ExcelWriter excelWriter = EasyExcel
//                .write(fileName, ExportExcelOfOrderProduct.class)
//                .registerWriteHandler(new CustomMergeStrategy(ExportExcelOfOrderProduct.class))
//                .excelType(ExcelTypeEnum.XLSX).build();
//
//
//        EasyExcelUtils.pageWrite(excelWriter, "数据清单", 20000l,
//                (currentPage, pageSize) -> excelExportOrderExtMapper.queryOrderProductForExport(currentPage, pageSize));
//    }
//
//    @Override
//    public void exportExcel() throws IOException {
//        String filePath = "E:" + File.separator + "file" + DateUtil.format(DateUtil.date(), "yyyyMMdd");
//        String fileName = filePath + File.separator + "orderTest.xlsx";
//
//        System.out.println(fileName);
//
//        if(Files.notExists(Paths.get(filePath))) Files.createDirectories(Paths.get(filePath));
//        if(Files.notExists(Paths.get(fileName)))  Files.createFile(Paths.get(fileName));
//
//        ExcelWriter excelWriter = EasyExcel
//                .write(fileName, ExportExcelOfOrder.class)
//                .excelType(ExcelTypeEnum.XLSX).build();
//
//        Long total = excelExportOrderExtMapper.queryTotalRecordsForExport();
//
//        EasyExcelUtils.pageWrite(excelWriter, "数据清单", total,
//                (currentPage, pageSize) -> excelExportOrderExtMapper.queryOrderForExport(currentPage, pageSize));
//    }
//
//    @Override
//    @Transactional
//    public void importExcel(MultipartFile file) throws IOException {
//        ExcelReaderBuilder workBook  = EasyExcel.read
//                (file.getInputStream(), ImportExcelOfOrder.class, new CommonReaderListener<ImportExcelOfOrder>(this));
//        ExcelReaderSheetBuilder sheet = workBook.sheet();
//        sheet.doRead();
//    }
//
//    @Override
//    public int importData(List<ImportExcelOfOrder> datas) {
//        datas.forEach(item -> {
//            ExcelExportOrder bean = new ExcelExportOrder();
//            BeanUtil.copyProperties(item, bean);
//            excelExportOrderMapper.insertSelective(bean);
//        });
//
//        return datas.size();
//    }
//
//}