package com.hk.controller;

import com.hk.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/22 17:22
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/saveImg", method = RequestMethod.POST)
    public String GenerateImage(@RequestParam("image") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //根据相对路径获取绝对路径，图片上传后位于元数据中
        String realUploadPath = request.getServletContext().getRealPath("/") + "images";

        //获取上传后原图的相对地址
        String imageUrl = uploadService.uploadImage(file, realUploadPath);

        String url = request.getServletContext().getRealPath("/") + imageUrl;
        return url;
    }


}
