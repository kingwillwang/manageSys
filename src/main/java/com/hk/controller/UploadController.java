package com.hk.controller;

import com.hk.common.Result;
import com.hk.common.ResultGenerator;
import com.hk.service.UploadService;
import com.hk.service.WebsiteService;
import com.hk.util.DateUtil;
import com.hk.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/22 17:22
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    public static final String baseDir = "C:\\shoptwoImgs";

    @Autowired
    private UploadService uploadService;
    @Autowired
    private WebsiteService websiteService;

    @RequestMapping(value = "/saveImg", method = RequestMethod.POST)
    @ResponseBody
    public Result GenerateImage(@RequestParam CommonsMultipartFile file, @RequestParam("websiteName") String websiteName) {
        if (StringUtil.isNotEmpty(websiteName)) {
            Long isExist = websiteService.findWebsiteNameIsExist(websiteName);
            if (isExist > 0) {
                return ResultGenerator.genBadResult("名称已经存在！");
            }
            if (!file.isEmpty()) {
                String fileRealName = file.getOriginalFilename();                      //获得原始文件名;
                int pointIndex = fileRealName.lastIndexOf(".");                  //点号的位置
                String fileSuffix = fileRealName.substring(pointIndex + 1).toLowerCase(); //截取文件后缀
                List<String> imgTypeList = new ArrayList<String>();
                imgTypeList.add("jpg");
                imgTypeList.add("png");
                if (imgTypeList.contains(fileSuffix)) {
                    String savedFileName = UUID.randomUUID().toString().replace("-", "").concat(".").concat(fileSuffix);       //文件存取名
//                    String savedDir = request.getSession().getServletContext().getRealPath("websiteLogos") + "/" + websiteName;     //获取服务器指定文件存取路径
//                    String baseDir = "C:\\shoptwoImgs";     //对应配置里的/uploadImg
                    String secondDir = "/website/" + websiteName;
                    String imageUrl = null;
                    try {
                        imageUrl = uploadService.uploadImage(file, savedFileName, baseDir, secondDir);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return ResultGenerator.genFailResult("操作失败！");
                    }
                    return ResultGenerator.genSuccessResult(imageUrl);
                } else {
                    return ResultGenerator.genFailResult("文件类型不匹配！");
                }
            } else {
                return ResultGenerator.genBadResult("文件不存在！");
            }
        } else {
            return ResultGenerator.genBadResult("名称不能为空！");
        }
    }

    @RequestMapping(value = "/saveNewsTitleImg", method = RequestMethod.POST)
    @ResponseBody
    public Result newsTitleImage(@RequestParam CommonsMultipartFile file){
        if (!file.isEmpty()) {
            String fileRealName = file.getOriginalFilename();                      //获得原始文件名;
            int pointIndex = fileRealName.lastIndexOf(".");                  //点号的位置
            String fileSuffix = fileRealName.substring(pointIndex + 1).toLowerCase(); //截取文件后缀
            List<String> imgTypeList = new ArrayList<String>();
            imgTypeList.add("jpg");
            imgTypeList.add("png");
            if (imgTypeList.contains(fileSuffix)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                Random r = new Random();
                String imgName = "";
                if (fileSuffix.equals("jpg")) {
                    imgName = sdf.format(new Date()) + r.nextInt(100) + ".jpg";
                } else if (fileSuffix.equals("png")) {
                    imgName = sdf.format(new Date()) + r.nextInt(100) + ".png";
                } else {
                    return ResultGenerator.genFailResult("文件类型不匹配！");
                }
                String nowDate = DateUtil.formatDate(new Date(), "yyyyMMdd");
                String secondDir = "/news/" + nowDate + "/newsTitles";
                String dir = baseDir + secondDir;
                try {
                    FileUtils.writeByteArrayToFile(new File(dir, imgName), file.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                    return ResultGenerator.genFailResult("操作失败！");
                }
                String imageUrl = "/uploadImg" + secondDir + "/" + imgName;
                return ResultGenerator.genSuccessResult(imageUrl);
            } else {
                return ResultGenerator.genFailResult("文件类型不匹配！");
            }
        } else {
            return ResultGenerator.genBadResult("文件不存在！");
        }
    }

    @RequestMapping(value = "/editorImg", method = RequestMethod.POST)
    @ResponseBody
    public Result upload(@RequestParam("imgFile") MultipartFile file){
//        ServletContext sc = request.getSession().getServletContext();
//        String dir = sc.getRealPath("newsEditor");
        String nowDate = DateUtil.formatDate(new Date(), "yyyyMMdd");
        String secondDir = "/news/" + nowDate + "/newsEditor";
        String dir = baseDir + secondDir;
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        String imgName = "";
        if (type.equals("jpg")) {
            imgName = sdf.format(new Date()) + r.nextInt(100) + ".jpg";
        } else if (type.equals("png")) {
            imgName = sdf.format(new Date()) + r.nextInt(100) + ".png";
        } else if (type.equals("jpeg")) {
            imgName = sdf.format(new Date()) + r.nextInt(100) + ".jpeg";
        } else {
            return ResultGenerator.genFailResult("文件类型不匹配！");
        }
        try {
            FileUtils.writeByteArrayToFile(new File(dir, imgName), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("操作失败！");
        }
        String outUrl = "/uploadImg" + secondDir + "/" + imgName;
        return ResultGenerator.genSuccessResult(outUrl);
    }
}
