package view;

import dao.ProfissionaisDao;
import dao.ServicoProfissionaisDao;
import dao.ServicosDao;
import model.Profissionais;
import model.ServicoProfissionais;
import model.Servicos;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JanelaServicoProfissionais implements ActionListener {
    JButton btCad, btCanc;
    JLabel lbProfissional, lbServico, lbPrecoProfissional;
    String[] profissional, servico;
    JComboBox cbxProfissional, cbxServico;
    JTextField tfPrecoProfissional;

    public JanelaServicoProfissionais(){
        JFrame janela = new JFrame("Definição de serviço ao profissional");
        janela.setSize(380,200); // tamanho tela
        janela.setLocationRelativeTo(null);// centro da tela

        janela.setLayout(new FlowLayout(1,20,10)); //alinhamento 0 = esquerda 1 = centro 2 = direita

        //Instanciar os componentes
        lbPrecoProfissional = new JLabel("Preço:          ");
        lbServico = new JLabel("Serviço:       ");
        lbProfissional = new JLabel("Profissional:");
        tfPrecoProfissional = new JTextField(19);

        //carregar a string na cbx
        carregarProfissionais();
        cbxProfissional = new JComboBox(profissional);
        carregarServicos();
        cbxServico = new JComboBox(servico);

        btCad = new JButton("Cadastrar");
        btCanc = new JButton("Cancela");

        //Adicionar os botões no conteiner
        janela.add(lbProfissional);
        janela.add(cbxProfissional);
        janela.add(lbServico);
        janela.add(cbxServico);
        janela.add(lbPrecoProfissional);
        janela.add(tfPrecoProfissional);
        janela.add(btCad);
        janela.add(btCanc);

        //adicionando ações para os botoes
        btCad.addActionListener(this);
        btCanc.addActionListener(this);

        janela.setVisible(true); // Janela visivel
        janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void carregarProfissionais(){
        EntityManager em = JPAUtil.getEntityManager();
        ProfissionaisDao profissionaisDao = new ProfissionaisDao(em);
        List<Profissionais> todos = profissionaisDao.buscarTodos();
        int numReg = todos.size();
        profissional = new String[numReg +1];
        profissional[0] = " --Selecione o Profissional--  ";
        for (int i = 0; i < numReg; i++) {
            profissional[i + 1] = "  "+todos.get(i).getNomeProfissionais();
        }
    }
    public void carregarServicos(){
        EntityManager em = JPAUtil.getEntityManager();
        ServicosDao servicosDao = new ServicosDao(em);
        List<Servicos> todos = servicosDao.buscarTodos();
        int numReg = todos.size();
        servico = new String[numReg +1];
        servico[0] = "      --Selecione o Serviço--      ";
        for (int i = 0; i < numReg; i++) {
            servico[i + 1] = "  "+todos.get(i).getNomeServco();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btCad){
            float precoProfissional = Float.parseFloat(tfPrecoProfissional.getText());
            int idServico = cbxServico.getSelectedIndex();
            int idProfissional = cbxProfissional.getSelectedIndex();
            ServicoProfissionais servicoProfissionais = new ServicoProfissionais(idProfissional,idServico,precoProfissional);
            EntityManager em = JPAUtil.getEntityManager();
            ServicoProfissionaisDao servicoProfissionaisDao = new ServicoProfissionaisDao(em);
            em.getTransaction().begin();
            servicoProfissionaisDao.cadastro(servicoProfissionais);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Serviço vinculado com profissional com sucesso!");
            cbxProfissional.setSelectedItem(profissional[0]);
            cbxServico.setSelectedItem(servico[0]);
            tfPrecoProfissional.setText("");


        } else if (e.getSource() == btCanc) {
            cbxProfissional.setSelectedItem(profissional[0]);
            cbxServico.setSelectedItem(servico[0]);
            tfPrecoProfissional.setText("");

        }
    }
}
