import javax.xml.stream.events.Comment;
import java.lang.Thread.*;

public class SellThread implements Runnable{
    Company company = new Company("lorem", 1.1F, 9.5F, 10);
    Client client = new Client();
    StockExchange s;
    SellThread(StockExchange se)
    {
        this.s=se;
    }

    @Override
    public void run() {
            System.out.println("Selling Thread");
            sellShares();
    }

    private void sellShares()
    {
        System.out.println("Registering Company");
        this.s.registerCompany(company, company.getAvailableNumberOfShares());
        this.s.addClient(client);
        System.out.println("Client added" );
        this.client.sell(company, 5);
        System.out.println("Selling " + 5 + " Shares") ;
    }
}
