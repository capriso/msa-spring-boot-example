package great.shine.product.domain.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import great.shine.common.domain.AttributeList;
import great.shine.product.domain.entity.Product;
import great.shine.product.domain.service.logic.ProductServiceLogic;
import great.shine.product.domain.service.vo.ProductCvo;
import great.shine.product.domain.store.ProductStoreFactory;
import great.shine.product.domain.store.memory.ProductMemoryStoreFactory;

public class ProductServiceTest {
	private ProductService productService;

	@Before
	public void setup() throws Exception {
		ProductStoreFactory storeFactory = new ProductMemoryStoreFactory();
		this.productService = new ProductServiceLogic(storeFactory);
	}

	@Test
	public void testRegister() throws Exception {
		String entityId = productService.register(ProductCvo.sample());
		
		assertNotNull(entityId);
	}

	@Test(expected = NoSuchElementException.class)
	public void testFindNoCompany() throws Exception {
		productService.find("no-such-entity-id");
	}
	
	@Test
	public void testFindProduct() throws Exception {
		String entityId = productService.register(ProductCvo.sample());
		Product entity = productService.find(entityId);
		
		assertNotNull(entity);
	}
	
	@Test
	public void testModify() throws Exception {
		String entityId = productService.register(ProductCvo.sample());
		
		String newName = "newName";
		AttributeList attributes = new AttributeList("name", newName);
		productService.modify(entityId, attributes);
		Product entity = productService.find(entityId);
		
		assertEquals(newName, entity.getName());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testRemove() throws Exception {
		String entityId = productService.register(ProductCvo.sample());
		productService.remove(entityId);
		productService.find(entityId);
	}
}
