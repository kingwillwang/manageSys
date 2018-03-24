package com.hk.entity;

import java.io.Serializable;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/24 9:57
 */
public class Questions implements Serializable {

    private String id;
    private String question;
    private String answer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
