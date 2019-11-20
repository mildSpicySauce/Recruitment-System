package Business.Question;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/9 12:01
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public enum QuestionType {
    Single("Single Choice"),
    Multiple("Multiple Choice");


    private String value;

    QuestionType(String s) {
        value = s;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
