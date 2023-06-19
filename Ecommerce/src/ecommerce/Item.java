package ecommerce;

public class Item  {
	private Produto produto;
	private int quantidadecompra;
	
	public Item(Produto produto, int quantidadecompra ) {
		this.produto = produto;
		this.quantidadecompra = quantidadecompra;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidadecompra() {
		return quantidadecompra;
	}
	public void setQuantidadecompra(int quantidadecompra) {
		this.quantidadecompra = quantidadecompra;
	}
	
	
	
}
