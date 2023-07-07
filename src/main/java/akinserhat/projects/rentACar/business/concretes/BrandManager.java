package akinserhat.projects.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import akinserhat.projects.rentACar.business.abstracts.BrandService;
import akinserhat.projects.rentACar.business.requests.CreateBrandRequest;
import akinserhat.projects.rentACar.business.requests.UpdateBrandRequest;
import akinserhat.projects.rentACar.business.responses.GetAllBrandsResponse;
import akinserhat.projects.rentACar.business.responses.GetByIdBrandResponse;
import akinserhat.projects.rentACar.core.utilities.mappers.ModelMapperService;
import akinserhat.projects.rentACar.dataAccess.abstracts.BrandRepository;
import akinserhat.projects.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllBrandsResponse> getAll() {

//		List<Brand> brands = brandRepository.findAll();
//		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
//		
//		for (Brand brand : brands) {
//			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//			responseItem.setId(brand.getId());
//			responseItem.setName(brand.getName());
//			brandsResponse.add(responseItem); }

		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class)).toList();

		return brandsResponse;
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response = this.modelMapperService.forResponse()
				.map(brand, GetByIdBrandResponse.class);
		return response;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		// Brand brand = new Brand();
		// brand.setName(createBrandRequest.getName());

		Brand brand = this.modelMapperService.forRequest()
				.map(createBrandRequest, Brand.class);

		this.brandRepository.save(brand);

	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest()
				.map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);

	}

}
