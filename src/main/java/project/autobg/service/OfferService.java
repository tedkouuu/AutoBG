package project.autobg.service;

import org.springframework.stereotype.Service;
import project.autobg.model.dto.AddOfferDTO;
import project.autobg.model.entity.ModelEntity;
import project.autobg.model.entity.OfferEntity;
import project.autobg.model.entity.UserEntity;
import project.autobg.model.mapper.OfferMapper;
import project.autobg.repository.ModelRepository;
import project.autobg.repository.OfferRepository;
import project.autobg.repository.UserRepository;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;

    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper, UserRepository userRepository, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
    }

//    public void addOffer(AddOfferDTO addOfferDTO) {
//
//        OfferEntity newOffer = offerMapper.addOfferDtoToOfferEntity(addOfferDTO);
//
//        UserEntity userEntity = userRepository.findByEmail(currentUser.getEmail()).
//                orElseThrow();
//
//        ModelEntity model = modelRepository.findById(addOfferDTO.getModelId()).
//                orElseThrow();
//
//        newOffer.setModel(model);
//        newOffer.setSeller(userEntity);
//
//        offerRepository.save(newOffer);

    }
//}
