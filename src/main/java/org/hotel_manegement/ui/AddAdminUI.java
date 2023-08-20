package org.hotel_manegement.ui;

import org.hotel_manegement.domain.Admin;
import org.hotel_manegement.services.AdminService;

import javax.swing.*;
import java.awt.*;

public class AddAdminUI {

    private static AdminService adminService=new AdminService();
    public AddAdminUI() {
        JFrame frame = new JFrame("Admin UI-ADD");
        JLabel firstNamelb = new JLabel("FIRST NAME");
        JTextField firstNametf = new JTextField(20);
        JLabel lastNamelb = new JLabel("LAST NAME");
        JTextField lastNametf = new JTextField(20);
        JLabel emaillb = new JLabel("EMAIL");
        JTextField emailtf = new JTextField(20);
        JLabel passwordlb=new JLabel("Password");
        JTextField passwordtf=new JTextField(20);
        JButton save = new JButton("Save");
        JButton back = new JButton("Back");



        frame.setLayout(new GridLayout(6, 2, 10, 10));

        frame.add(firstNamelb);
        frame.add(firstNametf);
        frame.add(lastNamelb);
        frame.add(lastNametf);
        frame.add(emaillb);
        frame.add(emailtf);
        frame.add(passwordlb);
        frame.add(passwordtf);
        frame.add(save);
        frame.add(back);

        save.addActionListener((e) -> {
            try {
//                int phLength=100;
                adminService.insert(firstNametf.getText(), lastNametf.getText(), emailtf.getText(),passwordtf.getText());
                frame.dispose();
                new AdminUI();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Unable to Save");
            }
        });

        back.addActionListener((e) -> {
            frame.dispose();
            new AdminUI();
        });

        frame.setSize(900, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
