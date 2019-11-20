package Business.Question;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/9 12:00
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class QuestionBank {
    private ArrayList<Question> questionList;

    public QuestionBank() {
        this.questionList = new ArrayList<>();
    }

    public ArrayList<Question> getOrganizationList() {
        return this.questionList;
    }

}
