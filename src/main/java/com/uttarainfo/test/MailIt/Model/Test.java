package com.uttarainfo.test.MailIt.Model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args){
//        FileInputStream file=null;
//        Workbook workbook = null;
//        try {
//             file = new FileInputStream(new File("C:\\Users\\Dell\\Desktop\\Sample.xlsx"));
//             workbook = new XSSFWorkbook(file);
//             Sheet sheet = workbook.getSheetAt(0);
//             Map<Integer,List<String>> data = new HashMap<Integer, List<String>>();
//             int i = 0;
//             for(Row row:sheet){
//                data.put(i,new ArrayList<String>());
//                for(Cell cell:row){
//                    switch (cell.getCellTypeEnum()){
//                        case STRING:
//                            data.get(i).add(cell.getRichStringCellValue().getString());
//                            System.out.println(cell.getColumnIndex());
//                            break;
//                        case NUMERIC:
//                            data.get(i).add(cell.getNumericCellValue()+"");
//                            System.out.println(cell.getColumnIndex());
//                            break;
//                    }
//                }
//                i++;
//             }
//            System.out.println(data);
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
    }
}
