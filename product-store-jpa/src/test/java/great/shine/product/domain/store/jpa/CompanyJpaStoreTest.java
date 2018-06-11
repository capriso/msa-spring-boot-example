package great.shine.product.domain.store.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import great.shine.product.domain.entity.Company;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyJpaStoreTest {
	@Autowired
	private CompanyJpaStore store;
	
	private Company entity;
	
	@TestConfiguration
	static class CompanyServiceTestContextConfiguration {
		@Bean
		public CompanyJpaStore companyJpaStore() {
			return new CompanyJpaStore();
		}
	}
	
	@Before
	public void setup() throws Exception {
		this.entity = Company.sample();
	}
	
	@Test
	public void testCreateAndRetrieve() throws Exception {
		store.create(this.entity);
		Company entity = store.retrieve(this.entity.getEntityId());
		
		assertNotNull(entity);
	}
	
	@Test
	public void testUpdate() throws Exception {
		store.create(this.entity);
		Company entity = store.retrieve(this.entity.getEntityId());
		
		String newName = "newName";
		entity.setName(newName);
		store.update(entity);
		
		Company newEntity = store.retrieve(this.entity.getEntityId());
		
		assertEquals(newName, newEntity.getName());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testDelete() throws Exception {
		store.create(this.entity);
		Company deletedEntity = store.retrieve(this.entity.getEntityId());
		store.delete(deletedEntity);
		
		store.retrieve(this.entity.getEntityId());
	}
	
	@Test
	public void testExists() throws Exception {
		store.create(this.entity);
		boolean exists = store.exists(this.entity.getEntityId());
		
		assertTrue(exists);
	}
	
	@Test
	public void testExistsByName() throws Exception {
		store.create(entity);
		boolean exists = store.existsByName(this.entity.getName());
		
		assertTrue(exists);
	}
}
