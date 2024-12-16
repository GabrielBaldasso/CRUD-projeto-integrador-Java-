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
import java.util.Date;
import java.util.List;


public class JanelaPrincipal implements ActionListener {
    static String resultado = "";
    JMenuItem sair, tipoCad, tipoCon, tipoAlt, tipoExc,
            profissionalCad, profissionalCon, profissionalAlt, profissionalExc,
            servicoCad, servicoCon, servicoAlt, servicoExc,
            clienteCad, clienteCon, clienteAlt, clienteExc,
            atendimentoCad, atendimentoCon, atendimentoAlt, atendimentoExc,
            formaPagamentoCad, formaPagamentoCon, formaPagamentoAlt, formaPagamentoExc,
            servicoProfissionaisCad,servicoProfissionaisCon,servicoProfissionaisAlt,servicoProfissionaisExc;

    public JanelaPrincipal(){
        JFrame janela = new JFrame("Pagina Principal");
        janela.setSize(600,300); // tamanho tela
        janela.setLayout(new FlowLayout(1,20,10));
        janela.setLocationRelativeTo(null);// centro da tela


        //criar barra menu

        JMenuBar jmBarra = new JMenuBar();
        janela.setJMenuBar(jmBarra);

        //instanciar as opções do menu

        JMenu cadastro = new JMenu("Cadastrar");
        JMenu consulta = new JMenu("Consultar");
        JMenu alteracao = new JMenu("Alteração");
        JMenu excluir = new JMenu("Excluir");
        JMenu finalizar = new JMenu("Finalizar");

        //incluir na Barra de Menu
        jmBarra.add(cadastro);
        jmBarra.add(consulta);
        jmBarra.add(alteracao);
        jmBarra.add(excluir);
        jmBarra.add(finalizar);

        //instaciar o sair
        sair = new JMenuItem(" Sair ");

        //TIPO
        tipoCad = new JMenuItem((" Tipo Profissional "));
        tipoCon = new JMenuItem((" Tipo Profissional "));
        tipoAlt = new JMenuItem((" Tipo Profissional "));
        tipoExc = new JMenuItem((" Tipo Profissional "));
        //Profissionais
        profissionalCad = new JMenuItem((" Profissional "));
        profissionalCon = new JMenuItem((" Profissional "));
        profissionalAlt = new JMenuItem((" Profissional "));
        profissionalExc = new JMenuItem((" Profissional "));
        //Servicos
        servicoCad = new JMenuItem((" Serviços "));
        servicoCon = new JMenuItem((" Serviços "));
        servicoAlt = new JMenuItem((" Serviços "));
        servicoExc = new JMenuItem((" Serviços "));

        //Cliente
        clienteCad = new JMenuItem((" Cliente "));
        clienteCon = new JMenuItem((" Cliente "));
        clienteAlt = new JMenuItem((" Cliente "));
        clienteExc = new JMenuItem((" Cliente "));

        //Atendimento
        atendimentoCad = new JMenuItem((" Atendimento "));
        atendimentoCon = new JMenuItem((" Atendimento "));
        atendimentoAlt = new JMenuItem((" Atendimento "));
        atendimentoExc = new JMenuItem((" Atendimento "));

        //FormaPagamento
        formaPagamentoCad = new JMenuItem((" Pagamento "));
        formaPagamentoCad = new JMenuItem((" Pagamento "));
        formaPagamentoCon = new JMenuItem((" Pagamento "));
        formaPagamentoAlt = new JMenuItem((" Pagamento "));
        formaPagamentoExc = new JMenuItem((" Pagamento "));

        //ServicoProfissionais
        servicoProfissionaisCad = new JMenuItem((" Vinculação Serviço "));
        servicoProfissionaisCon = new JMenuItem((" Vinculação Serviço "));
        servicoProfissionaisAlt = new JMenuItem((" Vinculação Serviço "));
        servicoProfissionaisExc = new JMenuItem((" Vinculação Serviço "));


        finalizar.add(sair);
        //categoria


        cadastro.add(tipoCad);
        consulta.add(tipoCon);
        alteracao.add(tipoAlt);
        excluir.add(tipoExc);

        cadastro.add(profissionalCad);
        consulta.add(profissionalCon);
        alteracao.add(profissionalAlt);
        excluir.add(profissionalExc);

        cadastro.add(servicoCad);
        consulta.add(servicoCon);
        alteracao.add(servicoAlt);
        excluir.add(servicoExc);

        cadastro.add(clienteCad);
        consulta.add(clienteCon);
        alteracao.add(clienteAlt);
        excluir.add(clienteExc);

        cadastro.add(atendimentoCad);
        consulta.add(atendimentoCon);
        alteracao.add(atendimentoAlt);
        excluir.add(atendimentoExc);

        cadastro.add(formaPagamentoCad);
        consulta.add(formaPagamentoCon);
        alteracao.add(formaPagamentoAlt);
        excluir.add(formaPagamentoExc);

        cadastro.add(servicoProfissionaisCad);
        consulta.add(servicoProfissionaisCon);
        alteracao.add(servicoProfissionaisAlt);
        excluir.add(servicoProfissionaisExc);




        //ação dos itens de memu
        sair.addActionListener(this);

        tipoCad.addActionListener(this);
        tipoCon.addActionListener(this);
        tipoAlt.addActionListener(this);
        tipoExc.addActionListener(this);

        profissionalCad.addActionListener(this);
        profissionalCon.addActionListener(this);
        profissionalAlt.addActionListener(this);
        profissionalExc.addActionListener(this);

        servicoCad.addActionListener(this);
        servicoCon.addActionListener(this);
        servicoAlt.addActionListener(this);
        servicoExc.addActionListener(this);

        clienteCad.addActionListener(this);
        clienteCon.addActionListener(this);
        clienteAlt.addActionListener(this);
        clienteExc.addActionListener(this);

        atendimentoCad.addActionListener(this);
        atendimentoCon.addActionListener(this);
        atendimentoAlt.addActionListener(this);
        atendimentoExc.addActionListener(this);

        formaPagamentoCad.addActionListener(this);
        formaPagamentoCon.addActionListener(this);
        formaPagamentoAlt.addActionListener(this);
        formaPagamentoExc.addActionListener(this);

        servicoProfissionaisCad.addActionListener(this);
        servicoProfissionaisCon.addActionListener(this);
        servicoProfissionaisAlt.addActionListener(this);
        servicoProfissionaisExc.addActionListener(this);



        janela.setVisible(true); // Janela visivel
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sair){
            JOptionPane.showMessageDialog(null,"Processo Finalizado com sucesso!");
            System.exit(0);
        }

