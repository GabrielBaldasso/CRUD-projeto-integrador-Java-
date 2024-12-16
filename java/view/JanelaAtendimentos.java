package view;

import dao.*;
import model.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JanelaAtendimentos implements ActionListener {
    JButton btCad, btCanc;
    JLabel lbFormaPagamento, lbCliente, lbData, lbHorarioInicial, lbComentario, lbPrecoTotal;
    String[] clientes, formaPagamento;
    JComboBox cbxCliente, cbxFormaPagamento, cbxStatus;
    JTextField tfComentario, tfData, tfHorarioInicial, tfPrecoTotal;

    public JanelaAtendimentos(){
        JFrame janela = new JFrame("Atendimentos");
        janela.setSize(350,300); // tamanho tela
        janela.setLocationRelativeTo(null);// centro da tela

        janela.setLayout(new FlowLayout(1,20,10)); //alinhamento 0 = esquerda 1 = centro 2 = direita

        // Instanciar os componentes
        lbCliente =  new JLabel("Informe o cliente:");
        lbData = new JLabel("Data atendimento:");
        lbHorarioInicial = new JLabel("Horario Inicial:       ");
        lbComentario = new JLabel("Comentario:           ");

        lbFormaPagamento = new JLabel("Metodo de pagamento:");
        lbPrecoTotal = new JLabel("Preço Total:");
        tfData  = new JTextField(15);
        tfComentario = new JTextField(15);
        tfHorarioInicial = new JTextField(15);
        tfPrecoTotal = new JTextField(14);

        btCad = new JButton("Cadastrar");
        btCanc = new JButton("Cancela");

        //carregar a string na cbxFormaPagamento
        carregarFormaPagamento();
        cbxFormaPagamento = new JComboBox(formaPagamento);

        //carregar a string na cbxCliente
        carregarCliente();
        cbxCliente = new JComboBox(clientes);

        //adicionando ações para os botoes
        btCad.addActionListener(this);
        btCanc.addActionListener(this);

        //Adicionar os botões no conteiner
        janela.add(lbCliente);
        janela.add(cbxCliente);
        janela.add(lbData);
        janela.add(tfData);
        janela.add(lbHorarioInicial);
        janela.add(tfHorarioInicial);
        janela.add(lbComentario);
        janela.add(tfComentario);
        janela.add(lbFormaPagamento);
        janela.add(cbxFormaPagamento);
        janela.add(lbPrecoTotal);
        janela.add(tfPrecoTotal);
        janela.add(btCad);
        janela.add(btCanc);



        janela.setVisible(true); // Janela visivel
        janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
   }

    public void carregarCliente(){
        EntityManager em = JPAUtil.getEntityManager();
        ClientesDao clientesDao = new ClientesDao(em);
        List<Clientes> todos = clientesDao.buscarTodos();
        int numReg = todos.size();
        clientes = new String[numReg +1];
        clientes[0] = " --Selecione o Cliente--  ";
        for (int i = 0; i < numReg; i++) {
            clientes[i + 1] = todos.get(i).getNomeCliente();
        }
    }

    public void carregarFormaPagamento(){
        EntityManager em = JPAUtil.getEntityManager();
        FormasPagamentosDao formasPagamentosDao = new FormasPagamentosDao(em);
        List<FormasPagamentos> todos = formasPagamentosDao.buscarTodos();
        int numReg = todos.size();
        formaPagamento = new String[numReg +1];
        formaPagamento[0] = " --Selecione a forma de pagamento--  ";
        for (int i = 0; i < numReg; i++) {
            formaPagamento[i + 1] = todos.get(i).getDescricaoPagamento();
        }
    }


   @Override
   public void actionPerformed(ActionEvent e) {
       if (e.getSource() == btCad){
           int idCliente = cbxCliente.getSelectedIndex();
           String dataString = tfData.getText();
           LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
           String horarioInicialString = tfHorarioInicial.getText();
           LocalTime horarioInicial = LocalTime.parse(horarioInicialString, DateTimeFormatter.ofPattern("HH:mm"));
           String comentario = tfComentario.getText();
           String status = "Agendado";
           LocalTime horarioFinal = horarioInicial;
           float pretoTotal = Float.parseFloat(tfPrecoTotal.getText());

           int idFormaPagamento = cbxFormaPagamento.getSelectedIndex();
           Atendimentos atendimentos = new Atendimentos(idFormaPagamento, idCliente, data, horarioInicial, horarioFinal, comentario, status, pretoTotal);
           EntityManager em = JPAUtil.getEntityManager();
           AtendimentosDao atendimentosDao = new AtendimentosDao(em);
           em.getTransaction().begin();
           atendimentosDao.cadastrar(atendimentos);
           em.getTransaction().commit();
           em.close();
           new JanelaAtendimentosServicos();

           JOptionPane.showMessageDialog(null,"Atendimento cadastrado com sucesso!");

       }else if (e.getSource() == btCanc){

       }

    }
}
