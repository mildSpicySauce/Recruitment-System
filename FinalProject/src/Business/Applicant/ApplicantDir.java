package Business.Applicant;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/10 16:53
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class ApplicantDir {
    private ArrayList<Applicant> applicants;

    public ApplicantDir() {
        applicants = new ArrayList<>();
    }

    public ArrayList<Applicant> getApplicants() {
        return applicants;
    }

    public Applicant createApplicant(String firstName, String lastName, String email, String phone) {
        Applicant applicant = new Applicant(firstName, lastName, email, phone);
        this.applicants.add(applicant);
        return applicant;
    }
}
