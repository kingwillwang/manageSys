package com.hk.dao;

import com.hk.entity.Questions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/24 9:59
 */
@Repository
public interface QuestionsDao {

    public List<Questions> getQuestionList(Map<String, Object> map);

    public Long getTotalQuestions(Map<String, Object> map);

    public void addQuestion(Questions questions);

    public void updateQuestion(Questions questions);

    public void deleteQuestions(String[] ids);
}
