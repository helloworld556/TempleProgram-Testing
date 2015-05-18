package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.History;
import camt.se331.shoppingcart.entity.Image;

import java.util.List;

/**
 * Created by KalumDog on 19/5/2558.
 */
public interface HistoryService {
    List<History> getHistorys();

    History getHistory(Long id);

    History updateHistory(History history);


    History addImage(History history, Image image);
}
