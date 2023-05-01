package org.CoreOne.Chapter2.Graphics;

import org.example.Main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ImageViewerFrame extends JFrame {

    private JLabel label;
    private JFileChooser jFileChooser;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HIGHT = 400;

    public ImageViewerFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HIGHT);

        label = new JLabel();
        add(label);

        jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("."));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);

        openItem.addActionListener(event -> {
            int result = jFileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                String name = jFileChooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> {
            System.exit(0);
        });
    }
}
