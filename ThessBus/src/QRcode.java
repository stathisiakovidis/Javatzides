import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

import javafx.scene.image.Image;

public class QRcode {
    private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
    
    //generate QR code as a byte array
    public static byte[] generateQRCode(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray(); 
        return pngData;
    }
    
    public static String decodeQRCode(byte[] pngData) throws FileNotFoundException, IOException, NotFoundException {
    	//Byte array to Image Object
    	BufferedImage img = ImageIO.read(new ByteArrayInputStream(pngData));
    	//Image Object to Binary Bitmap
    	BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(img)));
    	
    	//Decoding
    	Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
    	return qrCodeResult.getText();
    }
    
    public static Image printQRCode(byte[] buffer) {
    	Image img = new Image(new ByteArrayInputStream(buffer));
      
    	return img;
    }
    
    public static Image printQRCodeImage(File selectedFile) {
    	Image img = new Image(selectedFile.toURI().toString());      
    	return img;
    }
    
    //decode an image when the ticket inspector asks to
    public static String decodeQRCodeImage(String filePath) throws FileNotFoundException, IOException, NotFoundException {
    	    BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(filePath)))));
    	    Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
    	    return qrCodeResult.getText();
    }

    public static void main(String[] args) {
        try {
            generateQRCodeImage("This is my first QR Code", 350, 350, QR_CODE_IMAGE_PATH);
            generateQRCodeImage("12/12/1213:51004556", 640, 480, QR_CODE_IMAGE_PATH);
        	/*byte[] pngData = generateQRCode("This is my first QR Code", 350, 350);
            String text1 = decodeQRCode(pngData);*/
            String text1 = decodeQRCodeImage(QR_CODE_IMAGE_PATH);
            System.out.println(text1);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        } catch (NotFoundException e) {
			e.printStackTrace();
		}
    }
}