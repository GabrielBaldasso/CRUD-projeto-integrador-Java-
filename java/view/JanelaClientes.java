package view;

import dao.ClientesDao;
import model.Clientes;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaClientes implements ActionListener {
    JLabel lbNomeCliente, lbEmail, lbSenha, lbContatoCliente, lbCpf;
    JTextField tfNomeCliente, tfEmail,tfContatoCliente, tfCpf;
    JPasswordField pfSenha;
    JButton btCad, btCanc;

    public JanelaClientes(){
        JFrame janela = new JFrame("Cliente");
        janela.setSize(450,180); // tamanho tela
        janela.setLocationRelativeTo(null);// centro da tela

        janela.setLayout(new FlowLayout(0,20,10)); //alinhamento 0 = esquerda 1 = centro 2 = direita

        //Instanciar os componentes
        lbNomeCliente   = new JLabel("Nome:    ");
        lbEmail  = new JLabel("Email:    ");
        lbSenha  = new JLabel("Senha:   ");
        lbContatoCliente  = new JLabel("Contato:");
        lbCpf  = new JLabel("CPF:       ");

        tfNomeCliente = new JTextField(10);
        tfEmail = new JTextField(10);
        pfSenha = new JPasswordField(10);
        tfContatoCliente = new JTextField(10);
        tfCpf = new JTextField(10);

        btCad = new JButton("Cadastrar");
        btCanc = new JButton("Cancela");

        //Adicionar os botões no conteiner
        janela.add(lbNomeCliente);
        janela.add(tfNomeCliente);
        janela.add(lbEmail);
        janela.add(tfEmail);
        janela.add(lbSenha);
        janela.add(pfSenha);
        janela.add(lbCpf);
        janela.add(tfCpf);
        janela.add(lbContatoCliente);
        janela.add(tfContatoCliente);

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
            String nomeCliente = tfNomeCliente.getText();
            String email = tfEmail.getText();
            String senha = pfSenha.getText();
            long contato = Long.parseLong(tfContatoCliente.getText());
            long cpf = Long.parseLong(tfCpf.getText());
            //instanciar a class
            Clientes clientes = new Clientes(nomeCliente, email, senha, contato, cpf);
            //conectar com o banco de dados
            EntityManager em = JPAUtil.getEntityManager();
            ClientesDao clientesDao = new ClientesDao(em);
            em.getTransaction().begin();
            clientesDao.cadastrar(clientes);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Cliente "+nomeCliente+" cadastrado com sucesso!");

            tfNomeCliente.setText("");
            tfEmail.setText("");
            pfSenha.setText("");
            tfContatoCliente.setText("");
            tfCpf.setText("");


        }else if (e.getSource()== btCanc) {
            tfNomeCliente.setText("");
            tfEmail.setText("");
            pfSenha.setText("");
            tfContatoCliente.setText("");
            tfCpf.setText("");
            JOptionPane.showMessageDialog(null,"Cadastro Cancelada");
        }

    }
}
