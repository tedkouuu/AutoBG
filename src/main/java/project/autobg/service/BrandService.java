package project.autobg.service;

import org.springframework.stereotype.Service;
import project.autobg.model.dto.BrandDTO;
import project.autobg.model.dto.ModelDTO;
import project.autobg.model.entity.BrandEntity;
import project.autobg.model.entity.ModelEntity;
import project.autobg.model.mapper.BrandMapper;
import project.autobg.model.mapper.ModelMapper;
import project.autobg.repository.BrandRepository;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;
    private final ModelMapper modelMapper;

    public BrandService(BrandRepository brandRepository, BrandMapper brandMapper, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
        this.modelMapper = modelMapper;
    }

    public List<BrandDTO> getAllBrands() {

        return brandRepository.
                findAll().
                stream().
                map(this::mapBrand).toList();
    }

    private BrandDTO mapBrand(BrandEntity brandEntity) {

        List<ModelDTO> models = brandEntity.
                getModels()
                .stream().
                map(this::mapModel).toList();

        return brandMapper.brandEntityToBrandDTO(brandEntity);

    }

    private ModelDTO mapModel(ModelEntity modelEntity) {

        return modelMapper.modelEntityToModelDTO(modelEntity);
    }
}
