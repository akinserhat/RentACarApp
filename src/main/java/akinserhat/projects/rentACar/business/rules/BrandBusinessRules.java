package akinserhat.projects.rentACar.business.rules;

import org.springframework.stereotype.Service;

import akinserhat.projects.rentACar.core.utilities.exceptions.BusinessException;
import akinserhat.projects.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand already exists");
		}
	}
}
