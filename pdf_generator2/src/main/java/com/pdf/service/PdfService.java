package com.pdf.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

@Service
public class PdfService {

	public String generate() {
		String path = "C:/Users/Admin/Desktop/PdfGeneration/demo1.pdf";
		Font title = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14f, Font.BOLD, BaseColor.BLACK);
		Font content = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14f, Font.NORMAL, BaseColor.BLACK);
		Document document = new Document();
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path));
			CustomPageHelper customPageHelper = new CustomPageHelper();
			pdfWriter.setPageEvent(customPageHelper);
			
			document.open();
			
			PdfPTable pdfPTable = new PdfPTable(1);
			pdfPTable.setWidthPercentage(100);
			PdfPCell pdfPCell = new PdfPCell();
			pdfPCell.setFixedHeight(25);
			Paragraph bookingDate = new Paragraph();
			bookingDate.add(new Phrase("Booking Date : ", title));
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMM  dd,  yyyy");
			String date = dateFormat.format(new Date());
			bookingDate.add(new Phrase(date, content));
			pdfPCell.addElement(bookingDate);
			pdfPTable.addCell(pdfPCell);
			document.add(pdfPTable);
			
			PdfPTable pdfPTable2 = new PdfPTable(2);
			pdfPTable2.setWidthPercentage(100);
			float[] orderWidths = {60,40}; 
			pdfPTable2.setWidths(orderWidths);
			PdfPCell pdfPCell2 = new PdfPCell();
			Paragraph orderId = new Paragraph("Order ID", title);
			orderId.setFirstLineIndent(10);
			Paragraph orderId2 = new Paragraph("123", content);
			orderId2.setFirstLineIndent(20);
			Paragraph nextLine = new Paragraph(" ");
			pdfPCell2.addElement(nextLine);
			pdfPCell2.addElement(orderId);
			pdfPCell2.addElement(orderId2);
			pdfPCell2.addElement(nextLine);
			Paragraph ticketId = new Paragraph("Ticket ID", title);
			ticketId.setFirstLineIndent(10);
			Paragraph ticketId2 = new Paragraph("123", content);
			ticketId2.setFirstLineIndent(20);
			pdfPCell2.addElement(ticketId);
			pdfPCell2.addElement(ticketId2);
			pdfPCell2.addElement(nextLine);
			Paragraph ticketClass = new Paragraph("Ticket Class", title);
			ticketClass.setFirstLineIndent(10);
			Paragraph ticketClass2 = new Paragraph("abc", content);
			ticketClass2.setFirstLineIndent(20);
			pdfPCell2.addElement(ticketClass);
			pdfPCell2.addElement(ticketClass2);
			pdfPCell2.addElement(nextLine);
			Image qr = Image.getInstance("images\\qr.png");
			qr.scaleToFit(200, 300);
			qr.setAlignment(Element.ALIGN_RIGHT);
			PdfPCell pdfPCell3 = new PdfPCell();
			pdfPCell3.addElement(qr);
			pdfPCell2.setBorderWidthRight(0);
			pdfPCell3.setBorderWidthLeft(0);
			pdfPTable2.addCell(pdfPCell2);
			pdfPTable2.addCell(pdfPCell3);
			document.add(pdfPTable2);
			
			PdfPTable pdfPTable3 = new PdfPTable(2);
			pdfPTable3.setWidthPercentage(100);
			float[] eventWidths = {60,40}; 
			pdfPTable3.setWidths(eventWidths);
			PdfPCell pdfPCell4 = new PdfPCell();
			pdfPCell4.setBorderWidthRight(0);
			
			Paragraph eventDetails = new Paragraph("Event Details : ", title);
			eventDetails.setFirstLineIndent(10);
			pdfPCell4.addElement(eventDetails);
			Paragraph eventName = new Paragraph("XYZ", content);
			eventName.setFirstLineIndent(20);
			eventName.setSpacingAfter(5);
			pdfPCell4.addElement(eventName);
			
			PdfPTable pdfPTable4 = new PdfPTable(3);
			pdfPTable4.setHorizontalAlignment(Element.ALIGN_LEFT);
			float[] iconsWidths = {0.25f,0.5f,4};
			pdfPTable4.setWidths(iconsWidths);
			PdfPCell emptyCell = new PdfPCell();
			emptyCell.setBorder(0);
			PdfPCell icons = new PdfPCell();
			icons.setBorderWidth(0);
			Image calendar = Image.getInstance("images\\calendar.png");
			calendar.setSpacingBefore(9);
			calendar.scaleToFit(15, 15);
			calendar.setAlignment(Element.ALIGN_MIDDLE);
			icons.addElement(calendar);
			Image clock = Image.getInstance("images\\clock.png");
			clock.setSpacingBefore(7);
			clock.scaleToFit(15, 15);
			clock.setAlignment(Element.ALIGN_MIDDLE);
			icons.addElement(clock);
			Image location = Image.getInstance("images\\location.png");
			location.setSpacingBefore(5);
			location.scaleToFit(15, 15);
			location.setAlignment(Element.ALIGN_MIDDLE);
			icons.addElement(location);
			PdfPCell iconDetails = new PdfPCell();
			iconDetails.setBorderWidth(0);
			Paragraph calendarDetails = new Paragraph("calendar", content);
			iconDetails.addElement(calendarDetails);
			Paragraph clockDetails = new Paragraph("clock", content);
			iconDetails.addElement(clockDetails);
			Paragraph locationDetails = new Paragraph("location", content);
			locationDetails.setSpacingAfter(5);
			iconDetails.addElement(locationDetails);
			pdfPTable4.addCell(emptyCell);
			pdfPTable4.addCell(icons);
			pdfPTable4.addCell(iconDetails);
			pdfPCell4.addElement(pdfPTable4);
			pdfPTable3.addCell(pdfPCell4);
			
			Image event = Image.getInstance("images\\diksha.jpg");
			event.setAlignment(Element.ALIGN_RIGHT);
			event.scaleToFit(170, 200);
			
			PdfPCell pdfPCell5 = new PdfPCell(event, false);
			pdfPCell5.setBorderWidthLeft(0);
			pdfPCell5.addElement(event);
			pdfPCell5.setPadding(20);
			pdfPCell5.setPaddingTop(30);
			pdfPTable3.addCell(pdfPCell5);
			
			document.add(pdfPTable3);
			
			PdfPTable paymentTable = new PdfPTable(1);
			paymentTable.setWidthPercentage(100);
			PdfPCell paymentCell = new PdfPCell();
			Paragraph paymentSummary = new Paragraph("Payment Summary :", title);
			paymentSummary.setFirstLineIndent(10);
			Paragraph subtotal = new Paragraph("Ticket Subtotal", content);
			subtotal.setFirstLineIndent(20);
			paymentCell.addElement(paymentSummary);
			paymentCell.addElement(subtotal);
			
			PdfPTable ordersTable = new PdfPTable(3);
			ordersTable.setSpacingBefore(-5);
			ordersTable.setWidthPercentage(100);
			float[] ordersWidths = {3.5f, 79.5f,17};
			ordersTable.setWidths(ordersWidths);
			PdfPCell orders1stCell = new PdfPCell();
			orders1stCell.setBorder(0);
			PdfPCell orders2ndCell = new PdfPCell();
			orders2ndCell.setBorder(0);
			Paragraph Order1st = new Paragraph("1st item", content);
			orders2ndCell.addElement(Order1st);
			Paragraph Order2nd = new Paragraph("2nd item", content);
			Order2nd.setSpacingAfter(3);
			orders2ndCell.addElement(Order2nd);
			PdfPCell orders3rdCell = new PdfPCell();
			orders3rdCell.setBorder(0);
			BigDecimal amount = new BigDecimal("100.00");
			String amountString = "Inr.  "+String.valueOf(amount);
			Paragraph Order1stamount = new Paragraph(amountString, content);
			orders3rdCell.addElement(Order1stamount);
			BigDecimal amount2 = new BigDecimal("100.00");
			String amountString2 = "Inr.  "+String.valueOf(amount2);
			Paragraph Order2ndamount = new Paragraph(amountString2, content);
			orders3rdCell.addElement(Order2ndamount);
			ordersTable.addCell(orders1stCell);
			ordersTable.addCell(orders2ndCell);
			ordersTable.addCell(orders3rdCell);
			paymentCell.addElement(ordersTable);
			LineSeparator lineSeparator = new LineSeparator(1, 93.5f, null, Element.ALIGN_CENTER, 0);
			paymentCell.addElement(lineSeparator);
			
			PdfPTable totalAmountTable = new PdfPTable(2);
			totalAmountTable.setSpacingBefore(-5);
			totalAmountTable.setSpacingAfter(15);
			totalAmountTable.setWidthPercentage(100);
			float[] totalAmountWidths = {83.5f,17.5f};
			totalAmountTable.setWidths(totalAmountWidths);
			PdfPCell totalAmountCell = new PdfPCell();
			totalAmountCell.setBorder(0);
			Paragraph totalAmountpara = new Paragraph("Total Amount", title);
			totalAmountpara.setFirstLineIndent(10);
			totalAmountCell.addElement(totalAmountpara);
			totalAmountTable.addCell(totalAmountCell);
			PdfPCell totalAmountCal = new PdfPCell();
			totalAmountCal.setBorder(0);
			BigDecimal totalAmount = amount.add(amount2);
			String totalAmountString = "Inr.  "+totalAmount;
			Paragraph totalAmount2 = new Paragraph(totalAmountString, title);
			totalAmountCal.addElement(totalAmount2);
			totalAmountTable.addCell(totalAmountCal);
			paymentCell.addElement(totalAmountTable);
			
            paymentTable.addCell(paymentCell);
			document.add(paymentTable);

			document.close();
			
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
			System.out.println("file not created");
			return "file not created";
		}
		return "file created successfully";
	}

}

