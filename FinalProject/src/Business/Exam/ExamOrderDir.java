package Business.Exam;

import java.util.ArrayList;

/**
 * @author Renzi Meng
 * @date 2019-4-16 11:35:19
 */
public class ExamOrderDir {
    ArrayList<ExamOrder> examOrderDir;

    public ExamOrderDir() {
        examOrderDir = new ArrayList<>();
    }

    public ArrayList<ExamOrder> getExamOrderList() {
        return examOrderDir;
    }

    public void setExamOrderDir(ArrayList<ExamOrder> examOrderDir) {
        this.examOrderDir = examOrderDir;
    }
}