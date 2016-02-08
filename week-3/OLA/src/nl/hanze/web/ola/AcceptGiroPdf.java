package nl.hanze.web.ola;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Graphics2D;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.Font;


public class AcceptGiroPdf {
    private static final int W=500;
    private static final int H=294;
    private static final int LINE1=63;
    private static final int LINE2=100;
    private static final int LINE3=132;
    private static final int LINE4=150;
    private static final int LINE5=168;
    private static final int LINE6=196;
    private static final int LINE7=210;
    private static final int LINE8=272;
    private static final int COLINCREMENT=19;
    private static final int COLSTART=21;
    private static final int COLBKLINE1=186;
    private static final int MAXEUROLENGTH=5;
    private static final int MAXCENTLENGTH=2;
    private static final int CENTCOLOFFSET=6;
    private static final int MAXREKNRLENGTH=10;
    private static final int GENERALOFFSET=70;
    private static final int FONTSIZE1=10;
    private static final int FONTSIZE2=14;

    private String imageDir;
    private String baseDir;

    public AcceptGiroPdf(String imageDir, String baseDir) throws Exception {
        this.imageDir = imageDir;
        this.baseDir = baseDir;
    }

    public void createPdf(AcceptGiro acceptGiro) throws Exception {
        Document document = new Document(new Rectangle(W, H));
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(baseDir+File.separatorChar + acceptGiro.getRef() + ".pdf"));
        document.open();
        PdfContentByte cb = writer.getDirectContent();
        Graphics2D g2 = cb.createGraphics(W, H);
        paint(g2, acceptGiro);
        g2.dispose();
        document.close();
    }

    public void paint(Graphics2D g2, AcceptGiro acceptGiro) throws Exception {
        BufferedImage bg=ImageIO.read(new File(imageDir+File.separatorChar+"acceptgiroeuro.jpg"));
        g2.drawImage(bg, null, 0, 0);
        g2.setFont(new Font("Arial", Font.PLAIN, FONTSIZE2));
        printAmountLine1(g2, acceptGiro);
        g2.setFont(new Font("Arial", Font.PLAIN, FONTSIZE1));
        printBKLine1(g2, acceptGiro);
        g2.setFont(new Font("Arial", Font.PLAIN, FONTSIZE2));
        printRekNrLine2(g2, acceptGiro);
        g2.setFont(new Font("Arial", Font.PLAIN, FONTSIZE1));
        printNaamLine3(g2, acceptGiro);
        printAdresLine4(g2, acceptGiro);
        printPlaatsLine5(g2, acceptGiro);
        printRekNrNaarLine6(g2, acceptGiro);
        printNaamNaarLine7(g2, acceptGiro);
        printOLALine8(g2, acceptGiro);
    }

    private void printAmountLine1(Graphics2D g2, AcceptGiro acceptGiro) {
        String euroS=prependWith(MAXEUROLENGTH, Integer.toString(acceptGiro.getEuro()), 'X');
        String centS=prependWith(MAXCENTLENGTH, Integer.toString(acceptGiro.getCent()), '0');
        for(int i=0;i<MAXEUROLENGTH;i++)
            printDigitInPigeonHole(g2, i, euroS.substring(i, i+1), LINE1);
        for(int i=0;i<MAXCENTLENGTH;i++)
            printDigitInPigeonHole(g2, i+CENTCOLOFFSET, centS.substring(i, i+1), LINE1);
    }

    private void printBKLine1(Graphics2D g2, AcceptGiro acceptGiro) {
        g2.drawString(acceptGiro.getBetalingsKenmerk(), COLBKLINE1, LINE1);
    }

    private void printRekNrLine2(Graphics2D g2, AcceptGiro acceptGiro) {
        String rekNumS=prependWith(MAXREKNRLENGTH, acceptGiro.getRekeningNummer(), ' ');
        for(int i=0;i<MAXREKNRLENGTH;i++)
            printDigitInPigeonHole(g2, i, rekNumS.substring(i, i+1), LINE2);
    }

    private void printNaamLine3(Graphics2D g2, AcceptGiro acceptGiro) {
        g2.drawString(acceptGiro.getNaam(), GENERALOFFSET, LINE3);
    }

    private void printAdresLine4(Graphics2D g2, AcceptGiro acceptGiro) {
        g2.drawString(acceptGiro.getAdresPC(), GENERALOFFSET, LINE4);
    }

    private void printPlaatsLine5(Graphics2D g2, AcceptGiro acceptGiro) {
        g2.drawString(acceptGiro.getPlaats(), GENERALOFFSET, LINE5);
    }

    private void printRekNrNaarLine6(Graphics2D g2, AcceptGiro acceptGiro) {
        g2.drawString(acceptGiro.getRekeningNummerNaar(), GENERALOFFSET, LINE6);
    }

    private void printNaamNaarLine7(Graphics2D g2, AcceptGiro acceptGiro) {
        g2.drawString(acceptGiro.getNaamNaar(), GENERALOFFSET, LINE7);
    }

    private void printOLALine8(Graphics2D g2, AcceptGiro acceptGiro) {
        g2.drawString("", GENERALOFFSET, LINE8);
    }

    private String prependWith(int length, String s, char c) {
        while(s.length()<length) {
            s=c+s;
        }
        return s;
    }

    private void printDigitInPigeonHole(Graphics2D g2, int colnumber, String digit, int y) {
        g2.drawString(digit, COLSTART+colnumber*COLINCREMENT, y);
    }
}
