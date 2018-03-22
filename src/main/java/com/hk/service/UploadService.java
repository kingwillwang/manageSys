package com.hk.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/22 17:32
 */
public interface UploadService {

    public String uploadImage(CommonsMultipartFile file, String realUploadPath) throws IOException;
}
