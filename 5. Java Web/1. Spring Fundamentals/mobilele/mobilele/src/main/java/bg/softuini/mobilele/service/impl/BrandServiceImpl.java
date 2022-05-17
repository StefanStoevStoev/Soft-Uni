package bg.softuini.mobilele.service.impl;

import bg.softuini.mobilele.model.entities.BrandEntity;
import bg.softuini.mobilele.model.entities.ModelEntity;
import bg.softuini.mobilele.model.view.BrandViewModel;
import bg.softuini.mobilele.model.view.ModelViewModel;
import bg.softuini.mobilele.repository.ModelRepository;
import bg.softuini.mobilele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService  {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {

        List<BrandViewModel> result = new ArrayList<>(); // <- final result here

        List<ModelEntity> allModels = modelRepository.findAll();

        allModels.forEach(me -> {
            // example: fiesta -> ford
            BrandEntity brandEntity = me.getBrand();
            Optional<BrandViewModel> brandViewModelOpt = findByName(result,
                    brandEntity.getName());
            if(!brandViewModelOpt.isPresent()){
                // not yet in the result, we will create a new model
                BrandViewModel newBrandViewModel = new BrandViewModel();
                modelMapper.map(brandEntity, newBrandViewModel);//////////////////
                result.add(newBrandViewModel);
                brandViewModelOpt = Optional.of(newBrandViewModel);
            }

            ModelViewModel newModelViewModel = new ModelViewModel();
            modelMapper.map(me, newModelViewModel);
            brandViewModelOpt.get().addModel(newModelViewModel);///////////
        });

        return result;
    }
    private static Optional<BrandViewModel> findByName(List<BrandViewModel> allModels, String name){
       return allModels.
               stream().
               filter(m -> m.getName().equals(name)).
               findAny();
    }
}
