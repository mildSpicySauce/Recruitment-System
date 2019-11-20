package Business;

import Business.Account.Account;
import Business.Applicant.ApplicantDir;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemManagerRole;
import Business.WorkQueue.WorkQueue;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: 2019/4/7 14:42
 * @Copyright (C):, 2019, Renzi Meng, All Rights Reserved.
 */

public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private ApplicantDir applicants;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemManagerRole());
        return roleList;
    }

    private EcoSystem() {
        super("System");
        networkList = new ArrayList<>();
    }
    
    public boolean isCityAvabliable(String state) {
        for (Network net : this.networkList) {
            if (net.getstate().equalsIgnoreCase(state)) {
                return false;
            }
        }
        return true;
    }
    
    public ApplicantDir getApplicants() {
        return this.applicants;
    }
    
    public Account getApplicantAccountByUsername(String username) {
        for(Account account : this.getAccountDir().getAccountList()) {
            if(account.getUsername().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }

    public Network createNetwork(String state) {
        Network network = new Network(state);
        this.networkList.add(network);
        return network;
    }

    public Network getNetworkByState(String state) {
        for (Network net : this.networkList) {
            if (net.getstate().equals(state)) {
                return net;
            }
        }
        return null;
    }
    
    public Enterprise getEnterpriseById(String id) {
        for (Network net : this.networkList) {
            for (Enterprise en : net.getEnterpriseDirectory().getEnterpriseList()) {
                if(en.getId().equals(id)) {
                    return en;
                }
            }
        }
        return null;
    }

    public boolean isUserNameAvaliable(String username) {
        if (this.getAccountDir().isUsernameValid(username)) {
            for (Network net : this.networkList) {
                for (Enterprise en : net.getEnterpriseDirectory().getEnterpriseList()) {
                    if (en.getAccountDir().isUsernameValid(username)) {
                        for (Organization or : en.getOrganizationDirectory().getOrganizationList()) {
                            if (!or.getAccountDir().isUsernameValid(username)) {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
    
    public void removeNetwork(Network net) {
        Network result = null;
        if (!this.networkList.isEmpty()) {
            for (Network n : networkList) {
                if (net.getId().equalsIgnoreCase(n.getId())) {
                    result = n;
                }
            }
            networkList.remove(result);
        }
    }
}
