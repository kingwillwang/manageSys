package com.hk.controller;

import com.hk.common.Result;
import com.hk.common.ResultGenerator;
import com.hk.entity.BrandType;
import com.hk.entity.PageBean;
import com.hk.service.BrandTypeService;
import com.hk.util.AntiXssUtil;
import com.hk.util.ResponseUtil;
import com.hk.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/16
 */
@Controller
@RequestMapping("/brandType")
public class BrandTypeController {

    @Resource
    private BrandTypeService brandTypeService;

    private static final Logger log = Logger.getLogger(BrandTypeController.class);// 日志文件

    /**
     * 查询一级分类
     * @author willwang
     * @date 2018/3/19 8:43
     * @param
     * @return
     */
    @RequestMapping(value = "/firstTypeList", method = RequestMethod.POST)
    @ResponseBody
    public String firstTypeList(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows,
                       BrandType brandType, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("typeName", StringUtil.formatLike(brandType.getTypeName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<BrandType> brandTypeList = brandTypeService.findFirstBrandTypes(map);
        Long total = brandTypeService.getTotalFirstBrandType(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(brandTypeList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: brandType/firstTypeList , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 添加或修改分类
     * @author willwang
     * @date 2018/3/19 8:42
     * @param
     * @return
     */
    @RequestMapping(value = "/addOrUpdateType", method = RequestMethod.POST)
    @ResponseBody
    public Result addOrUpdate(@RequestBody BrandType brandType) {
        int resultCode = -1;
        String typeName = brandType.getTypeName().trim().toUpperCase();
        brandType.setTypeName(AntiXssUtil.replaceHtmlCode(typeName));
        if (StringUtil.isEmpty(brandType.getId())) {
            //新增
            resultCode = brandTypeService.addBrandType(brandType);
        } else {
            //修改
            resultCode = brandTypeService.updateBrandType(brandType);
        }
        if (resultCode == 1) {
            return ResultGenerator.genSuccessResult();
        } else if (resultCode == 2) {
            return ResultGenerator.genBadResult("该类型已存在！");
        } else if (resultCode == 0){
            return ResultGenerator.genBadResult("名称不能为空！");
        } else {
            return ResultGenerator.genFailResult("操作失败！");
        }
    }

    /**
     * 查询二级分类
     * @author willwang
     * @date 2018/3/19 14:57
     * @param
     * @return
     */
    @RequestMapping(value = "/secondTypeList", method = RequestMethod.POST)
    @ResponseBody
    public String secondTypeList(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows,
                                 BrandType brandType, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("typeName", StringUtil.formatLike(brandType.getTypeName()));
        map.put("pid", brandType.getPid());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<BrandType> brandTypeList = brandTypeService.findSecondBrandTypeByPid(map);
        Long total = brandTypeService.getTotalSecondBrandType(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(brandTypeList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: brandType/secondTypeList , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 删除二级分类
     * @author willwang
     * @date 2018/3/19 14:57
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteSecond/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteSecond(@PathVariable(value = "ids") String ids){
        String[] idsStr = ids.split(",");
        brandTypeService.deleteTypesById(idsStr);
        log.info("request: brandType/deleteSecond , ids: " + ids);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除一级分类
     * @author willwang
     * @date 2018/3/19 15:34
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteFirst/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteFirst(@PathVariable(value = "ids") String ids){
        String[] idsStr = ids.split(",");
        //先根据pid删除二级菜单
        brandTypeService.deleteTypesByPid(idsStr);
        log.info("request: brandType/deleteFirst/deleteSecond , pids: " + ids);
        //再删除父级菜单
        brandTypeService.deleteTypesById(idsStr);
        log.info("request: brandType/deleteFirst , ids: " + ids);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/allTypeList", method = RequestMethod.POST)
    @ResponseBody
    public List<BrandType> allTypeList(){
        List<BrandType> brandTypeList = brandTypeService.findAllBrandTypes();
        return brandTypeList;
    }
}
