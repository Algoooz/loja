package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="REQUISICAO_COMPRA")
@NamedQuery(name="RequisicaoCompra.findAll", query="SELECT r FROM RequisicaoCompra r")
public class RequisicaoCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codrequisicaocompra;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_requisicao")
	private Date dtRequisicao;

	private int quantidade;

	@ManyToOne
	@JoinColumn(name="codproduto")
	private Produto produto;

	public RequisicaoCompra() {
	}

	public int getCodrequisicaocompra() {
		return this.codrequisicaocompra;
	}

	public void setCodrequisicaocompra(int codrequisicaocompra) {
		this.codrequisicaocompra = codrequisicaocompra;
	}

	public Date getDtRequisicao() {
		return this.dtRequisicao;
	}

	public void setDtRequisicao(Date dtRequisicao) {
		this.dtRequisicao = dtRequisicao;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
