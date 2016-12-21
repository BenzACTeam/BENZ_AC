package com.benz.framework.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hongying.fu on 12/21/2016.
 */
public class FTPClientWrapper {

    private FTPClient ftp;

    public String uploadToServer(InputStream inputStream, String directoryPath, String fileName) throws Exception {
        FTPParameter parameter = new FTPParameter();
        try {
            connectFtp(parameter.getUrl(), parameter.getPort(), parameter.getUsername(), parameter.getPassword());

            ftp.changeWorkingDirectory("FTPUpload");
            createDirectory(directoryPath);

            ftp.storeFile(fileName, inputStream);
            return parameter.getHttpUrl() + directoryPath + fileName;
        } catch (Exception e) {
            throw e;
        } finally {
            inputStream.close();
            closeFtp();
        }
    }

    private boolean connectFtp(String url, Integer port, String username, String password) throws Exception {
        ftp = new FTPClient();
        boolean flag = false;
        int reply;
        if (port == null) {
            ftp.connect(url, 21);
        } else {
            ftp.connect(url, port);
        }
        ftp.login(username, password);
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            return flag;
        }
        flag = true;
        return flag;
    }

    private void createDirectory(String directory) throws IOException {
        boolean success = true;
        if (!directory.equalsIgnoreCase(File.separator) && !ftp.changeWorkingDirectory(directory.substring(1))) {
            int start = 0;
            int end = 0;
            if (directory.startsWith(File.separator)) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf(File.separator, start);
            while (true) {
                String subDirectory = directory.substring(start, end);
                if (!ftp.changeWorkingDirectory(subDirectory)) {
                    if (ftp.makeDirectory(subDirectory)) {
                        ftp.changeWorkingDirectory(subDirectory);
                    } else {
                        System.out.println("创建目录失败");
                        success = false;
                    }
                }
                start = end + 1;
                end = directory.indexOf(File.separator, start);
                if (end <= start) {
                    break;
                }
            }
        }
    }

    private void closeFtp() {
        if (ftp != null && ftp.isConnected()) {
            try {
                ftp.logout();
                ftp.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
