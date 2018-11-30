package com.graffl.maven.ReceiptPrinter;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Printer {
	
	private OutputStream printer = null;
	private final String address = "192.168.178.122";
	private final int port = 9100;
	
	public static final byte[] TXT_2HEIGHT     = {0x1b,0x21,0x10}; // Double height text
	public static final byte[] TXT_2WIDTH      = {0x1b,0x21,0x20}; // Double width text
	public static final byte[] TXT_NORMAL      = {0x1b,0x21,0x00}; // Normal text
	   public static final byte[] TXT_4SQUARE     = {0x1b,0x21,0x30}; // Quad area text
	   public static final byte[] TXT_UNDERL_OFF  = {0x1b,0x2d,0x00}; // Underline font OFF
	   public static final byte[] TXT_UNDERL_ON   = {0x1b,0x2d,0x01}; // Underline font 1-dot ON
	   public static final byte[] TXT_UNDERL2_ON  = {0x1b,0x2d,0x02}; // Underline font 2-dot ON
	   public static final byte[] TXT_BOLD_OFF    = {0x1b,0x45,0x00}; // Bold font OFF
	   public static final byte[] TXT_BOLD_ON     = {0x1b,0x45,0x01}; // Bold font ON
	   public static final byte[] TXT_FONT_A      = {0x1b,0x4d,0x48}; // Font type A
	   public static final byte[] TXT_FONT_B      = {0x1b,0x4d,0x01};// Font type B
	   public static final byte[] TXT_ALIGN_LT    = {0x1b,0x61,0x00}; // Left justification
	   public static final byte[] TXT_ALIGN_CT    = {0x1b,0x61,0x01}; // Centering
	   public static final byte[] TXT_ALIGN_RT    = {0x1b,0x61,0x02}; // Right justification
	   
	   public static final byte[] BARCODE_EAN13   = {0x1d,0x6b,0x02}; // Barcode type EAN13
	   
	   public static final byte[] LINE_SPACE_24   = {0x1b,0x33,24}; // Set the line spacing at 24
	   public static final byte[] LINE_SPACE_30   = {0x1b,0x33,30}; // Set the line spacing at 30
	   
	   public static final byte[] CTL_LF          = {0x0a};          // Print and line feed
	   
	   public static final String CARRIAGE_RETURN = System.getProperty("line.separator");
	
	public Printer() {
		try {
	         Socket socket = new Socket(this.address, this.port);
	        // socket.setSoTimeout(1000);
	         this.printer = socket.getOutputStream();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}
	
	public void writeLine(String text) {
		try {
			this.printer.write((text + CARRIAGE_RETURN).getBytes());
		} catch (IOException e) {
	         e.printStackTrace();
	    }
	}
	
	public void write(String text) {
		try {
			this.printer.write(text.getBytes());
		} catch (IOException e) {
	         e.printStackTrace();
	    }
	}
	
	public void writeHeader() {
		try {
			this.printer.write(TXT_BOLD_ON);
			this.printer.write(TXT_2HEIGHT);
			this.printer.write(TXT_2WIDTH);
			this.printer.write(TXT_FONT_A);
			this.printer.write(TXT_ALIGN_CT);
			this.writeLine("HANG DUC");
			this.printer.write(TXT_BOLD_OFF);
			this.printer.write(TXT_NORMAL);
			this.printer.write(TXT_FONT_B);
			this.printer.write(TXT_ALIGN_RT);
		} catch (IOException e) {
	         e.printStackTrace();
	    }
	}
	
	public void writeEntry(ReceiptEntry prod) {
		this.write(Integer.toString(prod.quantity));
		this.write(" X ");
		this.writeLine(Double.toString(prod.price));
		
		// write name
		if(prod.name.length() > 24) {
			this.write(prod.name.substring(0, 24));
		} else {
			this.write(prod.name);
			this.write(this.getNspaces(24 - prod.name.length()));
		}
		this.writeLine(" ");
	}
	
	public void writeSum(double amount) {
		try {
			this.printer.write(TXT_BOLD_ON);
			this.printer.write(TXT_2WIDTH);
			this.writeLine("Total Sum: " + Double.toString(amount));
			this.printer.write(TXT_BOLD_OFF);
			this.printer.write(TXT_NORMAL);
		} catch (IOException e) {
	         e.printStackTrace();
	    }
	}
	
	private String getNspaces(int n) {
		StringBuffer outputBuffer = new StringBuffer(n);
		for (int i = 0; i < n; i++){
		   outputBuffer.append(" ");
		}
		return outputBuffer.toString();
	}
}
