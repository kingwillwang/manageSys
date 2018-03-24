package com.hk.service.impl;

import com.hk.dao.QuestionsDao;
import com.hk.entity.Questions;
import com.hk.service.QuestionsService;
import com.hk.util.AntiXssUtil;
import com.hk.util.DateUtil;
import com.hk.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/24 10:10
 */
@Service("questionsService")
public class QuestionsServiceImpl implements QuestionsService {

    @Resource
    private QuestionsDao questionsDao;

    public List<Questions> getQuestionList(Map<String, Object> map) {
        return questionsDao.getQuestionList(map);
    }

    public Long getTotalQuestions(Map<String, Object> map) {
        return questionsDao.getTotalQuestions(map);
    }

    public int addQuestion(Questions questions) {
        if (StringUtil.isEmpty(questions.getQuestion())){
            return 0;//问题不能为空
        }
        questions.setId(UUID.randomUUID().toString());
        questions.setQuestion(AntiXssUtil.replaceHtmlCode(questions.getQuestion()));
        questions.setAnswer(AntiXssUtil.replaceHtmlCode(questions.getAnswer()));
        questionsDao.addQuestion(questions);
        return 1;//创建成功
    }

    public int updateQuestion(Questions questions) {
        if (StringUtil.isEmpty(questions.getQuestion())){
            return 0;//问题不能为空
        }
        questions.setQuestion(AntiXssUtil.replaceHtmlCode(questions.getQuestion()));
        questions.setAnswer(AntiXssUtil.replaceHtmlCode(questions.getAnswer()));
        questionsDao.updateQuestion(questions);
        return 1;//操作成功
    }

    public void deleteQuestions(String[] ids) {
        questionsDao.deleteQuestions(ids);
    }
}
