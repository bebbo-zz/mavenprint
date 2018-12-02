package com.graffl.maven.ReceiptPrinter;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
		
	      this.products.add(productEntry);
		}
	}
	
	public void setReceiptDate(Object _obj) {
		this.receiptDate = _obj.toString();
	}
	
	public void setTotalSum(Object _obj) {
		try {
	    	  this.totalSum = (Long) _obj;
	    }catch (Exception e) {
	    	  System.out.println("Converting issue");
	    	  // manuell berechnen
	    	  this.totalSum = this.calculateManually();
	    }
	}
	
	public void setTotalPaid(Object _obj) {
		try {
	    	  this.totalPaid = (Long) _obj;
	    }catch (Exception e) {
	    	  System.out.println("Converting issue");
	    	  // assume same amount as invoice
	    	  this.totalPaid = this.totalSum;
	    }
	}
	
	public void setTotalChange() {
		this.totalChange = this.totalPaid - this.totalSum;
	}
	
	public long calculateManually() {
		return 1000000;
	}
	
	public void print(Printer printer) {
		printer.lineFeed(20);
		printer.setVietnamese();
		
		try {
			printer.writeByteLine(("Mẹo: Tìm kiếm chỉ kết quả tiếng Việt.").getBytes("Cp1258"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printer.lineFeed(4);
		
		try {
			printer.writeByteLine(("Mẹo: Tìm kiếm chỉ kết quả tiếng Việt.").getBytes("ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printer.lineFeed(4);
		
		try {
			printer.writeByteLine(("Mẹo: Tìm kiếm chỉ kết quả tiếng Việt.").getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printer.lineFeed(4);
		
		//byte[] someletters = {0x1d,0x56,0x01};
		byte[] someletters2 = {(byte)0xb5,(byte)0xa9,(byte)0xf9};
		printer.writeByteLine(someletters2);
		printer.lineFeed(4);
		
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
		printer.writeLine("Paid: " + Long.toString(this.totalPaid));
		printer.writeLine("Change: " + Long.toString(this.totalChange));
		
		printer.cut();
	}
}