        else if(e.getSource() == formaPagamentoCad){
            cadastrarFormaPagamento();
            JOptionPane.showMessageDialog(null,"Cadastra formato de pagamento!");
        }else if (e.getSource()==formaPagamentoCon){
            consultaFormaPagamento();
            JOptionPane.showMessageDialog(null,resultado);

        } else if (e.getSource() == formaPagamentoAlt) {
            consultaFormaPagamento();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"Escolha qual ID deseja alterar"));
            alterarFormaPagamento(id);
            JOptionPane.showMessageDialog(null,"Forma de Pagamento alterado com sucesso!");

        } else if (e.getSource() == formaPagamentoExc){
            consultaFormaPagamento();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"Qual ID deseja excluir?"));
            excluirFormaPagamento(id);
            JOptionPane.showMessageDialog(null,"Forma de Pagamento Excluida!");
        }

        else if (e.getSource() == tipoCad) {
            new JanelaTiposProfissionais();
        } else if (e.getSource() == tipoCon) {
            consultaTiposProfissionais();
            JOptionPane.showMessageDialog(null,resultado);
        } else if (e.getSource() == tipoAlt) {
            consultaTiposProfissionais();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"\n"+"Escolha qual ID deseja alterar"));
            alterarTiposProfissionais(id);
            JOptionPane.showMessageDialog(null,"Tipo de Profissonal alterado com sucesso!");
        } else if (e.getSource() == tipoExc){
            consultaTiposProfissionais();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"Qual ID deseja excluir?"));
            excluirTipoProfissionais(id);
            JOptionPane.showMessageDialog(null,"Tipo Profissional excluida com sucesso!");
        }

        else if (e.getSource() == servicoCad){
            new JanelaServicos();
        } else if (e.getSource() == servicoCon) {
            consultaServicos();
            JOptionPane.showMessageDialog(null,resultado);
        } else if (e.getSource() == servicoAlt) {
            consultaServicos();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"\n"+"Escolha qual ID deseja alterar"));
            alterarServico(id);
            JOptionPane.showMessageDialog(null,"Serviço alterado com sucesso!");
        } else if (e.getSource() == servicoExc){
            consultaServicos();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"Qual ID deseja excluir?"));
            excluirServico(id);
            JOptionPane.showMessageDialog(null,"Serviço excluida com sucesso!");
        }

        else  if (e.getSource() == profissionalCad){
            new JanelaProfissionais();
        }else  if (e.getSource() == profissionalCon){
            consultaProfissionais();
            JOptionPane.showMessageDialog(null,resultado);
        }else  if (e.getSource() == profissionalAlt){
            consultaProfissionais();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"\n"+"Escolha qual ID deseja alterar"));
            alterarProfissionais(id);
            JOptionPane.showMessageDialog(null,"Profissional alterado com sucesso!");
        } else if (e.getSource() == profissionalExc){
            consultaProfissionais();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"Qual ID deseja excluir?"));
            excluirProfissionais(id);
            JOptionPane.showMessageDialog(null,"Serviço excluida com sucesso!");
        }

        else  if (e.getSource() == clienteCad){
            new JanelaClientes();
        }else  if (e.getSource() == clienteCon){
            consultaCliente();
            JOptionPane.showMessageDialog(null,resultado);
        }else  if (e.getSource() == clienteAlt){
            consultaCliente();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"\n"+"Escolha qual ID deseja alterar"));
            alterarCliente(id);
            JOptionPane.showMessageDialog(null,"Cliente alterado com sucesso!");
        } else if (e.getSource() == clienteExc){
            consultaCliente();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"Qual ID deseja excluir?"));
            excluirCliente(id);
            JOptionPane.showMessageDialog(null,"Cliente excluida com sucesso!");
        }

        else  if (e.getSource() == servicoProfissionaisCad){
            new JanelaServicoProfissionais();
        }else  if (e.getSource() == servicoProfissionaisCon){
            consultaServicoProfissionais();
            JOptionPane.showMessageDialog(null,resultado);
        }else if (e.getSource() == servicoProfissionaisAlt) {
            consultaServicoProfissionais();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"\n"+"Escolha qual ID deseja alterar"));
            alterarServicoProfissionais(id);
            JOptionPane.showMessageDialog(null,"Serviço do profissional alterado com sucesso!");
        }else if (e.getSource() == servicoProfissionaisExc){
            consultaServicoProfissionais();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"Qual ID deseja excluir?"));
            excluirServicoProfissionais(id);
            JOptionPane.showMessageDialog(null,"Serviço do profissional excluida com sucesso!");
        }

        else  if (e.getSource() == atendimentoCad) {
            new JanelaAtendimentos();
        }else  if (e.getSource() == atendimentoCon) {
            consultaAtendimento();
            JOptionPane.showMessageDialog(null,resultado);
        }else if (e.getSource() == atendimentoAlt) {
            consultaAtendimento();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"\n"+"Escolha qual ID deseja alterar"));
            alterarAtedimento(id);
            JOptionPane.showMessageDialog(null,"Atendimento alterado com sucesso!");
        }else if (e.getSource() == atendimentoExc){
            consultaAtendimento();
            int id =Integer.parseInt(JOptionPane.showInputDialog(null,resultado+"Qual ID deseja excluir?"));
            excluirAtendimento(id);
            JOptionPane.showMessageDialog(null,"Atendimento excluida com sucesso!");
        }

    }// actionPerformed


    public static void cadastrarFormaPagamento(){
        String descricao = JOptionPane.showInputDialog("Informe o formato do pagamento");
        //instanciar a class
        FormasPagamentos formasPagamentos = new FormasPagamentos(descricao);
        //conectar com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        FormasPagamentosDao formasPagamentosDao = new FormasPagamentosDao(em);
        em.getTransaction().begin();
        formasPagamentosDao.cadastrar(formasPagamentos);
        em.getTransaction().commit();
        em.close();
    }
    public static String consultaFormaPagamento(){
        //conectar com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        FormasPagamentosDao formasPagamentosDao = new FormasPagamentosDao(em);
        List<FormasPagamentos> todos  = formasPagamentosDao.buscarTodos();
        resultado = "ID - FORMA_PAGAMENTO\n";
        int numReg = todos.size();
        for (int i=0; i<numReg; i++){
            resultado += todos.get(i).getIdFormaPagamento() + " - " + todos.get(i).getDescricaoPagamento()+"\n";
        }
        return resultado;
    }
    public static void alterarFormaPagamento(int id){
        EntityManager em = JPAUtil.getEntityManager();
        FormasPagamentosDao formasPagamentosDao = new FormasPagamentosDao(em);

        String descricaoPagamento = JOptionPane.showInputDialog("Digite o Forma de Pagamento:");

        FormasPagamentos formasPagamentos = formasPagamentosDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();
        formasPagamentosDao.alterar(formasPagamentos);
        formasPagamentos.setDescricaoPagamento(descricaoPagamento);

        em.getTransaction().commit();
        em.close();
    }
    public static void excluirFormaPagamento(int id){
        EntityManager em = JPAUtil.getEntityManager();
        FormasPagamentosDao formasPagamentosDao = new FormasPagamentosDao(em);

        FormasPagamentos formasPagamentos = formasPagamentosDao.buscarPorId(id);

        em.getTransaction().begin();
        formasPagamentosDao.excluir(formasPagamentos);
        em.getTransaction().commit();
        em.close();

    }

    public static String consultaTiposProfissionais(){
        EntityManager em = JPAUtil.getEntityManager();
        TiposProfissionaisDao tiposProfissionaisDao = new TiposProfissionaisDao(em);
        List<TiposProfissionais> todos = tiposProfissionaisDao.buscarTodos();
        resultado = "ID - TIPO - DESCRIÇÃO\n";
        int numReg = todos.size();
        for (int i=0; i<numReg; i++){
            resultado += todos.get(i).getIdTipoProfissional() + " - " + todos.get(i).getNomeTipo() + " - " + todos.get(i).getDescricao()+"\n";
        }
        return resultado;
    }
    public static void alterarTiposProfissionais(int id){
        EntityManager em = JPAUtil.getEntityManager();
        TiposProfissionaisDao tiposProfissionaisDao = new TiposProfissionaisDao(em);
        TiposProfissionais tiposProfissionais = tiposProfissionaisDao.buscarPorId(id);
        em.getTransaction().begin();
        tiposProfissionaisDao.alterar(tiposProfissionais);
        String [] botoes = {"Nome Tipo", "Descrição"};
        int opcao = JOptionPane.showOptionDialog(null,"Qual o campo deseja alterar?","TABELA TIPO", 0, 3, null,botoes,0);
        switch (opcao){
            case 0:
                String nomeTipo = JOptionPane.showInputDialog("Informe o nova nome do tipo de profissional:");
                tiposProfissionais.setNomeTipo(nomeTipo);
                break;
            case 1:
                String descricao = JOptionPane.showInputDialog("Informe a nova descrição do tipo de profissional:");
                tiposProfissionais.setDescricao(descricao);
                break;
        }

        em.getTransaction().commit();
        em.close();
    }
    public static void excluirTipoProfissionais(int id){
        EntityManager em = JPAUtil.getEntityManager();
        TiposProfissionaisDao tiposProfissionaisDao = new TiposProfissionaisDao(em);

        TiposProfissionais tiposProfissionais = tiposProfissionaisDao.buscarPorId(id);

        em.getTransaction().begin();
        tiposProfissionaisDao.excluir(tiposProfissionais);
        em.getTransaction().commit();
        em.close();
    }

    public static String consultaServicos(){
        EntityManager em = JPAUtil.getEntityManager();
        ServicosDao servicosDao = new ServicosDao(em);
        List<Servicos> todos = servicosDao.buscarTodos();
        resultado = "ID - SERVIÇO - DESCRIÇÃO - TEMPO\n";
        int numReg = todos.size();
        for (int i=0; i<numReg; i++){
            resultado += todos.get(i).getIdServico() + " - " + todos.get(i).getNomeServco()+ " - " + todos.get(i).getDescricaoServicos() + " - " + todos.get(i).getTempo() + "\n";
        }
        return resultado;
    }
    public static void alterarServico(int id){
        EntityManager em = JPAUtil.getEntityManager();
        ServicosDao servicosDao = new ServicosDao(em);
        Servicos servicos = servicosDao.buscarPorId(id);
        em.getTransaction().begin();
        servicosDao.alterar(servicos);
        String [] botoes = {"Nome Serviço", "Descrição", "Tempo"};
        int opcao = JOptionPane.showOptionDialog(null,"Qual o campo deseja alterar?","TABELA TIPO", 0, 3, null,botoes,0);
        switch (opcao){
            case 0:
                String nomeServico = JOptionPane.showInputDialog("Informe o nova nome do serviço:");
                servicos.setNomeServco(nomeServico);
                break;
            case 1:
                String descricao = JOptionPane.showInputDialog("Informe a nova descrição do serviço:");
                servicos.setDescricaoServicos(descricao);
                break;
            case 2:
                LocalTime tempo = LocalTime.parse(JOptionPane.showInputDialog("Informe o novo tempo(horas:minutos):"), DateTimeFormatter.ofPattern("HH:mm"));
                servicos.setTempo(tempo);
                break;
        }

        em.getTransaction().commit();
        em.close();
    }
    public static void excluirServico(int id){
        EntityManager em = JPAUtil.getEntityManager();
        ServicosDao servicosDao = new ServicosDao(em);

        Servicos servicos = servicosDao.buscarPorId(id);

        em.getTransaction().begin();
        servicosDao.excluir(servicos);
        em.getTransaction().commit();
        em.close();

    }

    public static String consultaProfissionais(){
        EntityManager em = JPAUtil.getEntityManager();
        ProfissionaisDao profissionaisDao = new ProfissionaisDao(em);
        TiposProfissionaisDao tiposProfissionaisDao = new TiposProfissionaisDao(em);
        List<Profissionais> todos = profissionaisDao.buscarTodos();
        resultado = "ID - PROFISSIONAL - EMAIL - CONTATO - CATEGORIA\n";
        int numReg = todos.size();
        for (int i=0; i<numReg; i++){
            TiposProfissionais tiposProfissionais = tiposProfissionaisDao.buscarPorId(todos.get(i).getIdTipoProfissional());
            resultado += todos.get(i).getIdProfissional() + " - " +
                    todos.get(i).getNomeProfissionais()+ " - " +
                    todos.get(i).getEmail() + " - " +
                    todos.get(i).getContato()+ " - " +
                    tiposProfissionais.getNomeTipo() + "\n";
        }
        return resultado;
    }
    public static void alterarProfissionais(int id){
        EntityManager em = JPAUtil.getEntityManager();
        ProfissionaisDao profissionaisDao = new ProfissionaisDao(em);
        Profissionais profissionais = profissionaisDao.buscarPorId(id);
        em.getTransaction().begin();
        profissionaisDao.alterar(profissionais);
        String [] botoes = {"Nome Proficional", "Email", "Senha", "Contato", "Categoria"};
        int opcao = JOptionPane.showOptionDialog(null,"Qual o campo deseja alterar?","PROFISSIONAL", 0, 3, null,botoes,0);
        switch (opcao){
            case 0:
                String nomeProfissional = JOptionPane.showInputDialog("Informe o nova nome do profissional:");
                profissionais.setNomeProfissionais(nomeProfissional);
                break;
            case 1:
                String email = JOptionPane.showInputDialog("Informe a novo email do profissional:");
                profissionais.setEmail(email);
                break;
            case 2:
                String senha = JOptionPane.showInputDialog("Informe a nova senha:");
                profissionais.setSenha(senha);
                break;
            case 3:
                long contato = Long.parseLong(JOptionPane.showInputDialog("Informe o novo contato:"));
                profissionais.setContato(contato);
                break;
            case 4:
                consultaTiposProfissionais();
                int categoria = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da nova categoria:\n" + resultado));
                profissionais.setIdTipoProfissional(categoria);
                break;
        }

        em.getTransaction().commit();
        em.close();
    }
    public static void excluirProfissionais(int id){
        EntityManager em = JPAUtil.getEntityManager();
        ProfissionaisDao profissionaisDao = new ProfissionaisDao(em);

        Profissionais profissionais = profissionaisDao.buscarPorId(id);

        em.getTransaction().begin();
        profissionaisDao.excluir(profissionais);
        em.getTransaction().commit();
        em.close();
    }

    public static String consultaCliente(){
        EntityManager em = JPAUtil.getEntityManager();
        ClientesDao clientesDao = new ClientesDao(em);
        List<Clientes> todos = clientesDao.buscarTodos();
        resultado = "ID - NOME - EMAIL - CONTATO\n";
        int numReg = todos.size();
        for (int i=0; i<numReg; i++){
            resultado += todos.get(i).getIdCliente() + " - " +
                    todos.get(i).getNomeCliente()+ " - " +
                    todos.get(i).getEmail() + " - " +
                    todos.get(i).getContatoCliente()+ "\n";
        }
        return resultado;
    }
    public static void alterarCliente(int id){
        EntityManager em = JPAUtil.getEntityManager();
        ClientesDao clientesDao = new ClientesDao(em);
        Clientes clientes = clientesDao.buscarPorId(id);
        em.getTransaction().begin();
        clientesDao.alterar(clientes);
        String [] botoes = {"Nome", "Email", "Senha", "Contato", "CPF"};
        int opcao = JOptionPane.showOptionDialog(null,"Qual o campo deseja alterar?","CLIENTE", 0, 3, null,botoes,0);
        switch (opcao){
            case 0:
                String nomeCliente = JOptionPane.showInputDialog("Informe o nova nome do(a) Cliente:");
                clientes.setNomeCliente(nomeCliente);
                break;
            case 1:
                String email = JOptionPane.showInputDialog("Informe a novo email do(a) Cliente:");
                clientes.setEmail(email);
                break;
            case 2:
                String senha = JOptionPane.showInputDialog("Informe a nova senha:");
                clientes.setSenha(senha);
                break;
            case 3:
                long contato = Long.parseLong(JOptionPane.showInputDialog("Informe o novo contato:"));
                clientes.setContatoCliente(contato);
                break;
            case 4:
                consultaTiposProfissionais();
                int cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o novo do(a) Cliente"));
                clientes.setCpf(cpf);
                break;
        }
        em.getTransaction().commit();
        em.close();
    }
    public static void excluirCliente(int id){
        EntityManager em = JPAUtil.getEntityManager();
        ClientesDao clientesDao = new ClientesDao(em);

        Clientes clientes = clientesDao.buscarPorId(id);

        em.getTransaction().begin();
        clientesDao.excluir(clientes);
        em.getTransaction().commit();
        em.close();
    }

    public static String consultaServicoProfissionais(){
        EntityManager em = JPAUtil.getEntityManager();
        ServicoProfissionaisDao servicoProfissionaisDao = new ServicoProfissionaisDao(em);
        ProfissionaisDao profissionaisDao = new ProfissionaisDao(em);
        ServicosDao servicosDao = new ServicosDao(em);
        List<ServicoProfissionais> todos = servicoProfissionaisDao.buscarTodos();
        resultado = "ID - PROFISSIONAL - SERVIÇO - PREÇO\n";
        int numReg = todos.size();
        for (int i=0; i<numReg; i++){
            Profissionais profissionais = profissionaisDao.buscarPorId(todos.get(i).getIdProfissional());
            Servicos servicos = servicosDao.buscarPorId(todos.get(i).getIdServico());
            resultado += todos.get(i).getIdServicoProfissionais() + " - " +
                    profissionais.getNomeProfissionais()+ " - " +
                    servicos.getNomeServco()+ " - " +
                    todos.get(i).getPrecoProfissional()+"\n";
        }
        return resultado;
    }
    public static void alterarServicoProfissionais(int id){
        EntityManager em = JPAUtil.getEntityManager();
        ServicoProfissionaisDao servicoProfissionaisDao = new ServicoProfissionaisDao(em);
        ServicoProfissionais servicoProfissionais = servicoProfissionaisDao.buscarPorId(id);
        em.getTransaction().begin();
        servicoProfissionaisDao.alterar(servicoProfissionais);
        String [] botoes = {"Proficional", "Serviço", "Preço"};
        int opcao = JOptionPane.showOptionDialog(null,"Qual o campo deseja alterar?","Serviço Profissionais", 0, 3, null,botoes,0);
        switch (opcao){
            case 0:
                consultaProfissionais();
                int profissional = Integer.parseInt(JOptionPane.showInputDialog("Informe o profissional que sera vinculado:\n" + resultado));
                servicoProfissionais.setIdProfissional(profissional);
                break;
            case 1:
                consultaServicos();
                int servico = Integer.parseInt(JOptionPane.showInputDialog("Informe o serviço a ser vinculado:\n" + resultado));
                servicoProfissionais.setIdServico(servico);
                break;
            case 2:
                float preco = Float.parseFloat(JOptionPane.showInputDialog("Defina o novo proço:"));
                servicoProfissionais.setPrecoProfissional(preco);
                break;
        }

        em.getTransaction().commit();
        em.close();
    }
    public static void excluirServicoProfissionais(int id){
        EntityManager em = JPAUtil.getEntityManager();
        ServicoProfissionaisDao servicoProfissionaisDao = new ServicoProfissionaisDao(em);

        ServicoProfissionais servicoProfissionais = servicoProfissionaisDao.buscarPorId(id);

        em.getTransaction().begin();
        servicoProfissionaisDao.excluir(servicoProfissionais);
        em.getTransaction().commit();
        em.close();
    }


    public static String consultaAtendimento(){
        EntityManager em = JPAUtil.getEntityManager();
        AtendimentosDao atendimentosDao = new AtendimentosDao(em);
        ClientesDao clientesDao = new ClientesDao(em);
        List<Atendimentos> todos = atendimentosDao.buscarTodos();
        resultado = "ID - DATA - HORARIO - CLIENTE - STATUS - PREÇO\n";
        int numReg = todos.size();
        for (int i=0; i<numReg; i++){
            Clientes clientes = clientesDao.buscarPorId(todos.get(i).getIdCliente());
            resultado += todos.get(i).getIdAtendimento() + " - "
                    + todos.get(i).getData() + " - "
                    + todos.get(i).getHorarioInicio() + " - "
                    + clientes.getNomeCliente() + " - "
                    + todos.get(i).getStatus() + " - "
                    + todos.get(i).getPrecoTotal() + "\n";
        }
        return resultado;
    }
    public static void alterarAtedimento(int id){
        EntityManager em = JPAUtil.getEntityManager();
        AtendimentosDao atendimentosDao = new AtendimentosDao(em);
        Atendimentos atendimentos = atendimentosDao.buscarPorId(id);
        em.getTransaction().begin();
        atendimentosDao.alterar(atendimentos);
        String [] botoes = {"Data", "Horario", "Comentario", "Status", "Preço", "Pagamento", "Cliente"};
        int opcao = JOptionPane.showOptionDialog(null,"Qual o campo deseja alterar?","Serviço Profissionais", 0, 3, null,botoes,0);
        switch (opcao){
            case 0:
                String dataString =JOptionPane.showInputDialog("Informe a nova data para o agendamento:\n");
                LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                atendimentos.setData(data);
                break;
            case 1:
                String horarioInicialString =JOptionPane.showInputDialog("Informe o novo horario para o agendamento:\n");
                LocalTime horarioInicial = LocalTime.parse(horarioInicialString, DateTimeFormatter.ofPattern("HH:mm"));
                atendimentos.setHorarioInicio(horarioInicial);
                break;
            case 2:
                String comentario = JOptionPane.showInputDialog("Informe o novo comentario:");
                atendimentos.setComentario(comentario);
                break;
            case 3:
                String status = JOptionPane.showInputDialog("Informe o novo status:");
                atendimentos.setStatus(status);
                break;
            case 4:
                float preco = Float.parseFloat(JOptionPane.showInputDialog("Defina o novo preço total:"));
                atendimentos.setPrecoTotal(preco);
                break;
            case 5:
                consultaFormaPagamento();
                int forma = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do metodo de pagamento :\n" + resultado));
                atendimentos.setIdCliente(forma);
                break;
            case 6:
                consultaCliente();
                int cliente = Integer.parseInt(JOptionPane.showInputDialog("Informe o cliente :\n" + resultado));
                atendimentos.setIdCliente(cliente);
                break;
        }

        em.getTransaction().commit();
        em.close();

    }
    public static void excluirAtendimento(int id){
        EntityManager em = JPAUtil.getEntityManager();
        AtendimentosDao atendimentosDao = new AtendimentosDao(em);
        AtendimentosServicosDao atendimentosServicosDao = new AtendimentosServicosDao(em);

        atendimentosServicosDao.excluirAtendimentoServico(id);

        Atendimentos atendimentos = atendimentosDao.buscarPorId(id);

        em.getTransaction().begin();
        atendimentosDao.excluir(atendimentos);
        em.getTransaction().commit();
        em.close();
    }

}


