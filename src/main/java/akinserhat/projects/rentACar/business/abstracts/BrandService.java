package akinserhat.projects.rentACar.business.abstracts;

import java.util.List;

import akinserhat.projects.rentACar.business.requests.CreateBrandRequest;
import akinserhat.projects.rentACar.business.requests.UpdateBrandRequest;
import akinserhat.projects.rentACar.business.responses.GetAllBrandsResponse;
import akinserhat.projects.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}
