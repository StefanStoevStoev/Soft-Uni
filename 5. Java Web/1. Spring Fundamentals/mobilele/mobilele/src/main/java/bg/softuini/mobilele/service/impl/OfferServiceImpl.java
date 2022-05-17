package bg.softuini.mobilele.service.impl;

import bg.softuini.mobilele.model.entities.OfferEntity;
import bg.softuini.mobilele.model.service.OfferServiceModel;
import bg.softuini.mobilele.model.view.OfferSummaryViewModel;
import bg.softuini.mobilele.repository.ModelRepository;
import bg.softuini.mobilele.repository.OfferRepository;
import bg.softuini.mobilele.repository.UserRepository;
import bg.softuini.mobilele.security.CurrentUser;
import bg.softuini.mobilele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final CurrentUser currentUser;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(CurrentUser currentUser
            , OfferRepository offerRepository
            , UserRepository userRepository
            , ModelRepository modelRepository
            , ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
        //TODO;

        throw new UnsupportedOperationException("Comming soon");
    }

    @Override
    public long save(OfferServiceModel model) {
        OfferEntity offerEntity = asNewEntity(model);
        OfferEntity newEntity = offerRepository.save(offerEntity);
        return newEntity.getId();
    }

    @Override
    public void delete(long id) {
        offerRepository.deleteById(id);
    }

    private OfferEntity asNewEntity(OfferServiceModel model){
        OfferEntity offerEntity = new OfferEntity();
        modelMapper.map(model,offerEntity);
        offerEntity.setId(null);
        offerEntity.setModel(modelRepository.findById(model.getModelId()).orElseThrow());
        offerEntity.setUser(userRepository.findByUsername(currentUser.getName()).orElseThrow());
        return offerEntity;
    }
}
