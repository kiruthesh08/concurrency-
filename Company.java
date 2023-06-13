public class Company {
    private String name;
    private float totalNumberOfShares;
    private float availableNumberOfShares;
    private float price;

    public Company(){
        name="";
        totalNumberOfShares=0;
        availableNumberOfShares=0;
        price=0;
    }

    public Company(String name, float totalNumberOfShares, float availableNumberOfShares, float price){
        this.name=name;
        this.totalNumberOfShares=totalNumberOfShares;
        this.availableNumberOfShares=availableNumberOfShares;
        this.price=price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTotalNumberOfShares(float totalNumberOfShares) {
        this.totalNumberOfShares = totalNumberOfShares;
    }

    public float getTotalNumberOfShares() {
        return totalNumberOfShares;
    }

    synchronized public void setAvailableNumberOfShares(float availableNumberOfShares) {
        this.availableNumberOfShares = availableNumberOfShares;
    }

    public float getAvailableNumberOfShares() {
        return availableNumberOfShares;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}