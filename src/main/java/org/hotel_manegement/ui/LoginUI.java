package org.hotel_manegement.ui;

import org.hotel_manegement.services.Authentication_admin;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {
    private final Authentication_admin admin=new Authentication_admin();
    public LoginUI(){
//        defining a frame

//        JButton button=new JButton("OK");
//        button.setBounds(100,200,150,50);
//        JLabel label= new JLabel();
//        label.setBounds(100,300,150,50);
//        JTextField textField=new JTextField();
//        textField.setBounds(100,100,200,30);
////        adding a button
//        add(textField);
//        add(button);
//        add(label);
//
//        button.addActionListener((e)->{
//            label.setText(textField.getText());
//            label.setForeground(Color.RED);
//        });
//
////        Basic Properties

        JFrame frame=new JFrame("Hotel Management System");



        JTextField admin_user=new JTextField("Email");
        admin_user.setBounds(100,100,150,30);
        JTextField admin_pass= new JTextField("Password");
        admin_pass.setBounds(100,150,150,30);

        JButton loginbtn=new JButton("Login");
        loginbtn.setBounds(100,200,100,25);

        JTextArea admin_txt=new JTextArea();
        admin_txt.setBounds(50,100,100,30);

        JTextArea pass_txt=new JTextArea();
        pass_txt.setBounds(50,150,100,30);

        frame.add(admin_user);
        frame.add(admin_pass);
        frame.add(loginbtn);

        loginbtn.addActionListener((e -> {
            if(admin.adminlogin(admin_user.getText(),admin_pass.getText())){
                frame.dispose();
                new HomeUI();
            }else {
                JOptionPane.showMessageDialog(frame,"Incorrect credentials");
            }
        }));
//basic properties
        frame.setLayout(null);
        frame.setSize(1000,1500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
