package akinserhat.projects.rentACar.business.abstracts;

import java.util.List;

import akinserhat.projects.rentACar.business.requests.CreateBrandRequest;
import akinserhat.projects.rentACar.business.responses.GetAllBrandsResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
}
