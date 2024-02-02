package project.autobg.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.autobg.model.dto.UserRegisterDTO;
import project.autobg.model.entity.UserEntity;

// UserMapper automatically is being recognised as a bean
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDTO userRegisterDTO);

}
