package gui;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StartMenu extends JFrame {

    private String configPath;
    private GuiItems guiItems = new GuiItems();

    public StartMenu(String configPath) {
        this.configPath = configPath;
    }

    public void showStrarMenu() {
        loadProperties();
        drawStratApp();
        this.setVisible(true);
    }

    private void loadProperties() {

        Properties props = new Properties();
        FileInputStream in = null;
        try {

            in = new FileInputStream(configPath);
            props.load(in);
            this.setSize(Integer.parseInt((props.getProperty("frameWidth"))),
                    Integer.parseInt(props.getProperty("frameHeight")));

            in.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Неверный указанный путь к properties файлу",
                    "Ошибка",	JOptionPane.ERROR_MESSAGE);
        }

        this.setTitle("Судоку");
        this.setIconImage(new ImageIcon("C:\\Work dir\\Sudoku-master\\src\\main\\resources\\logo.png").getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }

    private void drawStratApp(){
        guiItems.getPicture().setIcon(guiItems.getImg());
        guiItems.getPicture().setBounds(410, 55, guiItems.getImg().getIconWidth(), guiItems.getImg().getIconHeight());
        this.add(guiItems.getPicture());
        guiItems.getStartButton().setBounds(10, 10, 80, 40);
        this.add(guiItems.getStartButton());
        guiItems.getLevel().setBounds(50, 60, 80, 40);
        this.add(guiItems.getLevel());
    }
}
