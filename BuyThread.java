public class BuyThread implements Runnable{

    Client client = new Client();
    Company company = new Company("lorem", 1.1F, 9.5F, 10);
    StockExchange s;

    BuyThread(StockExchange se){
        this.s = se;
    }

    @Override
    public void run() {
        System.out.println("Buy Thread Started");
        BuyShares();
    }

    private void BuyShares()
    {
        System.out.println("Registering Company");
        this.s.registerCompany(company, company.getAvailableNumberOfShares());
        this.s.addClient(client);
        System.out.println("Client added" );
        this.client.buy(company, 5);
        System.out.println("Buying " + 5 + " Shares") ;
    }
}
