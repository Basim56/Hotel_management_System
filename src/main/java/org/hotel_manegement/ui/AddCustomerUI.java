package org.hotel_manegement.ui;

import org.hotel_manegement.services.CustomerService;

import javax.swing.*;
import java.awt.*;

public class AddCustomerUI {
    private final CustomerService customerService=new CustomerService();
    public AddCustomerUI(){
        JFrame frame= new JFrame("Customer UI-ADD");
        JLabel namelb=new JLabel("NAME");
        JTextField nametf=new JTextField(20);
        JLabel phonelb=new JLabel("PHONE");
        JTextField phonetf=new JTextField(20);
        JLabel cniclb=new JLabel("CNIC");
        JTextField cnictf=new JTextField(20);
        JButton save=new JButton("Save");
        JButton back=new JButton("Back");
        namelb.setPreferredSize(new Dimension(250,100));
        phonelb.setPreferredSize(new Dimension(250,100));
        cniclb.setPreferredSize(new Dimension(250,100));


        frame.setLayout(new GridLayout(6,2,10,10));

        frame.add(namelb);
        frame.add(nametf);
        frame.add(phonelb);
        frame.add(phonetf);
        frame.add(cniclb);
        frame.add(cnictf);
        frame.add(save);
        frame.add(back);
        save.addActionListener((e)->{
            try {
//                int phLength=100;
                customerService.save(nametf.getText(), phonetf.getText(), cnictf.getText());
                frame.dispose();
                new CustomerUI();
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame,"Unable to Save");
            }
        });

        back.addActionListener((e)->{
            frame.dispose();
            new CustomerUI();
        });

        frame.setSize(1500,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
