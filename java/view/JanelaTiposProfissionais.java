package view;

import dao.TiposProfissionaisDao;
import model.TiposProfissionais;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaTiposProfissionais implements ActionListener {
    JLabel lbnomeTipo, lbDescricao;
    JTextField tfNomeTipo, tfDescicao;
    JButton btCad, btCanc;


    public JanelaTiposProfissionais(){
        JFrame janela = new JFrame("Tipo Profissionais");
        janela.setSize(350,150); // tamanho tela
        janela.setLocationRelativeTo(null);// centro da tela

        janela.setLayout(new FlowLayout(1,20,10)); //alinhamento 0 = esquerda 1 = centro 2 = direita

        //Instanciar os componentes
        lbnomeTipo  = new JLabel("Tipo Profissional:                 ");
        lbDescricao = new JLabel("Descrição do Profissional:");
        tfNomeTipo = new JTextField(10);
        tfDescicao = new JTextField(10);

        btCad = new JButton("Cadastrar");
        btCanc = new JButton("Cancela");

        //Adicionar os botões no conteiner
        janela.add(lbnomeTipo);
        janela.add(tfNomeTipo);
        janela.add(lbDescricao);
        janela.add(tfDescicao);
        janela.add(btCad);
        janela.add(btCanc);

        //adicionando ações para os botoes
        btCad.addActionListener(this);
        btCanc.addActionListener(this);

        janela.setVisible(true); // Janela visivel
        janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btCad){
            String descricao = tfDescicao.getText();
            String nomeTipo = tfNomeTipo.getText();
            //instanciar a class
            TiposProfissionais tiposProfissionais = new TiposProfissionais(nomeTipo,descricao);
            //conectar com o banco de dados
            EntityManager em = JPAUtil.getEntityManager();
            TiposProfissionaisDao tipoProfissionalDao = new TiposProfissionaisDao(em);
            em.getTransaction().begin();
            tipoProfissionalDao.cadastrar(tiposProfissionais);
            tfNomeTipo.setText("");
            tfDescicao.setText("");
            em.getTransaction().commit();
            em.close();

            JOptionPane.showMessageDialog(null,nomeTipo+" cadastrado com sucesso!");
            tfNomeTipo.setText("");
            tfDescicao.setText("");

        }else if (e.getSource()== btCanc) {
            tfNomeTipo.setText("");
            tfDescicao.setText("");
            JOptionPane.showMessageDialog(null,"Cadastro Cancelada");
        }

    }
}
