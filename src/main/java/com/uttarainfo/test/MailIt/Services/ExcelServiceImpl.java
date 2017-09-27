package com.uttarainfo.test.MailIt.Services;

import com.uttarainfo.test.MailIt.Model.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class ExcelServiceImpl implements ExcelService {
    @Override
    public List<Student> readExcel(MultipartFile file) {
        InputStream in = null;
        BufferedReader br = null;
        FileOutputStream out = null;
        BufferedWriter bw = null;
        Workbook workbook = null;
        try {
//            in = file.getInputStream();
//            String fileLocation = "C:\\Users\\Dell\\Desktop\\MailIt\\src\\main\\resources\\static\\data\\" + file.getOriginalFilename();
//            br = new BufferedReader(new InputStreamReader(in));
//            List<String> al = new ArrayList<String>();
//            String str = "";
//            while ((str = br.readLine())!=null){
//                al.add(str);
//            }
//            br.close();
//            out = new FileOutputStream(fileLocation);
//            bw = new BufferedWriter(new OutputStreamWriter(out));
//            for(String s:al){
//                bw.write(s);
//                bw.newLine();
//            }
//            bw.flush();
            in = file.getInputStream();
            workbook = new XSSFWorkbook(in);
            Sheet sheet = workbook.getSheetAt(0);
            List<Student> students = new ArrayList<Student>();
            for(Row row:sheet){
                Student student = new Student();
                for(Cell cell:row){
                    switch (cell.getColumnIndex()){
                        case 0:
                            student.setFirstName(cell.getRichStringCellValue().toString());
                            break;
                        case 1:
                            student.setLastName(cell.getRichStringCellValue().getString());
                            break;
                        case 2:
                            student.setEmail(cell.getRichStringCellValue().getString());
                            break;
                        case 3:
                            student.setJavaScore(cell.getNumericCellValue()+"");
                            break;
                        case 4:
                            student.setAptitudeScore(cell.getNumericCellValue()+"");
                            break;
                    }
                }
                students.add(student);
            }
            return students;

        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
        finally {
            if(in!=null)
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(workbook!=null)
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        }
    }

