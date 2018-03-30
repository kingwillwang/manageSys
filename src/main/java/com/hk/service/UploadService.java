package com.hk.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/22 17:32
 */
public interface UploadService {

    /**
     * @param file 文件
     *             savedName 需要保存的文件名
     *             secondDir
     *             baseDir:在tomcat配置的虚拟路径存储地址
     * @return 文件最后路径
     * @author willwang
     * @date 2018/3/23 13:37
     */
    public String uploadImage(CommonsMultipartFile file, String savedName, String baseDir, String secondDir) throws IOException;
}
