package com.clockworkjava.castle.controller;

import com.clockworkjava.castle.components.TimeComponent;
import com.clockworkjava.castle.domain.Knight;
import com.clockworkjava.castle.domain.PlayerInformation;
import com.clockworkjava.castle.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInformation playerInformation;

    @Autowired
    KnightService knightService;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnights = knightService.getAllKnights();
        model.addAttribute("knights", allKnights);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knight";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnight(@Valid Knight knight, BindingResult bindingResult) { //valid - sprawdzanie, czy podano poprawne wartosci

        if(bindingResult.hasErrors()) {
            System.out.println("There were errors!");
            bindingResult.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage());
            });
            return "knightform";
        }
        else {

            knightService.saveKnight(knight);
            return "redirect:/knights";
        }
    }

    @RequestMapping("knight/edit")
    public String editName(@PathParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knightEdit";
    }

    @RequestMapping(value = "/editName", method = RequestMethod.POST)
    public String editingName(Knight knight, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            System.out.println("There were errors!");
            bindingResult.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage());
            });
            return "knightEdit"; }
            else {
                knightService.updateKnight(knight);
                return "redirect:/knights";
            }
    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id) {
        knightService.deleteKnight(id);
        return "redirect:/knights";
    }
}
