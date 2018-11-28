package com.mycomp.main;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.mycomp.model.AmazonPayRequestBody;

public class QRImpl {

	public String qrWritter(AmazonPayRequestBody amazonPayRequestBody) throws Exception {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(new StringBuffer().append(amazonPayRequestBody.getAccountNumber())
				.append("\n").append(amazonPayRequestBody.getMobile()).append("\n")
				.append(amazonPayRequestBody.getUserName()).toString(), BarcodeFormat.QR_CODE, 350, 250);
		Path path = FileSystems.getDefault().getPath("/home/pradyumna/Desktop/QRCODE/myqr.png");
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG",path);
		return "QRCODE GENERATED SUCCESSFULLY";
	}

	public static void main(String[] args) throws Exception {
		QRImpl qrImpl = new QRImpl();
		System.out.println(qrImpl.qrWritter(new AmazonPayRequestBody("diputree", "9538616959", "acc-199211")));
	}
}
