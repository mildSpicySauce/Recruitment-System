package Business.Enterprise;

/**
 * @author Renzi Meng
 * @date 2019-4-16 17:03:06
 */
public class EnterpriseFactory {
    public static Enterprise createEnterprise(String name, EnterpriseType type) {
        if (type.equals(EnterpriseType.IT)) {
            ITEnterprise r = new ITEnterprise(name);
            r.createOrganizations();
            return r;
        }
        if (type.equals(EnterpriseType.Bank)) {
            BankEnterprise s = new BankEnterprise(name);
            s.createOrganizations();
            return s;
        }
        return null;
    }
}