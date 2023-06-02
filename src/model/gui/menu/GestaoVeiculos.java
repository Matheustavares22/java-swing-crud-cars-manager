package model.gui.menu;

import javax.swing.*;
import java.awt.*;

public class GestaoVeiculos extends JFrame {

    public static final String CARGA = "Carga";
    public static final String PASSEIO = "Passeio";
    public static final String GESTAO_DE_VEICULOS = "Gestão de Veiculos";

    public GestaoVeiculos() {
        configuraJFrame();

        JLabel labelPasseio = new JLabel(" Passeio");
        JButton buttonPasseio = new JButton("");
        labelPasseio.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPasseio.setSize(50,20);
        buttonPasseio.setBackground(Color.CYAN);

        JLabel labelCarga = new JLabel(" Carga");
        labelCarga.setHorizontalAlignment(SwingConstants.CENTER);
        JButton buttonCarga = new JButton("");
        buttonCarga.setSize(20,20);
        buttonCarga.setBackground(Color.GREEN);

        setLayout(new GridLayout(2,2));

        adicionaComponentesAUI(labelPasseio, buttonPasseio, labelCarga, buttonCarga);

        setTitle(GESTAO_DE_VEICULOS);
        setSize(300,150);

        buttonCarga.addActionListener(e -> new GestaoVeiculosSubMenu(CARGA));
        buttonPasseio.addActionListener(e -> new GestaoVeiculosSubMenu(PASSEIO));
    }

    private void adicionaComponentesAUI(JLabel labelPasseio, JButton buttonPasseio, JLabel labelCarga, JButton buttonCarga) {
        add(buttonPasseio);
        add(labelPasseio);
        add(buttonCarga);
        add(labelCarga);
    }

    private void configuraJFrame() {
        Icon iconInformation = UIManager.getIcon("OptionPane.informationIcon");
        setIconImage(((ImageIcon) iconInformation).getImage());

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
