package su.dataserver.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import su.dataserver.crud.models.Data;
import su.dataserver.crud.service.DataService;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public List<Data> findAll() {
        return dataService.getAll();
    }

    @GetMapping("/total")
    public Double getTotalPrice() {
        return dataService.totalPrice();
    }


    @GetMapping("/find")
    public Data findByName(
            @RequestParam(defaultValue = "") String name
    ) {
        return dataService.findByName(name);
    }

    @PostMapping
    public void save(
            @RequestBody Data data
    ) {
        dataService.save(data);
    }

}