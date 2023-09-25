package com.pdf.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdf.service.PdfService;

@RestController
@RequestMapping("/pdf")
public class PdfController {

	@Autowired
	PdfService pdfService;
	
	@GetMapping("/generate")
	public String generate() {
		return pdfService.generate();
	}
}