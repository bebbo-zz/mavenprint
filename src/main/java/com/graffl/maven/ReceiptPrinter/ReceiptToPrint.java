package com.graffl.maven.ReceiptPrinter;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ReceiptToPrint {
	
	private List<ReceiptEntry> products = null;
	
	private String receiptDate;
	
	private long totalSum;
	
	private long totalPaid;
	
	private long totalChange;
	
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
	      productEntry.setQuantity(prod.get("quantity"));
	      productEntry.price = (Long) prod.get("price");
	      productEntry.total = (Long) prod.get("total");
		
	      this.products.add(productEntry);
		}
	}
	
	public void setReceiptDate(Object _obj) {
		this.receiptDate = _obj.toString();
	}
	
	public void setTotalSum(Object _obj) {
		try {
	    	  this.totalSum = Long.parseLong(_obj.toString());
	    }catch (Exception e) {
	    	  System.out.println("Converting issue");
	    	  // manuell berechnen
	    	  this.totalSum = this.calculateManually();
	    }
	}
	
	public void setTotalPaid(Object _obj) {
		try {
	    	  this.totalPaid = Long.parseLong(_obj.toString());
	    }catch (Exception e) {
	    	  System.out.println("Converting issue");
	    	  // assume same amount as invoice
	    	  this.totalPaid = this.totalSum;
	    }
	}
	
	public void setTotalChange(Object _obj) {
		try {
	    	  this.totalChange = Long.parseLong(_obj.toString());
	    }catch (Exception e) {
	    	  System.out.println("Converting issue");
	    	  // assume same amount as invoice
	    	  this.totalChange = 0;
	    }
	}
	
	public long calculateManually() {
		return 1000000;
	}
	
	public void print(Printer printer) {
		printer.lineFeed(10);
		printer.setVietnamese();
		
		printer.writeHeader();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateString = format.format( new Date() );
		printer.writeLine("Time: " + dateString);
		//printer.writeLine(this.receiptDate);
		printer.writeLine("Order: " + this.orderId);
		
		for(ReceiptEntry prodEntry : this.products) {
			printer.writeEntry(prodEntry);
		}
		
		printer.writeSum(this.totalSum);
		printer.writeAmount("Paid", this.totalPaid);
		printer.writeAmount("Change", this.totalChange);
		
		printer.lineFeed(10);
		printer.lineFeed(10);
		printer.lineFeed(10);
		printer.lineFeed(10);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printer.cut();
	}
}
