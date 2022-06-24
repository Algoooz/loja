package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codproduto;

	private String descricao;

	private int quantidade;

	@OneToMany(mappedBy="produto")
	private List<RequisicaoCompra> requisicaoCompras;

	public Produto() {
	}

	public int getCodproduto() {
		return this.codproduto;
	}

	public void setCodproduto(int codproduto) {
		this.codproduto = codproduto;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public List<RequisicaoCompra> getRequisicaoCompras() {
		return this.requisicaoCompras;
	}

	public void setRequisicaoCompras(List<RequisicaoCompra> requisicaoCompras) {
		this.requisicaoCompras = requisicaoCompras;
	}

	public RequisicaoCompra addRequisicaoCompra(RequisicaoCompra requisicaoCompra) {
		getRequisicaoCompras().add(requisicaoCompra);
		requisicaoCompra.setProduto(this);

		return requisicaoCompra;
	}

	public RequisicaoCompra removeRequisicaoCompra(RequisicaoCompra requisicaoCompra) {
		getRequisicaoCompras().remove(requisicaoCompra);
		requisicaoCompra.setProduto(null);

		return requisicaoCompra;
	}

}
