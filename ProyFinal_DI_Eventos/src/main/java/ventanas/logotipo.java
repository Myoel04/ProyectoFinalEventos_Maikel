/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 *
 * @author yosoy
 */
public class logotipo extends JWindow {

    public logotipo() {
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(Color.WHITE);

        JLabel labelBienvenida = new JLabel("BIENVENIDO A EVENTOS PAUYO", SwingConstants.CENTER);
        labelBienvenida.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
        labelBienvenida.setForeground(Color.BLACK);

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/fotos/pajaroicono.png"));
        Image img = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel logoLabel = new JLabel(scaledIcon, SwingConstants.CENTER);

        content.add(labelBienvenida, BorderLayout.NORTH);
        content.add(logoLabel, BorderLayout.CENTER);


        setContentPane(content);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        logotipo log = new logotipo();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.dispose();
        new ventLogin().setVisible(true);

    }
}
