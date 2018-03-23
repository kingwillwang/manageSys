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
     *             savedDir 保存的服务器位置
     * @return 文件最后路径
     * @author willwang
     * @date 2018/3/23 13:37
     */
    public String uploadImage(CommonsMultipartFile file, String savedName, String savedDir) throws IOException;
}
