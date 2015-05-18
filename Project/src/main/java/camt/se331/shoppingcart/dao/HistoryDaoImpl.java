package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.History;
import camt.se331.shoppingcart.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by KalumDog on 19/5/2558.
 */
@Repository
public class HistoryDaoImpl implements HistoryDao {
    @Autowired
    HistoryRepository historyRepository;



    @Override
    public List<History> getHistorys() {
        return historyRepository.findAll();
    }

    @Override
    public History getHistory(Long id) {
        return historyRepository.findOne(id);
    }



    @Override
    public History updateHistory(History history) {
        return historyRepository.save(history);
    }

}
