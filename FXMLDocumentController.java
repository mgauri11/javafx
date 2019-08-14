
package simplestockviewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    public Button btnReport;
    
    @FXML
    public Button btnGraph;
    
    @FXML
    public Button btnGraph1;
    
    @FXML
    public Button btnGraph2;
    
    @FXML
    public Button btnGraph3;
    
    @FXML
    public Button btnGraph4;
    

    @FXML
    public Button btnGraph5;
    
    
    
    
    @FXML
    public ComboBox cmbCompanyName;
    @FXML
    public TextField txtSymbol;
    
     @FXML
    public TextField txtCSVFile;
    @FXML
    public TableView<Stock> tableview;
   @FXML
    public TableColumn<Stock, String> Date;
    @FXML
    public TableColumn<Stock, String> Open;
    @FXML
    public TableColumn<Stock, String> High;
    
    @FXML
    public TableColumn<Stock, String> Low;
    @FXML
    public TableColumn<Stock, String> Close;
    @FXML
    public TableColumn<Stock, String> Volume;
    @FXML
    public TableColumn<Stock, String> AdjClose;
    
     public TableView<Record> tableviewStock;
   @FXML
    public TableColumn<Record, String> StockSymbol;
    @FXML
    public TableColumn<Record, String> CompanyName;
    @FXML
    public TableColumn<Record, String> LatestPrice;
    
    
    private String[] SYMBOLS={"AHT.L","ANTO.L","BA.L",
    "BATS.L","CCH.L","CCL.L","CNA.L","CPG.L","EXPN.L","EZJ.L",
    "GKN.L","MDC.L","PFG.L","PPB.L","PRU.L","PSN.L","RB.L","RDSA.L",
    "RR.L","SDR.L","SHP.L","SKY.L","SSE.L","STJ.L","TSCO.L","TUI.L",
    "VOD.L","WPG.L"};
    
    private String[] COMPANIES={"Ashtead Group plc","Antofagasta plc",
        "BAE Systems plc","British American Tobacco plc",
    "Coca-Cola HBC AG","Carnival plc","Centrica plc",
    "Compass Group plc","Experian plc","EasyJet plc",
    "GKN plc","Medicli nic International plc","Provident Financial plc",
    "Paddy Power Betfair plc","Prudential plc","Persimmon plc",
    "Reckitt  Benckiser Group plc","Royal Dutch Shell plc",
    "Rolls-Royce Holdings plc","Schroders plc","Shire plc","Sky plc"
            ,"SSE plc","St.James's Place plc","Tesco plc","TUI AG",
            "Vodafone Group plc","Worldpay Group plc"};
    
    private String[] CSVFILES={"AHT.csv","ANTO.csv","BA.csv",
    "BATS.csv","CCH.csv","CCL.csv","CNA.csv","CPG.csv","EXPN.csv","EZJ.csv",
    "GKN.csv","MDC.csv","PFG.csv","PPB.csv","PRU.csv","PSN.csv","RB.csv","RDSA.csv",
    "RR.csv","SDR.csv","SHP.csv","SKY.csv","SSE.csv","STJ.csv","TSCO.csv","TUI.csv",
    "VOD.csv","WPG.csv"};
    
   ObservableList<Stock> dataList;
   ObservableList<Record> dataList1;
    
   final ObservableList<String> options2 = FXCollections.observableArrayList(
   "Choose","Ashtead Group plc","Antofagasta plc",
        "BAE Systems plc","British American Tobacco plc",
    "Coca-Cola HBC AG","Carnival plc","Centrica plc",
    "Compass Group plc","Experian plc","EasyJet plc",
    "GKN plc","Medicli nic International plc","Provident Financial plc",
    "Paddy Power Betfair plc","Prudential plc","Persimmon plc",
    "Reckitt Benckiser Group plc","Royal Dutch Shell plc",
    "Rolls-Royce Holdings plc","Schrod ers plc","Shire plc","Sky plc"
            ,"SSE plc","St.James's Place plc","Tesco plc","TUI AG",
            "Vodafone Group plc","Worldpay Group plc");
   
   
     // Initializes the controller class.
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        dataList = FXCollections.observableArrayList();
        dataList1 = FXCollections.observableArrayList();
        loadStock(SYMBOLS,CSVFILES,COMPANIES);
        tableviewStock.setItems(dataList1);
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Open.setCellValueFactory(new PropertyValueFactory<>("Open"));
        High.setCellValueFactory(new PropertyValueFactory<>("High"));
        Low.setCellValueFactory(new PropertyValueFactory<>("Low"));
        Close.setCellValueFactory(new PropertyValueFactory<>("Close"));
        Volume.setCellValueFactory(new PropertyValueFactory<>("Volume"));
        AdjClose.setCellValueFactory(new PropertyValueFactory<>("AdjClose"));
        
        StockSymbol.setCellValueFactory(new PropertyValueFactory<>("StockSymbol"));
        CompanyName.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));
        LatestPrice.setCellValueFactory(new PropertyValueFactory<>("LatestPrice"));
      
        
      
      cmbCompanyName.setItems(options2);
      cmbCompanyName.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
            
            txtSymbol.setText(SYMBOLS[options2.indexOf(t1)-1]);
            txtCSVFile.setText(CSVFILES[options2.indexOf(t1)-1]);
            InsertStock(CSVFILES[options2.indexOf(t1)-1]);
           
            
        }   
        });
      

        
        tableview.setItems(dataList);
        
       //report button click
        btnReport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    generateReport(SYMBOLS,CSVFILES,COMPANIES);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
        
        //generate line chart on btnGraph click 
        btnGraph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                //Defining X axis 
                final CategoryAxis xAxis = new CategoryAxis();
               
                //NumberAxis xAxis = new NumberAxis(1960, 2020, 10); 
                xAxis.setLabel("Date"); 

                //Defining y axis
                final NumberAxis yAxis = new NumberAxis();
                 
                yAxis.setLabel("Adj Close");
                
                LineChart linechart = new LineChart(xAxis, yAxis);
               
                XYChart.Series series = new XYChart.Series(); 
                series.setName("Adj Close");

                for(int i =0;i<dataList.size();i++){
                    series.getData().add(new XYChart.Data(dataList.get(i).getDate(), Float.parseFloat(dataList.get(i).getAdjClose()))); 
            
               }
                //Setting the data to Line chart    
                linechart.getData().add(series);
                
                Group root = new Group(linechart);
                
                Scene secondScene = new Scene(root, 600, 500);
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Line Chart");
                
                newWindow.setScene(secondScene);
                newWindow.show(); 
            }
        });
        
        btnGraph1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                //Defining X axis 
                final CategoryAxis xAxis = new CategoryAxis();
               
                //NumberAxis xAxis = new NumberAxis(1960, 2020, 10); 
                xAxis.setLabel("Date"); 

                //Defining y axis
                final NumberAxis yAxis = new NumberAxis();
                 
                yAxis.setLabel("Close");
                
                LineChart linechart = new LineChart(xAxis, yAxis);
               
                XYChart.Series series = new XYChart.Series(); 
                series.setName("Close");  
                for(int i =0;i<dataList.size();i++){
                    series.getData().add(new XYChart.Data(dataList.get(i).getDate(), Float.parseFloat(dataList.get(i).getClose()))); 
            
               }
                //Setting the data to Line chart    
                linechart.getData().add(series);
                
                Group root = new Group(linechart);
                
                Scene secondScene = new Scene(root, 500, 500);
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Line Chart");
                
                newWindow.setScene(secondScene);
                newWindow.show(); 
            }
        });
        
        btnGraph2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                //Defining X axis 
                final CategoryAxis xAxis = new CategoryAxis();
               
                
                xAxis.setLabel("Date"); 

                //Defining y axis
                final NumberAxis yAxis = new NumberAxis();
                 
                yAxis.setLabel("Low");
                
                LineChart linechart = new LineChart(xAxis, yAxis);
               
                XYChart.Series series = new XYChart.Series(); 
                series.setName("Low");  
                for(int i =0;i<dataList.size();i++){
                    series.getData().add(new XYChart.Data(dataList.get(i).getDate(), Float.parseFloat(dataList.get(i).getLow()))); 
            
               }
                //Setting the data to Line chart    
                linechart.getData().add(series);
                
                Group root = new Group(linechart);
                
                Scene secondScene = new Scene(root, 500, 500);
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Line Chart");
                
                newWindow.setScene(secondScene);
                newWindow.show(); 
            }
        });
        
        btnGraph3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                //Defining X axis 
                final CategoryAxis xAxis = new CategoryAxis();
               
                //NumberAxis xAxis = new NumberAxis(1960, 2020, 10); 
                xAxis.setLabel("Date"); 

                //Defining y axis
                final NumberAxis yAxis = new NumberAxis();
                 
                yAxis.setLabel("High");
                
                LineChart linechart = new LineChart(xAxis, yAxis);
               
                XYChart.Series series = new XYChart.Series(); 
                series.setName("High");  
                for(int i =0;i<dataList.size();i++){
                    series.getData().add(new XYChart.Data(dataList.get(i).getDate(), Float.parseFloat(dataList.get(i).getHigh()))); 
            
               }
                //Setting the data to Line chart    
                linechart.getData().add(series);
                
                Group root = new Group(linechart);
                
                Scene secondScene = new Scene(root, 500, 500);
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Line Chart");
                
                newWindow.setScene(secondScene);
                newWindow.show(); 
            }
        });
        
        btnGraph4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                //Defining X axis 
                final CategoryAxis xAxis = new CategoryAxis();
               
                
                xAxis.setLabel("Date"); 

                //Defining y axis
                final NumberAxis yAxis = new NumberAxis();
                 
                yAxis.setLabel("Open");
                
                LineChart linechart = new LineChart(xAxis, yAxis);
               
                XYChart.Series series = new XYChart.Series(); 
                series.setName("Open");  
                for(int i =0;i<dataList.size();i++){
                    series.getData().add(new XYChart.Data(dataList.get(i).getDate(), Float.parseFloat(dataList.get(i).getOpen()))); 
            
               }
                //Setting the data to Line chart    
                linechart.getData().add(series);
                
                Group root = new Group(linechart);
                
                Scene secondScene = new Scene(root, 500, 500);
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Line Chart");
                
                newWindow.setScene(secondScene);
                newWindow.show(); 
            }
        });
        
        btnGraph5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                //Defining X axis 
                final CategoryAxis xAxis = new CategoryAxis();
               
                
                xAxis.setLabel("Date"); 

                //Defining y axis
                final NumberAxis yAxis = new NumberAxis();
                 
                yAxis.setLabel("Volume");
                
                BarChart chart = new BarChart(xAxis, yAxis);
               
                XYChart.Series series = new XYChart.Series(); 
                series.setName("Volume");  
                for(int i =0;i<dataList.size();i++){
                    series.getData().add(new XYChart.Data(dataList.get(i).getDate(), Float.parseFloat(dataList.get(i).getVolume()))); 
            
               }
                
                
                
                
                
                //Setting the data to Line chart    
                chart.getData().add(series);
                
                Group root = new Group(chart);
                
                Scene secondScene = new Scene(root, 500, 500);
               
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Bar Chart");
                
                newWindow.setScene(secondScene);
                newWindow.show(); 
            }
        });
             
       
    }
    
    

    // load data on select company name from dropdown 
    private void InsertStock(String fileName) {
        List<Stock> row = new ArrayList<>();
        dataList.clear();
        try {
             String CsvFile = "files/"+fileName;
            String FieldDelimiter = ",";
 
            BufferedReader br;
             br = new BufferedReader(new FileReader(CsvFile));
 
            String line=br.readLine(); //skipping heading
            while ((line = br.readLine()) != null) {
               
                String[] fields = line.split(FieldDelimiter, -1);
 
                Stock record = new Stock(fields[0], fields[1],fields[2],fields[3],fields[4],fields[5],fields[6]);
                //row.add(record);
                
                dataList.add(record);
 
            }
            //sorting data date wise
            Collections.sort(dataList);
            
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
    } 
    
    //loading symbol name,company name and latest price of stock
    private void loadStock(String[] SYMBOLS,String[] CSVFILES, String[] COMPANIES) {
        
        List<Stock> records = new ArrayList<>();
        
        //traverse upto the number of csv files
        for(int i=0;i<CSVFILES.length;i++){
            try {
                 String CsvFile = "files/"+CSVFILES[i];
                String FieldDelimiter = ",";

                BufferedReader br;
                 br = new BufferedReader(new FileReader(CsvFile));

                String line=br.readLine(); //skipping heading
                while ((line = br.readLine()) != null) {
                   
                    String[] fields = line.split(FieldDelimiter, -1);

                    Stock record = new Stock(fields[0], fields[1],fields[2],fields[3],fields[4],fields[5],fields[6]);
                   
                    records.add(record);

                }
                //sorting in descending order by date
                Collections.sort(records);

            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            String LatestPrice = records.get(0).getAdjClose();
            Record r1 = new Record(SYMBOLS[i],COMPANIES[i], LatestPrice);
            dataList1.add(r1);
            records.clear();
            
        
        }
       
    } 
    //this function will generate Stock_Report.txt as report file 
    private void generateReport(String[] SYMBOLS,String[] CSVFILES, String[] COMPANIES) throws IOException {
        
        List<Stock> records = new ArrayList<>();
        String Highest = null;  //<date with the highest price of the stock>  
        String Lowest = null;  //<date with the lowest price of the stock>  
        float average_close = 0; // <average closing price of the stock> 
         FileWriter fw = null;
        try{    
           fw=new FileWriter("Stock_Report.txt"); 
            fw.write("Number,Stock Symbol,Company Name,Highest,Lowest,Average close,Close\n");
        }catch(Exception e){System.out.println(e);} 
        
        for(int i=0;i<CSVFILES.length;i++){
            float min = 0;
            float max = 0;
            try {
                 String CsvFile = "files/"+CSVFILES[i];
                String FieldDelimiter = ",";

                BufferedReader br;
                 br = new BufferedReader(new FileReader(CsvFile));

                String line=br.readLine(); //skipping heading
                int stockCount =0;
                while ((line = br.readLine()) != null) {
                    
                    String[] fields = line.split(FieldDelimiter, -1);
                    if(stockCount ==0){
                        min = Float.parseFloat(fields[6]);
                        max = Float.parseFloat(fields[6]);
                        Highest = fields[0];
                        Lowest = fields[0];  
                    }else{
                        
                        if(Float.parseFloat(fields[6]) < min){
                             Lowest = fields[0];
                        }
                        if(Float.parseFloat(fields[6]) > max){
                             Highest = fields[0];
                        }
                    
                    }
                    average_close = average_close + Float.parseFloat(fields[6]); 
                       
                    Stock record = new Stock(fields[0], fields[1],fields[2],fields[3],fields[4],fields[5],fields[6]);
                   
                    records.add(record);
                    stockCount++;

                }
                average_close = average_close / stockCount; 
                Collections.sort(records);

            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            String LatestPrice = records.get(0).getAdjClose();
            Record r1 = new Record(SYMBOLS[i],COMPANIES[i], LatestPrice);
            dataList1.add(r1);
            fw.write(" "+(i+1)+","+SYMBOLS[i]+","+COMPANIES[i]+","+Highest+","+Lowest+","+average_close+","+LatestPrice);
            fw.write("\n");
            records.clear();
           
          
        
        }
        
            
        fw.close();
        
        
       
    } 
    
    
}
