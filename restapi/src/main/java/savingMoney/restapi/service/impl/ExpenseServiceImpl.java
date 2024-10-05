package savingMoney.restapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import savingMoney.restapi.dto.ExpenseDto;
import savingMoney.restapi.entity.ExpenseEntity;
import savingMoney.restapi.repository.ExpenseRepository;
import savingMoney.restapi.service.ExpenseService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;
/***
 * service implementation for Expense module
 * @author  Phu An
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    /***
     * It will fetch the expenses from database
     * @return list
     */
    @Override
    public List<ExpenseDto> getAllExpenses() {
        //Call the repository  method
        List<ExpenseEntity> list = expenseRepository.findAll();
        log.info("Printing the data from repository {}",list);
        //convert the Entity object to DTO object
        List<ExpenseDto> listOfExpense = list.stream().map(expenseEntity -> mapToExpenseDto(expenseEntity)).collect(Collectors.toList());
        //return the list
        return listOfExpense;
    }

    /***
     * Mapper method  to convert expense entity to expense dto
     * @param expenseEntity
     * @return expenseDTO
     */

    private ExpenseDto mapToExpenseDto(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity,ExpenseDto.class);
    }
}
