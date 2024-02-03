package project.autobg.model.mapper;

import org.mapstruct.Mapper;
import project.autobg.model.dto.BrandDTO;
import project.autobg.model.entity.BrandEntity;

@Mapper(componentModel = "spring", uses = ModelMapper.class)
public interface BrandMapper {

    BrandDTO brandEntityToBrandDTO(BrandEntity brandEntity);


}
