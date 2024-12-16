package view;

import dao.*;
import model.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.List;

public class JanelaAtendimentosServicos implements ActionListener {
    JButton btCad, btCanc;
    JLabel lbServicoProfissional, lbPrecoServico, lbHorarioInicila;
    String[] servicoProfissional;
    JComboBox cbxServicoProfissional;
    JTextField tfPrecoServico, tfHorarioInicial;

    public JanelaAtendimentosServicos(){
        JFrame janela = new JFrame("AtendimentoServicos");
        janela.setSize(380,200); // tamanho tela
        janela.setLocationRelativeTo(null);// centro da tela

        janela.setLayout(new FlowLayout(1,20,10)); //alinhamento 0 = esquerda 1 = centro 2 = direita

        // Instanciar os componentes
        lbPrecoServico = new JLabel("Preço que cobrará:              ");
        tfPrecoServico = new JTextField(15);
        lbServicoProfissional = new JLabel("Serviço e Profissional:");
        lbHorarioInicila  = new JLabel("Horario iniciar do Serviço : ");
        tfHorarioInicial  = new JTextField(15);

        btCad = new JButton("Adicionar mais");
        btCanc = new JButton("Cancelar");



        //carregar a string na cbxFormaPagamento
        carregarServicoProfissional();
        cbxServicoProfissional = new JComboBox(servicoProfissional);

        //adicionando ações para os botoes
        btCad.addActionListener(this);
        btCanc.addActionListener(this);

        //Adicionar os botões no conteiner
        janela.add(lbServicoProfissional);
        janela.add(cbxServicoProfissional);
        janela.add(lbHorarioInicila);
        janela.add(tfHorarioInicial);
        janela.add(lbPrecoServico);
        janela.add(tfPrecoServico);
        janela.add(btCad);
        janela.add(btCanc);


        janela.setVisible(true); // Janela visivel
        janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void carregarServicoProfissional(){
        EntityManager em = JPAUtil.getEntityManager();
        ServicoProfissionaisDao servicoProfissionaisDao = new ServicoProfissionaisDao(em);
        ServicosDao servicosDao = new ServicosDao(em);
        ProfissionaisDao profissionaisDao = new ProfissionaisDao(em);
        List<ServicoProfissionais> todos = servicoProfissionaisDao.buscarTodos();
        int numReg = todos.size();
        servicoProfissional = new String[numReg +1];
        servicoProfissional[0] = " --Selecione uma opção--  ";
        for (int i = 0; i < numReg; i++) {
            Servicos servicos = servicosDao.buscarPorId(todos.get(i).getIdServico());
            Profissionais profissionais = profissionaisDao.buscarPorId(todos.get(i).getIdProfissional());

            servicoProfissional[i + 1] = servicos.getNomeServco() + " - " + profissionais.getNomeProfissionais();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btCad){

            int idServicoProfissional = cbxServicoProfissional.getSelectedIndex();
            LocalTime horarioInicio = LocalTime.parse(tfHorarioInicial.getText());
            float precoServico = Float.parseFloat(tfPrecoServico.getText());

            EntityManager em = JPAUtil.getEntityManager();
            AtendimentosDao atendimentosDao = new AtendimentosDao(em);
            List<Atendimentos> todos = atendimentosDao.buscarTodos();
            int numReg = todos.size();
            int idAtendimento = todos.get(numReg-1).getIdAtendimento();

            AtendimentosServicosDao atendimentosServicosDao = new AtendimentosServicosDao(em);

            ServicoProfissionaisDao servicoProfissionaisDao = new ServicoProfissionaisDao(em);
            ServicosDao servicosDao = new ServicosDao(em);

            ServicoProfissionais servicoProfissionais = servicoProfissionaisDao.buscarPorId(idServicoProfissional);
            Servicos servicos = servicosDao.buscarPorId(servicoProfissionais.getIdServico());

            LocalTime tempo = servicos.getTempo();

            LocalTime horarioFinal = horarioInicio
                    .plusHours(tempo.getHour())
                    .plusMinutes(tempo.getMinute())
                    .plusSeconds(tempo.getSecond());

            em.getTransaction().begin();

            AtendimentosServicos atendimentosServicos = new AtendimentosServicos(idAtendimento,idServicoProfissional, precoServico, horarioInicio, horarioFinal);
            atendimentosServicosDao.cadastrar(atendimentosServicos);
            em.getTransaction().commit();
            em.close();

            tfHorarioInicial.setText("");
            tfPrecoServico.setText("");
            JOptionPane.showMessageDialog(null,"Serviço adicionado ao Atendimento");


        }else if (e.getSource() == btCanc){
            tfHorarioInicial.setText("");
            tfPrecoServico.setText("");
        }


    }
}
