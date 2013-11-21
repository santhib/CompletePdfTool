package com.santhyreddy.createPDF;



import com.santhyreddy.toolMethods.*;
import java.io.FileOutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class CreatePDF {
	public CreatePDF(String fileName) throws Exception{
		Document document = new Document();
		String content = "Santhi";
		String fileExt = ".pdf";
		String fileNameWithExtension = fileName.concat(fileExt);
		String filePathString = "C:/Documents and Settings/cvr921/My Documents/San/tools/"+fileNameWithExtension;
		if(ReusableMethods.ifFileExists(filePathString))
		{
			System.out.println("File already exists.");
		}
		else
		{
			PdfWriter.getInstance(document, 
					new FileOutputStream(fileNameWithExtension));
			System.out.println("Pdf file created");
			document.open();
			document.add(new Paragraph(content));
			System.out.println("added " + content + " to: "+ fileName);
			document.close();
		}
	}

	public static void main(String args[]){
		try{
			new CreatePDF("santhi5");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
