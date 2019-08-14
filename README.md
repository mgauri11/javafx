# javafx
 #Info about the files.
 
The source code has four classes and one fxml document to cover all the required functionality.

The first class is Stock.java, which has csv file columns defined with get() and set() method to access them 
easily from the FXMLDocumentController.java class.

The second class is Record.java which is used to define the symbol, company name and Latest share price, defined with the
get() and set() method to access them easily from the FXMLDocumentController.java class.

The third class is FXMLDocumentController.java class, which basically has all the other classes linked with it to perform 
the main functionality.

The fourth and the last class is SimpleStockViewer.java class which has the main method to launch the application and has the
FXML document to display the designed application.

The last file is the fxml Document which has all the elements defined and given appropriate id’s to perform their tasks
to meet the functionality requirements. The elements used to design the application are Anchorpane, Tabpane, Tableview, 
Buttons, Labels and Textbox’s.

#info about the application.

The application allows the user to view the Stock details like Stock Symbol, Company Name and Latest Share Price in the form 
of tableview. The stock details are viewed inside of the tabpane and is visible immediately after running the application. 

The Stock details come from the Record.java file and main Functionality is added inside of the FXMLDocumentController.java class.

The first column has symbols for each company, the second column has the company name and the third column has the latest share
price.

The user can select the other tab from the tab pane named as stock history to view more information related to all the companies.
I have used the combobox to let the user choose particular company from the dropdown and view the details accordingly.

The user can select the company from the dropdown and the details of the corresponding company will be displayed in
the table view and also the csv file name and symbol will be displayed in the text box right below the combobox. 

The user can select the desired company from the combobox and on the right hand side of the application window.
I have given six buttons which display all the information in the form of line chart and bar chart.


 
