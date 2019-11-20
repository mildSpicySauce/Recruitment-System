package Business.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/9 11:58
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class SingleChoiceQuestion extends Question {

    private List<String> questionAnswer;
    private List<String> userAnswers;

    public SingleChoiceQuestion() {
        questionAnswer = new ArrayList<>();
        userAnswers = new ArrayList<>();
    }
    
    @Override
    public List<String> getUserAnswers() {
        return userAnswers;
    }

    @Override
    public void setUserAnswers(ArrayList<String> answers) {
        this.userAnswers = answers;
    }

    @Override
    public List<String> getQuestionAnswer() {
        return questionAnswer;
    }
    
    @Override
    public void setQuestionAnswer(ArrayList<String> questionAnswer) {
        this.questionAnswer = questionAnswer;
    }


}
