package ecommerce;

public class Produto {
	private int idproduto;
	private String nome;
	private double preco;
	private int qtdestoque;
	
	
	
	
	
	
	public Produto(String nome, double preco, int qtdestoque) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.qtdestoque = qtdestoque;
	}
	public int getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQtdestoque() {
		return qtdestoque;
	}
	public void setQtdestoque(int qtdestoque) {
		this.qtdestoque = qtdestoque;
	}
	
	
	
}
