package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class Portfolio {

    @Id @GeneratedValue
    @Column(name = "portfolio_id")
    private Long id;

    @Column(name = "portfolio_name")
    private String portfolioName;


    private User user;

    @OneToMany
    private List<Stock> stocks = new ArrayList<Stock>();


    // 아래부터 Getter & Setter

    public void addStock(Stock stock){
        this.stocks.add(stock);
    }


    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }
}
