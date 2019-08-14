
package simplestockviewer;

import java.util.HashSet;
import javafx.beans.property.SimpleStringProperty;


public class Record {
    private SimpleStringProperty StockSymbol;
    private SimpleStringProperty CompanyName;
    private SimpleStringProperty LatestPrice;
    public Record(String StockSymbol,String CompanyName,String LatestPrice){
        this.StockSymbol = new SimpleStringProperty(StockSymbol);
        this.CompanyName = new SimpleStringProperty(CompanyName);
        this.LatestPrice = new SimpleStringProperty(LatestPrice);
    }

    public String getStockSymbol() {
        return this.StockSymbol.get();
    }

    public void setStockSymbol(String StockSymbol) {
        this.StockSymbol.set(StockSymbol);
    }

    public String getCompanyName() {
        return this.CompanyName.get();
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName.set(CompanyName);
    }

    public String getLatestPrice() {
        return this.LatestPrice.get();
    }

    public void setLatestPrice(String LatestPrice) {
        this.LatestPrice.set(LatestPrice);
    }
    
}
