package com.hk.controller;

import com.hk.common.Result;
import com.hk.common.ResultGenerator;
import com.hk.entity.PageBean;
import com.hk.entity.Questions;
import com.hk.service.QuestionsService;
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
 * @Date: Created in 2018/3/24 10:21
 */
@Controller
@RequestMapping("/questions")
public class QuestionsController {

    @Resource
    private QuestionsService questionsService;

    private static final Logger log = Logger.getLogger(QuestionsController.class);// 日志文件


    @RequestMapping(value = "/questionsList", method = RequestMethod.POST)
    @ResponseBody
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows,
                       Questions questions, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("question", StringUtil.formatLike(questions.getQuestion()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Questions> questionsList = questionsService.getQuestionList(map);
        Long total = questionsService.getTotalQuestions(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(questionsList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: questions/questionsList , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Result addOrUpdate(@RequestBody Questions questions) {
        int resultCode = -1;
        if (StringUtil.isEmpty(questions.getId())) {
            //新增
            resultCode = questionsService.addQuestion(questions);
        } else {
            //修改
            resultCode = questionsService.updateQuestion(questions);
        }
        if (resultCode == 1) {
            return ResultGenerator.genSuccessResult();
        } else if (resultCode == 0){
            return ResultGenerator.genBadResult("问题不能为空！");
        } else {
            return ResultGenerator.genFailResult("操作失败！");
        }
    }

    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable(value = "ids") String ids){
        String[] idsStr = ids.split(",");
        questionsService.deleteQuestions(idsStr);
        log.info("request: questions/delete , ids: " + ids);
        return ResultGenerator.genSuccessResult();
    }
}
