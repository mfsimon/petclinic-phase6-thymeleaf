package com.example.petclinic.controller;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Visit;
import com.example.petclinic.service.OwnerService;
import com.example.petclinic.service.PetService;
import com.example.petclinic.service.VetService;
import com.example.petclinic.service.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebController {

    private OwnerService ownerService;
    private PetService petService;
    private VisitService visitService;
    private VetService vetService;

    public WebController(OwnerService ownerService, PetService petService, VisitService visitService, VetService vetService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.visitService = visitService;
        this.vetService = vetService;
    }

    @GetMapping("/")
    public String hello(Model model) {

        return "index";
    }

    @GetMapping("owner")
    public String showOwners(Model model) {

        model.addAttribute("owners", ownerService.getAllOwners());
        return "owner";
    }

    @GetMapping("addOwner")
    public String addOwner(Model model) {

        Owner owner = Owner.builder().build();
        model.addAttribute("owner", owner);
        return "addowner";
    }

    @PostMapping("submitOwner")
    public String submitOwner(Owner owner) {

       ownerService.saveOwner(owner);
        return "submitOwner";
    }

    @GetMapping("pet")
    public String showPets(Model model) {

        model.addAttribute("pets", petService.getAllPets());
        return "pet";
    }

    @GetMapping("addPet")
    public String addPet(Model model) {

        return "addpet";
    }

    @GetMapping("visit")
    public String showVisit(Model model) {

        List<Visit> visits = visitService.getAllVisits();
        model.addAttribute("visits", visits);
        return "visit";
    }

    @GetMapping("addVisit")
    public String addVisit(Model model) {

        return "addvisit";
    }

    @GetMapping("vet")
    public String showOwner(Model model) {

        model.addAttribute("vets", vetService.getAllVets());
        return "vet";
    }

    @GetMapping("addVet")
    public String addVet(Model model) {

        return "addvet";
    }

}
