package com.graffl.maven.ReceiptPrinter;

public class StringConverter {
	
	public byte nextString(char nextChar) {
		byte nextByte;
		switch (nextChar) {
			case 'ă': 	nextByte = (byte) 0xa8;
						break;
			case 'â': 	nextByte = (byte) 0xa9;
						break;
			case 'ê': 	nextByte = (byte) 0xaa;
						break;
			case 'ô': 	nextByte = (byte) 0xab;
						break;
			case 'ơ': 	nextByte = (byte) 0xac;
						break;
			case 'ư': 	nextByte = (byte) 0xad;
						break;
			case 'đ': 	nextByte = (byte) 0xae;
						break;
			case 'à': 	nextByte = (byte) 0xb5;
						break;
			case 'ả': 	nextByte = (byte) 0xb6;
						break;
			case 'ã': 	nextByte = (byte) 0xb7;
						break;
			case 'á': 	nextByte = (byte) 0xb8;
						break;
			case 'ạ': 	nextByte = (byte) 0xb9;
						break;
			case 'ằ': 	nextByte = (byte) 0xbb;
						break;
			case 'ẳ': 	nextByte = (byte) 0xbc;
						break;
			case 'ẵ': 	nextByte = (byte) 0xbd;
						break;
			case 'ắ': 	nextByte = (byte) 0xbe;
						break;
			case 'ặ': 	nextByte = (byte) 0xc6;
						break;
			case 'ầ': 	nextByte = (byte) 0xc7;
						break;
			case 'ẩ': 	nextByte = (byte) 0xc8;
						break;
			case 'ẫ': 	nextByte = (byte) 0xc9;
						break;
			case 'ấ': 	nextByte = (byte) 0xca;
						break;
			case 'ậ': 	nextByte = (byte) 0xcb;
						break;
			case 'è': 	nextByte = (byte) 0xcc;
						break;
			case 'ẻ': 	nextByte = (byte) 0xce;
						break;
			case 'ẽ': 	nextByte = (byte) 0xcf;
						break;
			case 'é': 	nextByte = (byte) 0xd0;
						break;
			case 'ẹ': 	nextByte = (byte) 0xd1;
						break;
			case 'ề': 	nextByte = (byte) 0xd2;
						break;
			case 'ể': 	nextByte = (byte) 0xd3;
						break;
			case 'ễ': 	nextByte = (byte) 0xd4;
						break;
			case 'ế': 	nextByte = (byte) 0xd5;
						break;
			case 'ệ': 	nextByte = (byte) 0xd6;
						break;
			case 'ì': 	nextByte = (byte) 0xd7;
						break;
			case 'ỉ': 	nextByte = (byte) 0xd8;
						break;
			case 'ĩ': 	nextByte = (byte) 0xdc;
						break;
			case 'í': 	nextByte = (byte) 0xdd;
						break;
			case 'ị': 	nextByte = (byte) 0xde;
						break;
			case 'ò': 	nextByte = (byte) 0xdf;
						break;
			case 'ỏ': 	nextByte = (byte) 0xe1;
						break;
			case 'õ': 	nextByte = (byte) 0xe2;
						break;
			case 'ó': 	nextByte = (byte) 0xe3;
						break;
			case 'ọ': 	nextByte = (byte) 0xe4;
						break;
			case 'ồ': 	nextByte = (byte) 0xe5;
						break;
			case 'ổ': 	nextByte = (byte) 0xe6;
						break;
			case 'ỗ': 	nextByte = (byte) 0xe7;
						break;
			case 'ố': 	nextByte = (byte) 0xe8;
						break;
			case 'ộ': 	nextByte = (byte) 0xe9;
						break;
			case 'ờ': 	nextByte = (byte) 0xea;
						break;
			case 'ở': 	nextByte = (byte) 0xeb;
						break;
			case 'ỡ': 	nextByte = (byte) 0xec;
						break;
			case 'ớ': 	nextByte = (byte) 0xed;
						break;
			case 'ợ': 	nextByte = (byte) 0xee;
						break;
			case 'ù': 	nextByte = (byte) 0xef;
						break;
			case 'ủ': 	nextByte = (byte) 0xf1;
						break;
			case 'ũ': 	nextByte = (byte) 0xf2;
						break;
			case 'ú': 	nextByte = (byte) 0xf3;
						break;
			case 'ụ': 	nextByte = (byte) 0xf4;
						break;
			case 'ừ': 	nextByte = (byte) 0xf5;
						break;
			case 'ử': 	nextByte = (byte) 0xf6;
						break;
			case 'ữ': 	nextByte = (byte) 0xf7;
						break;
			case 'ứ': 	nextByte = (byte) 0xf8;
						break;
			case 'ự': 	nextByte = (byte) 0xf9;
						break;
			case 'ỳ': 	nextByte = (byte) 0xfa;
						break;
			case 'ỷ': 	nextByte = (byte) 0xfb;
						break;
			case 'ỹ': 	nextByte = (byte) 0xfc;
						break;
			case 'ý': 	nextByte = (byte) 0xfd;
						break;
			case 'ỵ': 	nextByte = (byte) 0xfe;
						break;
			default:	nextByte = (byte) nextChar;
						break;
		}
		return nextByte;
	}
}
