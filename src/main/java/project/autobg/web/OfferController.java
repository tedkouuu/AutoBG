package project.autobg.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.autobg.model.dto.AddOfferDTO;
import project.autobg.service.BrandService;
import project.autobg.service.OfferService;

@Controller
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/offers/all")
    public String allOffers() {
        return "all-offers";
    }

    @GetMapping("/offers/add")
    public String addOffer(Model model) {

        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", new AddOfferDTO());
        }

        model.addAttribute("brands", brandService.getAllBrands());

        return "offers-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid AddOfferDTO addOfferDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("addOfferDTO", addOfferDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", bindingResult);


            return "redirect:/offers/add";
        }

        offerService.addOffer(addOfferDTO);
        return "redirect:/";
    }
}

