package view;

import dao.ProfissionaisDao;
import dao.TiposProfissionaisDao;
import model.Profissionais;
import model.TiposProfissionais;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JanelaProfissionais implements ActionListener {
    JButton btCad, btCanc;
    JLabel lbNomeProfissionais, lbEmail, lbSenha, lbContato, lbTipoProfissional;
    JTextField tfNomeProfissionais, tfEmail, tfContato;
    String [] tipoProfissional;
    JComboBox cbxTipoProfissional;
    JPasswordField pfSenha;



    public JanelaProfissionais(){
        JFrame janela = new JFrame("Profissionais");
        janela.setSize(300,300); // tamanho tela
        janela.setLocationRelativeTo(null);// centro da tela

        janela.setLayout(new FlowLayout(1,20,10)); //alinhamento 0 = esquerda 1 = centro 2 = direita

        //Instanciar os componentes
        lbNomeProfissionais = new JLabel("Profissional:");
        lbEmail = new JLabel("Email:            ");
        lbSenha = new JLabel("Senha:           ");
        lbContato = new JLabel("Contato:        ");
        lbTipoProfissional = new JLabel("Tipo de Profissional:");
        tfNomeProfissionais = new JTextField(15);
        tfEmail = new JTextField(15);
        pfSenha = new JPasswordField(15);
        tfContato = new JTextField(15);

        //carregar a string na cbxTipoProfissional
        carregarTipoProfissional();
        cbxTipoProfissional = new JComboBox(tipoProfissional);

        btCad = new JButton("Cadastrar");
        btCanc = new JButton("Cancela");

        //Adicionar os botões no conteiner
        janela.add(lbNomeProfissionais);
        janela.add(tfNomeProfissionais);
        janela.add(lbEmail);
        janela.add(tfEmail);
        janela.add(lbSenha);
        janela.add(pfSenha);
        janela.add(lbContato);
        janela.add(tfContato);
        janela.add(lbTipoProfissional);
        janela.add(cbxTipoProfissional);
        janela.add(btCad);
        janela.add(btCanc);

        //adicionando ações para os botoes
        btCad.addActionListener(this);
        btCanc.addActionListener(this);

        janela.setVisible(true); // Janela visivel
        janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void carregarTipoProfissional(){
        EntityManager em = JPAUtil.getEntityManager();
        TiposProfissionaisDao tiposProfissionaisDao = new TiposProfissionaisDao(em);
        List<TiposProfissionais> todos = tiposProfissionaisDao.buscarTodos();
        int numReg = todos.size();
        tipoProfissional = new String[numReg +1];
        tipoProfissional[0] = " --Selecione um tipo--  ";
        for (int i = 0; i < numReg; i++) {
            tipoProfissional[i + 1] = todos.get(i).getNomeTipo();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btCad){
            String nomeProfissional = tfNomeProfissionais.getText();
            String email = tfEmail.getText();
            String senha = pfSenha.getText();
            long cotato = Long.parseLong(tfContato.getText());
            int idTipo = cbxTipoProfissional.getSelectedIndex();
            Profissionais profissionais = new Profissionais(nomeProfissional,email,senha,cotato,idTipo);
            EntityManager em = JPAUtil.getEntityManager();
            ProfissionaisDao profissionaisDao = new ProfissionaisDao(em);
            em.getTransaction().begin();
            profissionaisDao.cadastro(profissionais);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Profissional " +nomeProfissional+" cadastrado com sucesso!");
            tfNomeProfissionais.setText("");
            tfContato.setText("");
            tfEmail.setText("");
            pfSenha.setText("");


        }else if (e.getSource() == btCanc){
            tfNomeProfissionais.setText("");
            tfContato.setText("");
            tfEmail.setText("");
            pfSenha.setText("");
            cbxTipoProfissional.setSelectedItem(tipoProfissional[0]);
        }


    }
}
