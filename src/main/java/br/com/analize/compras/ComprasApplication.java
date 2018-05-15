package br.com.analize.compras;

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.entity.Cidade;
import br.com.analize.compras.entity.Cliente;
import br.com.analize.compras.entity.Endereco;
import br.com.analize.compras.entity.Estado;
import br.com.analize.compras.entity.Pagamento;
import br.com.analize.compras.entity.PagamentoComBoleto;
import br.com.analize.compras.entity.PagamentoComCartao;
import br.com.analize.compras.entity.Pedido;
import br.com.analize.compras.entity.Produto;
import br.com.analize.compras.entity.enumeration.EstadoPagamentoEnum;
import br.com.analize.compras.entity.enumeration.ItemPedido;
import br.com.analize.compras.entity.enumeration.TipoClienteEnum;
import br.com.analize.compras.repository.CategoriaRepository;
import br.com.analize.compras.repository.CidadeRepository;
import br.com.analize.compras.repository.ClienteRepository;
import br.com.analize.compras.repository.EnderecoRepository;
import br.com.analize.compras.repository.EstadoRepository;
import br.com.analize.compras.repository.ItemPedidoRepository;
import br.com.analize.compras.repository.PagamentoRepository;
import br.com.analize.compras.repository.PedidoRepository;
import br.com.analize.compras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;


@SpringBootApplication
public class ComprasApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ComprasApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Categoria cat1 = new Categoria(null, "informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.save(Arrays.asList(cat1, cat2));
        produtoRepository.save(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        c1.setEstado(est1);
        c2.setEstado(est2);
        c3.setEstado(est2);

        estadoRepository.save(Arrays.asList(est1, est2));
        cidadeRepository.save(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoClienteEnum.PESSOAFISICA);

        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", c1, cli1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centros", "38777012", c2, cli1);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        clienteRepository.save(cli1);
        enderecoRepository.save(Arrays.asList(e1, e2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("30/08/2017 10:32"), e1, cli1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), e2, cli1);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamentoEnum.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamentoEnum.PENDENTE, ped2,
                sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.save(Arrays.asList(ped1, ped2));
        pagamentoRepository.save(Arrays.asList(pagto1, pagto2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p1.getItens().addAll(Arrays.asList(ip3));
        p1.getItens().addAll(Arrays.asList(ip2));

        itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));
    }
}
