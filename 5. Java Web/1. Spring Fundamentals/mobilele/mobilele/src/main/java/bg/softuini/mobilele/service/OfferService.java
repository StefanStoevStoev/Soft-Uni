package bg.softuini.mobilele.service;

import bg.softuini.mobilele.model.service.OfferServiceModel;
import bg.softuini.mobilele.model.view.OfferSummaryViewModel;

import java.util.List;

public interface OfferService {

    List<OfferSummaryViewModel> getAllOffers();

    long save(OfferServiceModel model);

    void delete(long id);
}
