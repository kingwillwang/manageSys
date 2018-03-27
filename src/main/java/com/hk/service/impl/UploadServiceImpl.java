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

    public String uploadImage(CommonsMultipartFile file,String savedName, String savedDir) throws IOException {
        //如果目录不存在则创建目录
        File dir = new File(savedDir);
        if (dir.exists()) {
            FileUtils.deleteDir(dir);
        }
        dir.mkdirs();
        //生成输出地址URL
        String outputPath = savedDir + "/" + savedName;
        File newFile = new File(outputPath);
        file.transferTo(newFile);
        return outputPath;
    }
}
