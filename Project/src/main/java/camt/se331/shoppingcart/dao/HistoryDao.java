package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.History;

import java.util.List;

/**
 * Created by KalumDog on 19/5/2558.
 */
public interface HistoryDao {
    List<History> getHistorys();


    History getHistory(Long id);
    History updateHistory(History history);
}
