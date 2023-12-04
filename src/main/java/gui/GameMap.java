package gui;

import gui.StartMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Properties;

public class GameMap {
    private Properties props = new Properties();
    private StartMenu frame;
    private GuiItems guiItems;

    public GameMap(StartMenu frame, GuiItems guiItems) throws HeadlessException {
        this.frame = frame;
        this.guiItems = guiItems;
    }

    public void drawGameMap() {
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
        guiItems.getGrid().createGrid(3);
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                guiItems.getButtonsArray()[i][j] = new JTextField();
                if (guiItems.getGrid().getTable()[i][j] == 0)
                    guiItems.getButtonsArray()[i][j].setText("");
                else
                    guiItems.getButtonsArray()[i][j].setText(String.valueOf(guiItems.getGrid().getTable()[i][j]));
                guiItems.getMap().add(guiItems.getButtonsArray()[i][j]);
            }
        addMenuBar();
    }

    private void addMenuBar(){
        guiItems.getMenuBar().add(guiItems.getMainMenu());
        guiItems.getMenuBar().add(guiItems.getSave());
        guiItems.getMenuBar().add(guiItems.getHelpMove());
        guiItems.getMenuBar().add(guiItems.getHepl());

        guiItems.getMenu().add(guiItems.getMenuBar());

        frame.getContentPane().setLayout(new BorderLayout());
        guiItems.getMap().setLayout(new GridLayout(9,9));
        frame.getContentPane().add(guiItems.getMap(), BorderLayout.CENTER);
        frame.getContentPane().add(guiItems.getMenu(), BorderLayout.NORTH);
        addActions();
    }

    private void addActions(){
        guiItems.getMainMenu().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
                frame.updateMenu();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}
