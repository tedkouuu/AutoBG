package project.autobg.model.mapper;

import org.mapstruct.Mapper;
import project.autobg.model.dto.ModelDTO;
import project.autobg.model.entity.ModelEntity;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    ModelDTO modelEntityToModelDTO(ModelEntity modelEntity);

}
