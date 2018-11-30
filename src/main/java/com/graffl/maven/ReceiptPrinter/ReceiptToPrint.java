package com.graffl.maven.ReceiptPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReceiptToPrint {
	
	private List<ReceiptEntry> products = null;
	
	private String receiptDate;
	
	private double totalSum;
	
	private double totalPaid;
	
	private double totalChange;
	
	private String orderId;
	
	public ReceiptToPrint() {
		
	}
	
	public void setOrderid(Object _obj) {
		this.orderId = _obj.toString();
	}
	
	public void setProducts(Object _obj) {
		this.products = new ArrayList<ReceiptEntry>();
		
		@SuppressWarnings("unchecked")
	    List<Map<String, Object>> productsConverted = (List<Map<String, Object>>) _obj;
	    
		for (Map<String, Object> prod : productsConverted) {
	      ReceiptEntry productEntry = new ReceiptEntry();
	      productEntry.barcode = prod.get("barcode").toString();
	      productEntry.name = prod.get("name").toString();
	      productEntry.quantity = (Integer) prod.get("quantity");
	      productEntry.price = (Double) prod.get("price");
		
	      this.products.add(productEntry);
		}
	}
	
	public void setReceiptDate(Object _obj) {
		this.receiptDate = _obj.toString();
	}
	
	public void setTotalSum(Object _obj) {
		try {
	    	  this.totalSum = (Double) _obj;
	    }catch (Exception e) {
	    	  System.out.println("Converting issue");
	    	  // manuell berechnen
	    	  this.totalSum = this.calculateManually();
	    }
	}
	
	public void setTotalPaid(Object _obj) {
		try {
	    	  this.totalPaid = (Double) _obj;
	    }catch (Exception e) {
	    	  System.out.println("Converting issue");
	    	  // assume same amount as invoice
	    	  this.totalPaid = this.totalSum;
	    }
	}
	
	public void setTotalChange() {
		this.totalChange = this.totalPaid - this.totalSum;
	}
	
	public double calculateManually() {
		return 1000000;
	}
	
	public void print(Printer printer) {
		printer.writeHeader();
		printer.writeLine(this.receiptDate);
		printer.writeLine(this.orderId);
		
		for(ReceiptEntry prodEntry : this.products) {
			printer.writeEntry(prodEntry);
		}
		
		printer.writeSum(this.totalSum);
		printer.writeLine("Paid: " + Double.toString(this.totalPaid));
		printer.writeLine("Change: " + Double.toString(this.totalChange));
	}
}
