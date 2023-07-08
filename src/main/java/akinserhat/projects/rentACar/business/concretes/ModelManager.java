package akinserhat.projects.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import akinserhat.projects.rentACar.business.abstracts.ModelService;
import akinserhat.projects.rentACar.business.requests.CreateModelRequest;
import akinserhat.projects.rentACar.business.responses.GetAllModelsResponse;
import akinserhat.projects.rentACar.core.utilities.mappers.ModelMapperService;
import akinserhat.projects.rentACar.dataAccess.abstracts.ModelRepository;
import akinserhat.projects.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model -> this.modelMapperService.forResponse()
						.map(model, GetAllModelsResponse.class)).toList();

		return modelsResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest()
				.map(createModelRequest, Model.class);
		
		this.modelRepository.save(model);
	}

}
