package project.autobg.model.mapper;

import org.mapstruct.Mapper;
import project.autobg.model.dto.AddOfferDTO;
import project.autobg.model.entity.OfferEntity;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);
}
