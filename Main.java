import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
         StockExchange stockExchange = new StockExchange();

         Runnable sellrunable = new SellThread(stockExchange);
         Thread sellthead= new Thread(sellrunable);

        try{
            sellthead.start();
        }catch (Exception e){
            sellthead.join();
        }


        // Create a Thread Pool of buythread of amount 10
        ExecutorService executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 10000; i++) {
            Runnable worker = new BuyThread(stockExchange);
            executor.execute(worker);

        }

        if (executor.isTerminated())
        {
            sellthead.join();
        }
        executor.shutdown();
        System.out.println("Finished all threads");
    }


}

