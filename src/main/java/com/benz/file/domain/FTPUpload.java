package com.benz.file.domain;

import com.benz.framework.ftp.FTPClientWrapper;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by hongying.fu on 12/21/2016.
 */
public class FTPUpload {
    public String upload(InputStream inputStream, String originFileName) throws Exception {
        String destDirectoryPath = computeDestDirectoryPath();
        String newFileName = createNewFileName(originFileName);
        return new FTPClientWrapper().uploadToServer(inputStream, newFileName, destDirectoryPath);
    }

    private String createNewFileName(String oriFileName) {
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            newFileName = newFileName + random.nextInt(10);
        }
        String suffix = oriFileName.substring(oriFileName.lastIndexOf(".")).toLowerCase();
        newFileName += suffix;
        return newFileName;
    }

    private String computeDestDirectoryPath() {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String year = sdf.format(date);

        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        String month = sdfMonth.format(date);

        SimpleDateFormat sdfDate = new SimpleDateFormat("dd");
        String dateString = sdfDate.format(date);

        return File.separator + year + File.separator + month + File.separator + dateString + File.separator;
    }
}
