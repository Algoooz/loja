package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codpedido;

	@Temporal(TemporalType.DATE)
	private Date datapedido;

	private String nf;

	private BigDecimal valortotal;

	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="codcliente")
	private Cliente cliente;

	public Pedido() {
	}

	public int getCodpedido() {
		return this.codpedido;
	}

	public void setCodpedido(int codpedido) {
		this.codpedido = codpedido;
	}

	public Date getDatapedido() {
		return this.datapedido;
	}

	public void setDatapedido(Date datapedido) {
		this.datapedido = datapedido;
	}

	public String getNf() {
		return this.nf;
	}

	public void setNf(String nf) {
		this.nf = nf;
	}

	public BigDecimal getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
