package Business.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/9 12:06
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class QuestionItem {
    private Question question;
    private int questionIndex;
    public int getQuestionIndex(){
        return questionIndex;

    }
    private List<Integer> userAnswer = new ArrayList<Integer>();

    public QuestionItem(){}



    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Integer> getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(List<Integer> userAnswer) {
        this.userAnswer = userAnswer;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    public QuestionItem(int questionIndex,Question question){
        this.questionIndex = questionIndex;
        this.question = question;
    }

    public QuestionItem(int questionIndex,Question question,List<Integer> userAnswers){
        this.question = question;
        this.questionIndex = questionIndex;
        this.userAnswer = userAnswers;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return question.toString();
    }
}

