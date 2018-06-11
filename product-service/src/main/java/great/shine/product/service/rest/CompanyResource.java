package great.shine.product.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import great.shine.common.domain.AttributeList;
import great.shine.product.domain.entity.Company;
import great.shine.product.domain.service.CompanyService;
import great.shine.product.domain.service.vo.CompanyCvo;
import great.shine.product.service.container.CompanySpringService;

@RestController
@RequestMapping("/company")
public class CompanyResource implements CompanyService {

	@Autowired
	private CompanySpringService companySpringService;
	
	public CompanyResource() {
		
	}
	
	@PostMapping("/")
	@Override
	public String register(@RequestBody CompanyCvo vo) {
		return companySpringService.register(vo);
	}

	@GetMapping("/{entityId}")
	@Override
	public Company find(@PathVariable String entityId) {
		return companySpringService.find(entityId);
	}

	@PutMapping("/{entityId}")
	@Override
	public void modify(@PathVariable String entityId, @RequestBody AttributeList attributes) {
		companySpringService.modify(entityId, attributes);
	}

	@DeleteMapping("/{entityId}")
	@Override
	public void remove(@PathVariable String entityId) {
		companySpringService.remove(entityId);
	}

}
