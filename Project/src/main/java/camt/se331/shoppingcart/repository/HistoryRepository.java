package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by KalumDog on 19/5/2558.
 */
public interface HistoryRepository extends JpaRepository<History,Long> {
}
