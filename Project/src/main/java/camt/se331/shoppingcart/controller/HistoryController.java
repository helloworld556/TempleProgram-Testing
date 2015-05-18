package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.History;
import camt.se331.shoppingcart.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by KalumDog on 19/5/2558.
 */
@RestController
@RequestMapping("/")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @RequestMapping(value = "history",method = RequestMethod.GET)
    public List<History> list(){
        return historyService.getHistorys();
    }


    @RequestMapping(value = "history/{id}",method = RequestMethod.GET)
    public  History getHistory(@PathVariable("id") Long id){
        return historyService.getHistory(id);
    }

    @RequestMapping(value = "history/{id}",method = RequestMethod.PUT)
    public  History edit(@PathVariable("id") Long id,@RequestBody History history, BindingResult bindingResult){
        return historyService.updateHistory(history);
    }

}
