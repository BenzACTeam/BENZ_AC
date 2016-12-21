package com.benz.file.adapter.web;

import com.benz.file.application.FileApplicationService;
import com.benz.file.application.FileResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by hongying.fu on 12/21/2016.
 */
@RestController
public class FileController {

    @Autowired
    private FileApplicationService fileApplicationService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public FileResult upload(HttpServletRequest request) throws Exception {

       /* MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");

        InputStream inputStream = multipartFile.getInputStream();
        String oriFileName = multipartFile.getOriginalFilename();*/
        InputStream inputStream = new FileInputStream(new File("C:\\Users\\hongying.fu\\Desktop\\2016\\12\\20\\20161220164616128168.jpg"));
        String oriFileName = ".jpg";
        return fileApplicationService.upload(inputStream, oriFileName);

    }

}
