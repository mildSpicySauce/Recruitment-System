package Business.WorkQueue;

import Business.Account.ApplicantAccount;
import Business.Enterprise.Enterprise;
import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 15:30
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */
public class WorkQueue {

    private ArrayList<WorkRequest> workRequests;

    public WorkQueue() {
        workRequests = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequests() {
        return workRequests;
    }

    public void addRequest(WorkRequest request) {
        updateRequest(null, request);
    }

    public void deleteRequest(WorkRequest request) {
        updateRequest(request, null);
    }

    public void updateRequest(WorkRequest oldRequest, WorkRequest newRequest) {
        if (oldRequest != null && oldRequest.getAccount().getWorkQueue().getWorkRequests().contains(oldRequest)) {
            oldRequest.getAccount().getWorkQueue().getWorkRequests().remove(oldRequest);
            oldRequest.getEnterprise().getWorkQ().getWorkRequests().remove(oldRequest);
        }

        if (newRequest != null) {
            newRequest.getAccount().getWorkQueue().getWorkRequests().add(newRequest);
            newRequest.getEnterprise().getWorkQ().getWorkRequests().add(newRequest);
        }
    }

    public boolean existApply(ApplyRequest request) {
        for (WorkRequest workRequest : workRequests) {
            if (workRequest instanceof ApplyRequest) {
                ApplyRequest applyRequest = (ApplyRequest) workRequest;
                if (applyRequest.getAccount() == request.getAccount() && applyRequest.getEnterprise() == request.getEnterprise() && applyRequest.getJob() == request.getJob()) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean existReview(ReviewRequest request) {
        for (WorkRequest workRequest : workRequests) {
            if (workRequest instanceof ReviewRequest) {
                ReviewRequest reviewRequest = (ReviewRequest) workRequest;
                if (reviewRequest.getAccount() == request.getAccount() && reviewRequest.getEnterprise() == request.getEnterprise()) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean existReview(ApplicantAccount account, Enterprise enterprise) {
        for (WorkRequest workRequest : workRequests) {
            if (workRequest instanceof ReviewRequest) {
                ReviewRequest reviewRequest = (ReviewRequest) workRequest;
            if (reviewRequest.getAccount() == account && reviewRequest.getEnterprise() == enterprise) {
                return true;
            }
            }
            
        }
        return false;
    }

}
