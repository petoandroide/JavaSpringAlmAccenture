package co.almaccenture.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

/**
 * Se implementa el modelo Categoria , setters and getters
 * 
 * @author Uditeam
 *
 */
@Entity
@Table(name = "categoria")
public class Categoria{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCategoria;
	private String nombreCategoria;
	// Para obtener todos los productos dada una categoria
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "categoria")
	private List<Producto> productos;

	public Categoria() {

	}

	public Categoria(Integer idCategoria, String nombreCategoria) {

		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
