package su.dataserver.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.dataserver.crud.models.Data;
import su.dataserver.crud.repository.DataRepository;

import java.util.List;

@Service
public class DataService {
    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<Data> getAll() {
        return dataRepository.findAll();
    }

    public Data findByName(String name) {
        return dataRepository.findDataByName(name).orElse(null);
    }

    public Double totalPrice() {
        return dataRepository.findAll()
                .stream()
                .mapToDouble(c -> c.getPrice() * c.getAmount())
                .sum();
    }

    public void save(Data data) {
        dataRepository.save(data);
    }
}