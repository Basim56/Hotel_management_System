package org.hotel_manegement.ui;

import org.hotel_manegement.services.BookingService;
import org.hotel_manegement.services.ReportService;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import com.itextpdf.text.*;
import javax.print.Doc;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.Properties;

public class MonthlyReportUI {
    private final ReportService reportService=new ReportService();
    private final BookingService bookingService=new BookingService();
    private static int count=0;
    private static String FILE = "D:/Java/MonthlyReport.pdf";
    public  MonthlyReportUI(){
        LocalDate now = LocalDate.now();
        JFrame frame=new JFrame("Monthly Report");
        UtilDateModel utm=new UtilDateModel();
        Properties p1=new Properties();
        p1.put("text.today","Today");
        p1.put("text.month","Month");
        p1.put("text.year","Year");
        JDatePanelImpl panel=new JDatePanelImpl(utm,p1);

        UtilDateModel utm1=new UtilDateModel();
        Properties p2=new Properties();
        p2.put("text.today","Today");
        p2.put("text.month","Month");
        p2.put("text.year","Year");
        JDatePanelImpl panel1=new JDatePanelImpl(utm1,p2);

        JLabel startDate=new JLabel("Start Date");
        int year= utm.getYear();
        int month=utm.getMonth()+1;
        int day= utm.getDay();
        String startDatedp = String.format("%04d-%02d-%02d", year, month, day);

        JLabel endDate=new JLabel("End Date");
        int year1= utm1.getYear();
        int month1= utm.getMonth()+1;
        int day1= utm.getDay();
        String endDatedp=String.format("%04d-%02d-%02d",year1,month1,day1);

        JDatePickerImpl datePicker1 = new JDatePickerImpl(panel, new DateComponentFormatter());
        JDatePickerImpl datePicker2 = new JDatePickerImpl(panel1, new DateComponentFormatter());

        JLabel hotel1=new JLabel("Select Hotel") ;
        String[] hotel=reportService.Addhotel();
        JComboBox hotelbox=new JComboBox<>(hotel);
        String[][] data = null;
        String[] columns = {"ID", "H_ID", "R_ID", "C_ID", "PRICE", "A_DATE", "D_DATE", "STATUS"};

        DefaultTableModel dtm = new DefaultTableModel(data, columns);

        JTable jTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(jTable);
        sp.setBounds(30, 250, 550, 300);

        JLabel reportLabel=new JLabel();


        JButton generate=new JButton("Generate");
        JButton pdf=new JButton("Save PDF");
        JButton back=new JButton("Back");

        frame.add(startDate);
        frame.add(datePicker1);
        frame.add(endDate);
        frame.add(datePicker2);
        frame.add(hotel1);
        frame.add(hotelbox);
        frame.add(generate);;
        frame.add(pdf);
        frame.add(reportLabel);
        frame.add(sp);
        frame.add(back);
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(8,2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        generate.addActionListener(b->{
            String h = (String) hotelbox.getSelectedItem();
            String[] h_value = h.split(",");
            Integer h_id = Integer.valueOf(h_value[0]);

            LocalDate arr_date = LocalDate.of(utm.getYear(), (utm.getMonth()+1), utm.getDay());
            LocalDate dep_date = LocalDate.of(utm1.getYear(), (utm1.getMonth()+1), utm1.getDay());

            if(dep_date.isBefore(arr_date)){
                JOptionPane.showMessageDialog(frame, "Pick a valid date!!!");
            }
            else {
                String a_date = utm.getYear() + "-" + (utm.getMonth() + 1) + "-" + utm.getDay();
                String d_date = utm1.getYear() + "-" + (utm1.getMonth() + 1) + "-" + utm1.getDay();

                String[][] data2 = bookingService.MonthlyReportBooking(a_date, d_date, h_id);
                if(data2.length == 0){
                    DefaultTableModel dtm2 = new DefaultTableModel(null, columns);
                    jTable.setModel(dtm2);
                    reportLabel.setText("");
                    JOptionPane.showMessageDialog(frame, "No rooms booked in this hotel!");
                }
                else {
                    DefaultTableModel dtm2 = new DefaultTableModel(data2, columns);
                    jTable.setModel(dtm2);

                    reportLabel.setText(bookingService.getTotalPrice(a_date, d_date, h_id));
                }

            }
        });
        pdf.addActionListener(e->{
            if (jTable.getRowCount() <= 0){
                reportLabel.setText("");
                JOptionPane.showMessageDialog(frame, "No report available!!!");
            }
            else {
                count += 1;
                FILE = "D:/Java/MonthlyReport" + count + ".pdf";
                String result = reportLabel.getText();
                String a_date = utm.getYear() + "-" + (utm.getMonth() + 1) + "-" + utm.getDay();
                String d_date = utm1.getYear() + "-" + (utm1.getMonth() + 1) + "-" + utm1.getDay();
                try {
                    Document doc = new Document();
                    PdfWriter.getInstance(doc, new FileOutputStream(FILE));
                    doc.open();
                    addMetaData(doc);
                    createTable(doc, jTable, result,a_date, d_date);
                    doc.close();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                File file = new File(FILE);
                if (file.toString().endsWith(".pdf")) {
                    try {
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.open(file);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });


        back.addActionListener(b->{
            frame.dispose();
            new ReportUI();
        });









    }


    private static void addMetaData(Document document) {
        document.addTitle("Monthly Report");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }

    private static void createTable(Document document, JTable jTable, String res, String adate, String ddate) throws DocumentException {
        Anchor anchor = new Anchor("Monthly Report of Hotel : "+jTable.getValueAt(0, 1));
        anchor.setName("First Chapter");

        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph Para = new Paragraph();
        Para.add("The report is from "+adate+" till "+ddate);

        Paragraph nePara = new Paragraph();
        addEmptyLine(nePara, 3);

        PdfPTable table = new PdfPTable(4);

        PdfPCell c1 = new PdfPCell(new Phrase("H_ID"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("A_DATE"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("D_DATE"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("PRICE"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        table.setHeaderRows(1);

        for(int i=0; i<jTable.getRowCount(); i++){
            table.addCell((String) jTable.getValueAt(i, 1));
            table.addCell((String) jTable.getValueAt(i, 5));
            table.addCell((String) jTable.getValueAt(i, 6));
            table.addCell((String) jTable.getValueAt(i, 4));
        }

        catPart.add(Para);
        catPart.add(nePara);
        catPart.add(table);
        catPart.add(nePara);
        catPart.add(new Paragraph(res));

        document.add(catPart);

    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

}
