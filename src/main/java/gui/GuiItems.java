package gui;

import javax.swing.*;

public class GuiItems {
    private JButton startButton = new JButton("Начать");

    private ImageIcon img = new ImageIcon(getClass().getResource("logo.png"));
    private JLabel picture = new JLabel();
    private JButton level = new JButton("Уровень сложности");

    public JLabel getPicture() {
        return picture;
    }

    public ImageIcon getImg() {
        return img;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getLevel() {
        return level;
    }
}
