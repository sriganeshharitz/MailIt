package com.uttarainfo.test.MailIt.Services;

import com.uttarainfo.test.MailIt.Model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelService {
    public List<Student> readExcel(MultipartFile file);
}
