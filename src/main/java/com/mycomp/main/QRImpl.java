package com.mycomp.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
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
	public String qrReader(String qrcodeImage) throws Exception {
		BufferedImage image = ImageIO.read(new File(qrcodeImage));
		LuminanceSource luminaSource = new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(luminaSource));
		Result result = new MultiFormatReader().decode(bitmap);
		return result.getText();
		
	}

	public static void main(String[] args) throws Exception {
		QRImpl qrImpl = new QRImpl();
		//System.out.println(qrImpl.qrWritter(new AmazonPayRequestBody("diputree", "9538616959", "acc-199211")));
		System.out.println("-----------Details-------------\n");
		System.out.println(qrImpl.qrReader("/home/pradyumna/Desktop/QRCODE/myqr.png"));
	}
}