class CustomPageHelper extends PdfPageEventHelper{
	Font title = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14f, Font.BOLD, BaseColor.WHITE);
	Font content = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12f, Font.NORMAL, BaseColor.WHITE);
	
	public void onStartPage(PdfWriter pdfWriter, Document document) {
		try {
			Image logo = Image.getInstance("images\\diksha.jpg");
			PdfPTable pdfPTable = new PdfPTable(1);
			pdfPTable.setWidthPercentage(100);
			PdfPCell pdfPCell = new PdfPCell(logo, false);
			logo.scaleToFit(200, 215);
			logo.setAlignment(Element.ALIGN_CENTER);
			pdfPCell.setFixedHeight(70);
			pdfPCell.setPadding(5);
			pdfPCell.addElement(logo);
			pdfPTable.addCell(pdfPCell);
			document.add(pdfPTable);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
			System.out.println("error");
		}
	}
	
	public void onEndPage(PdfWriter pdfWriter, Document document) {

		try {
		PdfPTable informationTable = new PdfPTable(2);
		informationTable.setWidthPercentage(100);
		float[] coulmnWidths = {60,40};
		informationTable.setWidths(coulmnWidths);
		PdfPCell informationCell = new PdfPCell();
		informationCell.setBorder(0);
		informationCell.setBackgroundColor(BaseColor.DARK_GRAY);
		Paragraph information = new Paragraph("Information", title);
		information.setFirstLineIndent(40);
		information.setSpacingAfter(5);
		informationCell.addElement(information);
		
		PdfPTable iconsTable = new PdfPTable(3);
		iconsTable.setWidthPercentage(100);
		float[] iconsColumnWidths = {13,8,79};
		iconsTable.setWidths(iconsColumnWidths);
		PdfPCell emptyCell = new PdfPCell();
		emptyCell.setBorder(0);
		iconsTable.addCell(emptyCell);
		PdfPCell iconsCell = new PdfPCell();
		iconsCell.setBorder(0);
		Image phone = Image.getInstance("images\\phone.png");
		phone.setAlignment(Element.ALIGN_CENTER);
		phone.scaleToFit(15, 15);
		phone.setSpacingBefore(5);
		iconsCell.addElement(phone);
		Image whatsapp = Image.getInstance("images\\whatsapp.png");
		whatsapp.setAlignment(Element.ALIGN_CENTER);
		whatsapp.scaleToFit(15, 15);
		whatsapp.setSpacingBefore(5);
		iconsCell.addElement(whatsapp);
		Image mail = Image.getInstance("images\\mail.png");
		mail.setAlignment(Element.ALIGN_CENTER);
		mail.scaleToFit(15, 15);
		mail.setSpacingBefore(5);
		iconsCell.addElement(mail);
		Image website = Image.getInstance("images\\website.png");
		website.setAlignment(Element.ALIGN_CENTER);
		website.scaleToFit(15, 15);
		website.setSpacingBefore(5);
		iconsCell.addElement(website);
		iconsTable.addCell(iconsCell);
		PdfPCell iconsDetailsCell = new PdfPCell();
		iconsDetailsCell.setBorder(0);
		Paragraph phone2 = new Paragraph("123", content);
		iconsDetailsCell.addElement(phone2);
		Paragraph whatsapp2 = new Paragraph("1234567890", content);
		iconsDetailsCell.addElement(whatsapp2);
		Paragraph mail2 = new Paragraph("customercare@pay.aw", content);
		mail2.setSpacingBefore(2);
		iconsDetailsCell.addElement(mail2);
		Paragraph website2 = new Paragraph("pay.aw", content);
		website2.setSpacingAfter(4);
		iconsDetailsCell.addElement(website2);
		iconsTable.addCell(iconsDetailsCell);
		iconsTable.setSpacingAfter(15);
		informationCell.addElement(iconsTable);
		informationTable.addCell(informationCell);
		
		PdfPCell socialCell = new PdfPCell();
		socialCell.setBorder(0);
		socialCell.setBackgroundColor(BaseColor.DARK_GRAY);
		Paragraph social = new Paragraph("Social", title);
		social.setAlignment(Element.ALIGN_CENTER);
		social.setSpacingAfter(5);
		socialCell.addElement(social);
		float[] socialTablewidths = {30,30,30};
		PdfPTable socialTable = new PdfPTable(socialTablewidths);
		PdfPCell facebookCell = new PdfPCell();
		facebookCell.setBorder(0);
		Image facebook = Image.getInstance("images\\facebook.png");
		facebook.setAlignment(Element.ALIGN_RIGHT);
		facebook.scaleToFit(30, 30);
		facebookCell.addElement(facebook);
		socialTable.addCell(facebookCell);
		PdfPCell youtubeCell = new PdfPCell();
		youtubeCell.setBorder(0);
		Image youtube = Image.getInstance("images\\youtube.png");
		youtube.setAlignment(Element.ALIGN_CENTER);
		youtube.scaleToFit(30, 30);
		youtubeCell.addElement(youtube);
		socialTable.addCell(youtubeCell);
		PdfPCell instaCell = new PdfPCell();
		instaCell.setBorder(0);
		Image insta = Image.getInstance("images\\insta.png");
		insta.setAlignment(Element.ALIGN_LEFT);
		insta.scaleToFit(30, 30);
		instaCell.addElement(insta);
		socialTable.addCell(instaCell);
		socialCell.addElement(socialTable);
		
		informationTable.addCell(socialCell);
		document.add(informationTable);
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
