import java.util.HashMap;

public class Client {
    private HashMap<Company, Float> shares;
    private float balance;

    public Client(){
        shares=new HashMap<Company, Float>();
    }

    public HashMap<Company, Float> getStocks() {
        return shares;
    }

    public void setStocks(Company company, float numberOfShares) {
        shares.replace(company, numberOfShares);
    }

    synchronized public Boolean buy(Company company, float numberOfShares){
        if(balance-(numberOfShares*company.getPrice())>=0){
            if(company.getAvailableNumberOfShares()>company.getTotalNumberOfShares()){
                if (shares.containsKey(company)){
                    shares.replace(company,numberOfShares);
                    company.setTotalNumberOfShares(numberOfShares);
                }else {
                    shares.put(company,numberOfShares);
                }
                balance=balance-(numberOfShares*company.getPrice());
                return true;
            }
        }
        return false;
    }

    synchronized public Boolean sell(Company company, float numberOfShares){
        if (shares.containsKey(company)){
            if(shares.get(company)==numberOfShares){
                shares.remove(company);
            }else {
                shares.replace(company,shares.get(company)-numberOfShares);
            }
            return true;
        }
        return false;
    }

    public Boolean buyLow(Company company, float numberOfShares, float limit){

        return true;
    }

    public Boolean sellHigh(Company company, float numberOfShares, float limit){
        return true;
    }

    public Boolean deposit(float amount){

        return true;
    }

    public Boolean withdraw(float amount){
        return true;
    }
}
