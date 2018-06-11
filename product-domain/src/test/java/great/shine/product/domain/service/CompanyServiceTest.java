package great.shine.product.domain.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import great.shine.common.domain.AttributeList;
import great.shine.product.domain.entity.Company;
import great.shine.product.domain.service.logic.CompanyServiceLogic;
import great.shine.product.domain.service.vo.CompanyCvo;
import great.shine.product.domain.store.ProductStoreFactory;
import great.shine.product.domain.store.memory.ProductMemoryStoreFactory;

public class CompanyServiceTest {
	private CompanyService companyService;

	@Before
	public void setup() throws Exception {
		ProductStoreFactory storeFactory = new ProductMemoryStoreFactory();
		this.companyService = new CompanyServiceLogic(storeFactory);
	}

	@Test
	public void testRegister() throws Exception {
		String entityId = companyService.register(CompanyCvo.sample());
		
		assertNotNull(entityId);
	}

	@Test(expected = NoSuchElementException.class)
	public void testFindNoCompany() throws Exception {
		companyService.find("no-such-entity-id");
	}
	
	@Test
	public void testFindCompany() throws Exception {
		String entityId = companyService.register(CompanyCvo.sample());
		Company entity = companyService.find(entityId);
		
		assertNotNull(entity);
	}
	
	@Test
	public void testModify() throws Exception {
		String entityId = companyService.register(CompanyCvo.sample());
		
		String newName = "newName";
		AttributeList attributes = new AttributeList("name", newName);
		companyService.modify(entityId, attributes);
		Company entity = companyService.find(entityId);
		
		assertEquals(newName, entity.getName());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testRemove() throws Exception {
		String entityId = companyService.register(CompanyCvo.sample());
		companyService.remove(entityId);
		companyService.find(entityId);
	}
}
