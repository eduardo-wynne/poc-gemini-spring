package br.com.wynne.demo_gemini.services;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;

public class PdfReaderService {
    public static String extrairTextoDoPDF(String caminho) {
        PDDocument pdfDocument = null;
        try {
            pdfDocument = Loader.loadPDF(new RandomAccessReadBufferedFile(caminho));
            PDFTextStripper stripper = new PDFTextStripper();

            return stripper.getText(pdfDocument);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (pdfDocument != null) try {
                pdfDocument.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}