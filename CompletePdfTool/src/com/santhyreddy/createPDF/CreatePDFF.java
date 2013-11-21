package com.santhyreddy.createPDF;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.santhyreddy.constants.Constants;
import com.santhyreddy.toolMethods.ReusableMethods;

public class CreatePDFF extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String fileName = req.getParameter("pdfName");
		String fileNameWithExtension = fileName.concat(Constants.DOT_PDF_EXTENSION);
		String pdfContent = req.getParameter("pdfContent");
		if (Constants.NULL.equalsIgnoreCase(fileName) || Constants.NULL.equalsIgnoreCase(pdfContent)) 
		{
			response(resp, "Please fill missing field");
		} 
		else 
		{
			//response(resp, "Creating Pdf ... ");
			try {
				CreatePDF(fileNameWithExtension,pdfContent);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void CreatePDF(String fileNameWithExtension,String pdfContent) throws Exception{
		Document document = new Document();
		/*String content = "Santhi";
		String fileExt = ".pdf";
		String fileNameWithExtension = fileName.concat(fileExt);*/
		String filePathWithFileName = Constants.FILE_PATH.concat(fileNameWithExtension);
		if(ReusableMethods.ifFileExists(filePathWithFileName))
		{
			System.out.println("File already exists.");
		}
		else
		{
			PdfWriter.getInstance(document, 
					new FileOutputStream(fileNameWithExtension));
			//System.out.println("Pdf file created");
			document.open();
			document.add(new Paragraph(pdfContent));
			//System.out.println("added " + content + " to: "+ fileName);
			document.close();
		}
	}
	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}
}