package view;

import dao.ServicosDao;
import model.Servicos;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JanelaServicos implements ActionListener {
    JButton btCad, btCanc;
    JLabel lbnomeServico, lbDescricaoServico, lbTempo;
    JTextField tfNomeServico, tfDescicaoServico, tfTempo;

    public JanelaServicos(){
        JFrame janela = new JFrame("Serviços");
        janela.setSize(350,180); // tamanho tela
        janela.setLocationRelativeTo(null);// centro da tela

        janela.setLayout(new FlowLayout(1,20,10)); //alinhamento 0 = esquerda 1 = centro 2 = direita

        //Instanciar os componentes
        lbnomeServico  = new JLabel("Servoço:                         ");
        lbDescricaoServico = new JLabel("Descrição do servoço:");
        lbTempo = new JLabel("Tempo de duração:       ");
        tfTempo = new JTextField(14);
        tfNomeServico = new JTextField(14);
        tfDescicaoServico = new JTextField(14);

        btCad = new JButton("Cadastrar");
        btCanc = new JButton("Cancela");

        //Adicionar os botões no conteiner
        janela.add(lbnomeServico);
        janela.add(tfNomeServico);
        janela.add(lbDescricaoServico);
        janela.add(tfDescicaoServico);
        janela.add(lbTempo);
        janela.add(tfTempo);

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
        if (e.getSource() == btCad) {
            String tempoString = tfTempo.getText();
            LocalTime tempo = LocalTime.parse(tempoString);
            String nomeServico = tfNomeServico.getText();
            String descricaoServico = tfDescicaoServico.getText();

            Servicos servicos = new Servicos(descricaoServico, nomeServico, tempo);
            EntityManager em = JPAUtil.getEntityManager();
            ServicosDao servicosDao = new ServicosDao(em);
            em.getTransaction().begin();
            servicosDao.cadastrar(servicos);
            tfNomeServico.setText("");
            tfDescicaoServico.setText("");
            tfTempo.setText("");
            em.getTransaction().commit();
            em.close();

            JOptionPane.showMessageDialog(null,nomeServico+" cadastrado com sucesso!");
            tfNomeServico.setText("");
            tfDescicaoServico.setText("");
            tfTempo.setText("");

        }else if (e.getSource()== btCanc) {
            tfNomeServico.setText("");
            tfDescicaoServico.setText("");
            tfTempo.setText("");
            JOptionPane.showMessageDialog(null,"Cadastro Cancelada");
        }
    }
}
