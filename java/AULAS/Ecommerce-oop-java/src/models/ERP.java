package models;

import java.util.ArrayList;
import java.util.List;

public class ERP {
	private Produto produto;
	private List<Produto> produtosDisponiveis;
	private Carrinho carrinho;
	
	
	public ERP() {
		this.produtosDisponiveis = new ArrayList<Produto>();
		this.carrinho = new Carrinho();

		Produto TenisNike = new Produto("G2-1", "T�nis Nike", 200, 10);
		Produto TenisAdidas = new Produto("G2-2", "T�nis Adidas", 150, 10);
		Produto TenisPuma = new Produto("G2-3", "T�nis Puma", 100, 10);
		Produto CamisaNike = new Produto("G2-4", "Camisa Nike", 50, 10);
		Produto CamisaLacoste = new Produto("G2-5", "Camisa Lacoste", 500, 10);
		Produto CamisaSupreme = new Produto("G2-6", "Camisa Supreme", 1000, 10);
		Produto MeiaNike = new Produto("G2-7", "Meia Nike", 30, 10);
		Produto MeiaAdidas = new Produto("G2-8", "Meia Adidas", 25, 10);
		Produto BolaFutebol = new Produto("G2-9", "Bola Futebol", 40, 10);
		Produto BlusaMoletonNike = new Produto("G2-10", "Blusa Moleton Nike", 120, 10);
		
		
		
		this.produtosDisponiveis.add(TenisNike);
		this.produtosDisponiveis.add(TenisAdidas);
		this.produtosDisponiveis.add(TenisPuma);
		this.produtosDisponiveis.add(CamisaNike);
		this.produtosDisponiveis.add(CamisaLacoste);
		this.produtosDisponiveis.add(CamisaSupreme);
		this.produtosDisponiveis.add(MeiaNike);
		this.produtosDisponiveis.add(MeiaAdidas);
		this.produtosDisponiveis.add(BolaFutebol);
		this.produtosDisponiveis.add(BlusaMoletonNike);
	}
	
	
	//M�todo lista produtos disponiveis.
	public List<Produto> getProdutosDisponiveis() {
		return this.produtosDisponiveis;
	}
	

	
	//M�todo buscar produto pelo id e adiciona quantidade
	public void addProductCarrinho(String id, int quantidade){
		Produto product = this.findProductById(id);
		if(quantidade <10){
			this.carrinho.addItem(product, quantidade);				
		}else {
			System.out.println("Quantidade indisponivel!");
		}	
	}
	
	//M�todo totalizador
	public void totalizador(String id, int quantidade){
		Produto product = this.findProductById(id);
			this.carrinho.addItem(product, quantidade);	
			System.out.printf("Sub-total: R$%s",product.getPreco()*quantidade," \n");	
	}
	
	//M�todo buscar produto pelo id
	private Produto findProductById(String id) {
		for (Produto product : this.getProdutosDisponiveis()) {
			if (product.getId().equalsIgnoreCase(id)) {
				return product;
			}
		}
		return null;
	}
	
	//M�todo exibe produtos dispon�veis
	public void exibeProdutosDisponiveis() {
		System.out.println("=== Produtos Dispon�veis ===");
		Util.mostraProdutos(this.produtosDisponiveis);
	}
	//M�todo exibe produtos no carrinho
	public void exibeProdutosCarrinho() {
		this.carrinho.listaProdutos();
	}
	
	//M�todo exibe produtos no carrinho
	public void emitirNota() {
		carrinho.nota();
	}
	
	//M�todo exibe preview produto escolhido
	public void previewProduto(String id) {
		Produto produto = this.findProductById(id);
		Util.mostraUmProduto(produto);
	}

}
