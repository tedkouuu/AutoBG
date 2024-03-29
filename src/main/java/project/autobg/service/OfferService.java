package project.autobg.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private final UserDetailsService autoBGUserDetailsService;


    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper, UserRepository userRepository, ModelRepository modelRepository, UserDetailsService autoBGUserDetailsService) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.autoBGUserDetailsService = autoBGUserDetailsService;
    }

    public void addOffer(AddOfferDTO addOfferDTO, UserDetails userDetails) {

        OfferEntity newOffer = offerMapper.addOfferDtoToOfferEntity(addOfferDTO);

        ModelEntity model = modelRepository.findById(addOfferDTO.getModelId()).
                orElseThrow();

        UserEntity seller = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);

    }
}
