package com.hk.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/22 17:27
 */
public class fileUtil {

    //获取文件夹下所有文件名
    public static List<String> printFile(String path){
        File file = new File(path);
        List<String> images = new ArrayList<String>();

        // 是文件夹的话
        if (file.isDirectory()) {
            String[] fileList = file.list();
            if (fileList != null) {
                for (String aFileList : fileList) {
                    File readFile = new File(path + "/" + aFileList);
                    if (!readFile.isDirectory()) {
                        images.add(readFile.getName());
                    }
                }
            }
        }
        return images;
    }

}
