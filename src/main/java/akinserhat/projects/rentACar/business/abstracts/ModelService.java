package akinserhat.projects.rentACar.business.abstracts;

import java.util.List;

import akinserhat.projects.rentACar.business.requests.CreateModelRequest;
import akinserhat.projects.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
