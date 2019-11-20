package Business.WorkQueue;

import Business.Account.ApplicantAccount;
import Business.Enterprise.Enterprise;

/**
 * @author Renzi Meng
 * @date 2019-4-17 14:54:33
 */
public class ReviewRequest extends WorkRequest{
    int rate;
    
    public ReviewRequest(Enterprise enterprise, ApplicantAccount account) {
        super(enterprise, account);
        this.rate = -1;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

}