package com.hk.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author willwang
 * @date 2018/3/12 17:21
 */
public class ResponseUtil {

    public static void write(HttpServletResponse response, Object o) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
