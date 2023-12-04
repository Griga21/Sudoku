package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StartMenu extends JFrame {

    private String configPath;
    private GuiItems guiItems = new GuiItems();
    private Properties props = new Properties();
    private GameMap gameMap;

    public StartMenu(String configPath) {
        this.configPath = configPath;
    }

    public void showStrartMenu() {
        gameMap = new GameMap(this, guiItems);
        loadProperties();
        drawStratApp();
        addActions();
    }

    public void updateMenu(){
        drawStratApp();
    }


    private void loadProperties() {
        FileInputStream in = null;
        try {

            in = new FileInputStream(configPath);
            props.load(in);
            this.setSize(Integer.parseInt((props.getProperty("frameWidth"))),
                    Integer.parseInt(props.getProperty("frameHeight")));

            in.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Неверный указанный путь к properties файлу",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void drawStratApp() {
        this.getContentPane().setBackground(Color.WHITE);
        guiItems.getPicture().setIcon(guiItems.getImg());
        guiItems.getPicture().setBounds(Integer.parseInt((props.getProperty("frameWidth"))) / 2 - guiItems.getImg().getIconWidth() / 2,
                40, guiItems.getImg().getIconWidth(),
                guiItems.getImg().getIconHeight());
        this.add(guiItems.getPicture());
        guiItems.getStartButton().setBounds(Integer.parseInt((props.getProperty("frameWidth"))) / 2 - 40,
                guiItems.getImg().getIconHeight() + 50, 80, 40);
        this.add(guiItems.getStartButton());
        guiItems.getLevel().setBounds(Integer.parseInt((props.getProperty("frameWidth"))) / 2 - 80,
                guiItems.getImg().getIconHeight() + 110, 160, 40);
        this.add(guiItems.getLevel());

        this.setTitle("Судоку");
        this.setIconImage(new ImageIcon("logo.png").getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

    private void addActions() {
        guiItems.getStartButton().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gameMap.drawGameMap();
                    }
                }
        );
    }
}