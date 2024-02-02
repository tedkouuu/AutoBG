package project.autobg.model.dto;

import jakarta.validation.constraints.NotNull;
import project.autobg.model.enums.EngineEnum;
import project.autobg.model.enums.TransmissionEnum;

public class AddOfferDTO {

    @NotNull
    private EngineEnum engine;

    @NotNull
    private TransmissionEnum transmission;

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public AddOfferDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public AddOfferDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }
}
