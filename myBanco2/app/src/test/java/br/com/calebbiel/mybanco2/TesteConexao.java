package br.com.calebbiel.mybanco2;

import org.junit.Test;

public class TesteConexao {
    ControladorCliente controladorCliente ;

    @Test
    public void test_conectarBancoSucesso(){
        Conexao cc = new Conexao();
        if(cc.testaConexao()){
            System.out.println(cc.getClass().getSimpleName() + " - OK");
        }
    }


    @Test
    public void test_inclusao_cliente(){
        controladorCliente = new ControladorCliente();
        Cliente cliente = new Cliente();

        cliente.setNome("Silva Marcão");
        cliente.setEmail("rubens@");
        cliente.setCelular("123456");
        cliente.setCpf("33333333");

        controladorCliente.salvar(cliente);

    }

    @Test
    public void test_pesquisar_cliente(){
        controladorCliente = new ControladorCliente();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);

        controladorCliente.consultar(cliente);
    }

}
