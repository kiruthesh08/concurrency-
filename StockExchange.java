import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class StockExchange {
    private HashMap<Company, Float> companies;
    private ArrayList<Client> clients;

    public StockExchange(){
        companies=new HashMap<Company, Float>();
        clients=new ArrayList<Client>();
    }

    synchronized public Boolean registerCompany(Company company, float numberOfShares){
        companies.put(company, numberOfShares);
        return true;
    }

    synchronized public Boolean deregisterCompany(Company comp){
        if(companies.containsKey(comp)){
            companies.remove(comp);
            return true;
        }
        return false;
    }

    synchronized public Boolean addClient(Client client){
        clients.add(client);
        return true;
    }

    synchronized public Boolean remove(Client client){
        for (Iterator<Client> iterator = clients.iterator(); iterator.hasNext();) {
            Client af = iterator.next();
            if(af==client) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public HashMap<Company, Float> getCompanies() {
        return companies;
    }

    synchronized public void setPrice(Company comp,float newPrice){
        if(companies.containsKey(comp)){
            comp.setPrice(newPrice);
            companies.replace(comp,companies.get(comp));
        }else {
            System.out.println("There is no such company in the StockExchange.");
        }
    }

    synchronized public void changePriceBy(Company comp, float newPrice){
        if (companies.containsKey(comp)){
            comp.setPrice(comp.getPrice()+newPrice);
            companies.replace(comp,companies.get(comp));
        }else{
            System.out.println("There is no such company in the StockExchange.");
        }
    }
}
