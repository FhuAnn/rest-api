package savingMoney.restapi.service;

import savingMoney.restapi.dto.ExpenseDto;

import java.util.List;
/***
 * Service interface for expense module
 * @author Phu An
 */
public interface ExpenseService {

    /***
     * It will fetch the expenses from database
     * @return list
     */
    List<ExpenseDto> getAllExpenses();
}
