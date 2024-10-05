package savingMoney.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import savingMoney.restapi.entity.ExpenseEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {


}
