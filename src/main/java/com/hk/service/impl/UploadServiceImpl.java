package com.hk.service.impl;

import com.hk.service.UploadService;
import com.hk.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * Created by Will on 2018/3/22.
 */
@Service
public class UploadServiceImpl implements UploadService {

    public String uploadImage(CommonsMultipartFile file, String savedName, String baseDir, String secondDir) throws IOException {
        String fileDir = baseDir + secondDir;
        //如果目录不存在则创建目录
        File dir = new File(fileDir);
        if (dir.exists()) {
            FileUtils.deleteDir(dir);
        }
        dir.mkdirs();
        //生成输出地址URL
        String outputPath = fileDir + "/" + savedName;
        File newFile = new File(outputPath);
        file.transferTo(newFile);
        String outUrl = "/uploadImg" + secondDir + "/" + savedName;
        return outUrl;
    }
}
