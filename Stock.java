
 
package simplestockviewer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;

public class Stock implements Comparable<Stock>  {
    private SimpleStringProperty Date;
    private SimpleStringProperty Open;
    private SimpleStringProperty High;
    private SimpleStringProperty Low;
    private SimpleStringProperty Close;
    private SimpleStringProperty Volume;
    private SimpleStringProperty AdjClose;

        
       
        public Stock() {
        }
        public Stock(String Date, String Open, String High,String Low, String Close, String Volume,String AdjClose) {
            this.Date = new SimpleStringProperty(Date);
            this.Open = new SimpleStringProperty(Open);
            this.High = new SimpleStringProperty(High);
            this.Low = new SimpleStringProperty(Low);
            this.Close = new SimpleStringProperty(Close);
            this.Volume = new SimpleStringProperty(Volume);
            this.AdjClose = new SimpleStringProperty(AdjClose);
            
        }
        
        public String getDate() {
            return this.Date.get();
        }

        public String getOpen() {
            return this.Open.get();
        }

        public String getHigh() {
            return this.High.get();
        }

        public void setDate(String Date) {
            this.Date.set(Date);
        }

        public void setOpen(String Open) {
            
            this.Open.set(Open);
           
        }

        public void seteHigh(String High) {
            this.High.set(High);
        }

    public String getLow() {
        return this.Low.get();
    }

    public void setLow(String Low) {
        this.Low.set(Low);
    }

    public String getClose() {
        return this.Close.get();
    }

    public void setClose(String Close) {
        this.Close.set(Close);
    }

    public String getVolume() {
        return this.Volume.get();
    }

    public void setVolume(String Volume) {
        this.Volume.set(Volume);
        
    }

    public String getAdjClose() {
        return this.AdjClose.get();
    }

    public void setAdjClose(String AdjClose) {
        this.AdjClose.set(AdjClose);
    }

    @Override
    public int compareTo(Stock o) {
         
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(getDate());
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(o.getDate());
        
            return date2.compareTo(date1);
        } catch (ParseException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
