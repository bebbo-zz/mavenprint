package com.graffl.maven.ReceiptPrinter;

import java.util.Map;

import com.google.cloud.firestore.QueryDocumentSnapshot;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        LoadPrintRequests loadRequests = new LoadPrintRequests();
        
        Printer printer = null;
        if(loadRequests.documents.size() > 0) {
        	printer = new Printer();
        }
        
	    for (QueryDocumentSnapshot document : loadRequests.documents) {
	      Map<String, Object> doc = document.getData();
	      
	      ReceiptToPrint receipt = new ReceiptToPrint();
	      receipt.setOrderid(doc.get("orderId"));
	      receipt.setProducts(doc.get("products"));
	      receipt.setTotalSum(doc.get("totalPrice"));
	      receipt.setTotalSum(doc.get("moneyPaid"));
	      receipt.setTotalChange();
	      
	      receipt.print(printer);
	    }
        
    }
}
