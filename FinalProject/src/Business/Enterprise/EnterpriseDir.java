package Business.Enterprise;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 15:08
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class EnterpriseDir {
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDir() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void removeEnterprise(Enterprise en) {
        Enterprise result = null;
        if (!enterpriseList.isEmpty()) {
            for (Enterprise ent : enterpriseList) {
                if (ent.getId().equalsIgnoreCase(en.getId())) {
                    result = ent;
                }
            }
            enterpriseList.remove(result);
        }
    }
    
    public void addEnterprise(Enterprise en){
        enterpriseList.add(en);
    }

}
