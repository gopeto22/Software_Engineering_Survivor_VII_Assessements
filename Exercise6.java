import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static Shop instance; // private static instance of Shop

    private List<Object> workers = new ArrayList<>(); // private List to store workers

    private Shop() {} // private constructor to prevent outside instantiation of Shop

    public static synchronized Shop getInstance() { // synchronized method to ensure thread safety
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }

    public void addWorker(Object worker) { // method to add worker to the list
        this.workers.add(worker);
    }

    public double getTurnover() { // method to calculate the shop's turnover
        double turnOver = 0.0;
        for (Object worker : this.workers) {
            if (worker instanceof SalesConsultant) {
                turnOver += ((SalesConsultant) worker).getMoney();
            } else if (worker instanceof MarketingSpecialist) {
                turnOver += ((MarketingSpecialist) worker).getBudget();
            }
        }
        return turnOver;
    }
}

class SalesConsultant {
    private double earnedMoney; // private field to store the money earned by the sales consultant

    public SalesConsultant() {
        Shop.getInstance().addWorker(this); // add the sales consultant to the list of workers in the shop
    }

    public void sellProduct(double price) { // method to sell a product
        this.earnedMoney += Math.max(price, 0);
    }

    public double getMoney() { // method to get the money earned by the sales consultant
        return this.earnedMoney;
    }
}

class MarketingSpecialist {
    private double budget = 5000.00; // private field to store the marketing specialist's budget

    public MarketingSpecialist() {
        Shop.getInstance().addWorker(this); // add the marketing specialist to the list of workers in the shop
    }

    public void spendMoney(double marketingCampaignCost) { // method to spend money on a marketing campaign
        this.budget -= Math.max(marketingCampaignCost, 0);
    }

    public double getBudget() { // method to get the marketing specialist's remaining budget
        return this.budget;
    }
}
