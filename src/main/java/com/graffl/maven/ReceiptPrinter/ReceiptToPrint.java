package com.graffl.maven.ReceiptPrinter;

public class ReceiptToPrint {
	
	public ReceiptEntry[] products = null;
	
	public String receiptDate;
	
	public String totalSum;
	
	public String totalPaid;
	
	public String totalChange;
	
	public ReceiptToPrint(int numberOfProducts) {
		this.products = new ReceiptEntry[numberOfProducts];
	}
	
}
