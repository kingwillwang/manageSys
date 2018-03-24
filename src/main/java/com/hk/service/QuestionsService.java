package com.hk.service;

import com.hk.entity.Questions;

import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/24 10:08
 */
public interface QuestionsService {

    public List<Questions> getQuestionList(Map<String, Object> map);

    public Long getTotalQuestions(Map<String, Object> map);

    public int addQuestion(Questions questions);

    public int updateQuestion(Questions questions);

    public void deleteQuestions(String[] ids);
}
