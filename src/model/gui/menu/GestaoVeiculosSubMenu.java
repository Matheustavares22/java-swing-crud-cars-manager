package model.gui.menu;

import model.gui.cadastro.CadastroVeiculos;
import model.gui.consulta.ConsultarExcluirPelaPlaca;
import model.gui.consulta.ImprimirExlcuirTodos;

import javax.swing.*;
import java.awt.*;

import static model.gui.menu.GestaoVeiculos.CARGA;
import static model.gui.menu.GestaoVeiculos.PASSEIO;

public class GestaoVeiculosSubMenu extends JFrame {
    public GestaoVeiculosSubMenu(String tipoDeVeiculo){
        configuraJFrame(tipoDeVeiculo);

        setLayout(new GridLayout(4,4,10,10));

        JButton jButtonCadastrar = new JButton();
        JButton jButtonConsultarExcluirPelaPlaca = new JButton();
        JButton jButtonImprimirExcluirTodos = new JButton();
        JButton jButtonSair = new JButton();

        jButtonCadastrar.setBackground(tipoDeVeiculo.equals(PASSEIO)? Color.CYAN: Color.GREEN);
        jButtonConsultarExcluirPelaPlaca.setBackground(tipoDeVeiculo.equals(PASSEIO)? Color.CYAN: Color.GREEN);
        jButtonImprimirExcluirTodos.setBackground(tipoDeVeiculo.equals(PASSEIO)? Color.CYAN: Color.GREEN);
        jButtonSair.setBackground(Color.RED);

        JLabel jLabelCadastrar = new JLabel("Cadastrar");
        JLabel jLabelConsultarExcluirPelaPlaca = new JLabel("Consultar / Excluir pela placa");
        JLabel jLabelImprimirExcluirTodos = new JLabel("Imprimir / Excluir todos");
        JLabel jLabelSair = new JLabel("Sair");

        jLabelCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelConsultarExcluirPelaPlaca.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelImprimirExcluirTodos.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelSair.setHorizontalAlignment(SwingConstants.CENTER);

        adicionaComponentesAUI(jButtonCadastrar, jButtonConsultarExcluirPelaPlaca, jButtonImprimirExcluirTodos, jButtonSair, jLabelCadastrar, jLabelConsultarExcluirPelaPlaca, jLabelImprimirExcluirTodos, jLabelSair);

        jButtonCadastrar.addActionListener(e -> new CadastroVeiculos(tipoDeVeiculo));
        jButtonConsultarExcluirPelaPlaca.addActionListener(e -> new ConsultarExcluirPelaPlaca(tipoDeVeiculo));
        jButtonImprimirExcluirTodos.addActionListener(e -> new ImprimirExlcuirTodos(tipoDeVeiculo));
        jButtonSair.addActionListener(e -> dispose());
    }

    private void adicionaComponentesAUI(JButton jButtonCadastrar, JButton jButtonConsultarExcluirPelaPlaca, JButton jButtonImprimirExcluirTodos, JButton jButtonSair, JLabel jLabelCadastrar, JLabel jLabelConsultarExcluirPelaPlaca, JLabel jLabelImprimirExcluirTodos, JLabel jLabelSair) {
        add(jButtonCadastrar);
        add(jLabelCadastrar);

        add(jButtonConsultarExcluirPelaPlaca);
        add(jLabelConsultarExcluirPelaPlaca);

        add(jButtonImprimirExcluirTodos);
        add(jLabelImprimirExcluirTodos);

        add(jButtonSair);
        add(jLabelSair);
    }

    private void configuraJFrame(String tipoDeVeiculo) {
        setTitle("Veiculos de " + tipoDeVeiculo);
        setSize(500,150);

        Icon iconInformation = UIManager.getIcon("OptionPane.informationIcon");
        setIconImage(((ImageIcon) iconInformation).getImage());

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

}
