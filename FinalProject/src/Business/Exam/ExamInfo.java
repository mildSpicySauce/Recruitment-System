package Business.Exam;

import Business.Account.Account;
import Business.Account.ApplicantAccount;
import Business.Question.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 15:16
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class ExamInfo {

    public int id;
    private static int counter = 0;
    private String title;
    private ApplicantAccount account;
    private int timeLimit;
    private int questionCount;
    
    public ExamInfo(String title, ApplicantAccount account , int timeLimit , int questionCount){
        id = counter++;
        this.title = title;
        this.questionCount = questionCount;
        this.timeLimit= timeLimit;
        this.account = account;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        if(account == null){
            return "no such exam";
        }
        return "examinee: "+ account.getUsername() + " " +
                "time limit: " + timeLimit + " " +
                title + " " +
                "question count:" + questionCount;

    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Account getUser() {
        return account;
    }
    public void setUser(ApplicantAccount user) {
        this.account = user;
    }
    public int getTimeLimit() {
        return timeLimit;
    }
    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
    public int getQuestionCount() {
        return questionCount;
    }
    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

}
