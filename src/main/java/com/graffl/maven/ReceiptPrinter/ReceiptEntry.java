package com.graffl.maven.ReceiptPrinter;

public class ReceiptEntry {
	
	public String barcode;
	
	public String name;
	
	public Long quantity;
	
	public Long price;
	
	public Long total;

	public ReceiptEntry() {
		
	}
	
	public void setQuantity(Object _obj) {
		try {
			this.quantity = (Long) _obj;
		}catch (Exception e) {
			e.printStackTrace();
			this.quantity = (long) 0;
		}
	}
	
	public void setPrice(Object _obj) {
		try {
			this.price = (Long) _obj;
		}catch (Exception e) {
			e.printStackTrace();
			this.price = (long) 0;
		}
	}
	
	public void setTotal(Object _obj) {
		try {
			this.total = (Long) _obj;
		}catch (Exception e) {
			e.printStackTrace();
			this.total = (long) 0;
		}
	}
	
}
