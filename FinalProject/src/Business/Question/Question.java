package Business.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/9 11:58
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public abstract class Question {

    private int id;
    private static int counter = 0;
    private String title;
    private String content;
    
    private int score;
    private int level;
    private int type;
    
    public Question(){
        id = counter++;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public abstract List<String> getUserAnswers();
    
    public abstract void setUserAnswers(ArrayList<String> answers);
    
    public abstract List<String> getQuestionAnswer();
    
    public abstract void setQuestionAnswer(ArrayList<String> questionAnswer);
    
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        StringBuffer sb = new StringBuffer(title+"\n");
        sb.append("\n");
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if(obj==null){
            return false;
        }
        if(this==obj){
            return true;
        }
        if(obj instanceof Question){
            Question other = (Question)obj;
            return this.id == other.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return id;
    }
}
