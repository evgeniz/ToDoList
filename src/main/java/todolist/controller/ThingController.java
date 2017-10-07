package todolist.controller;

import org.springframework.web.bind.annotation.*;
import todolist.model.Thing;
import todolist.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ThingController {

    private ThingService thingService;

    @Autowired(required = true)
    @Qualifier(value = "thingService")
    public void setThingService(ThingService thingService) {
        this.thingService = thingService;
    }

    @RequestMapping(value = "todolist", method = RequestMethod.GET)
    public String getToDoList(Model model){
        model.addAttribute("thing", new Thing());
        model.addAttribute("todolist", thingService.getToDoList());

        return "todolist";
    }

    @RequestMapping(value = "/todolist/add", method = RequestMethod.POST)
    public String addThing(@ModelAttribute("thing") Thing thing){
        if(thing.getId() == 0){
            thingService.addThing(thing);
        }else {
            thingService.updateThing(thing);
        }

        return "redirect:/todolist";
    }

    @RequestMapping("/remove/{id}")
    public String removeThing(@PathVariable("id") int id){
        thingService.removeThing(id);

        return "redirect:/todolist";
    }

    @RequestMapping("edit/{id}")
    public String editThing(@PathVariable("id") int id, Model model){
        model.addAttribute("thing", thingService.getThingById(id));
        model.addAttribute("todolist", thingService.getToDoList());

        return "todolist";
    }

    @RequestMapping("thingdata/{id}")
    public String thingData(@PathVariable("id") int id, Model model){
        model.addAttribute("thing", thingService.getThingById(id));

        return "thingdata";
    }
}
