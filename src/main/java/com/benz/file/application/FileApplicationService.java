package com.benz.file.application;

import com.benz.file.domain.FTPUpload;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Created by hongying.fu on 12/21/2016.
 */
@Service
public class FileApplicationService {
    public FileResult upload(InputStream inputStream, String newFileName) throws Exception {
        String filePath = new FTPUpload().upload(inputStream, newFileName);
        return new FileResult(filePath);
    }

}
