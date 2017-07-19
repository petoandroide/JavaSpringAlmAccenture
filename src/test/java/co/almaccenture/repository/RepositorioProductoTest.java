package co.almaccenture.repository;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.almaccenture.model.Categoria;
import co.almaccenture.model.Producto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RepositorioProductoTest {
	
	@Autowired
	RepositorioProducto productoRepo;
	@Autowired
	RepositorioCategoria cateRepo;

	@Test
	public void testFindByIdProductoAndEstadoProducto() {	
		String idProd = "lmr180";
		
		try {
			assertNotNull("No se encontro producto", productoRepo.findByIdProductoAndEstadoProducto(idProd, true));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testFindOneString() {
		
		String codigo = " bne667";
		
		try {
			
			Producto prod = productoRepo.findByIdProductoAndEstadoProducto(codigo, true);
			assertNotNull("El producto no existe",prod);
			System.out.println("Categoria obtenida" + prod.getCategoria().getNombreCategoria());
				
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testSaveProduct(){
		Producto producto = new Producto();
		producto.setCantidadProducto(20);
		List<Categoria> categorias = (List<Categoria>) cateRepo.findAll();
		Categoria cat = categorias.get(ThreadLocalRandom.current().nextInt(categorias.size()));
		producto.setCategoria(cat);
		producto.setIdProducto("mmr732");
		producto.setDescripcionProducto("Producto Prueba");
		producto.setEstadoProducto(true);
		producto.setFechaModificacion(new Date(Calendar.getInstance().getTimeInMillis()));
		producto.setPrecioProducto((float) 1800);
		producto.setNombreProducto("Producto");
		
		try {
			Producto p = productoRepo.save(producto);
			assertNotNull("No se guardo el producto",p);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	

}