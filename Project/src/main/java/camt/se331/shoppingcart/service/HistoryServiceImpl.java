package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.HistoryDao;
import camt.se331.shoppingcart.entity.History;
import camt.se331.shoppingcart.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by KalumDog on 19/5/2558.
 */
@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryDao historyDAO;

    @Override
    public List<History> getHistorys() {
        return historyDAO.getHistorys();
    }


    @Override
    public History getHistory(Long id) {
        return historyDAO.getHistory(id);
    }


    @Override
    public History updateHistory(History history) {
        return historyDAO.updateHistory(history);
    }



    @Override

    public History addImage(History history, Image image) {
        history.getImages().add(image);
        historyDAO.updateHistory(history);
        return history;
    }
}
