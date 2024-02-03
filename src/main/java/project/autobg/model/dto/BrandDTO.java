package project.autobg.model.dto;

import java.util.ArrayList;
import java.util.List;

public class BrandDTO {

    private String name;

    private List<ModelDTO> models;

    public BrandDTO setModels(List<ModelDTO> models) {
        this.models = models;
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelDTO> getModels() {
        return models;
    }

    public BrandDTO addModel(ModelDTO modelDTO) {

        if (this.models == null) {
            this.models = new ArrayList<>();
        }

        this.models.add(modelDTO);
        return this;
    }
}
