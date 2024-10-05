package savingMoney.restapi.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import savingMoney.restapi.dto.ExpenseDto;
import savingMoney.restapi.io.ExpenseResponse;
import savingMoney.restapi.service.ExpenseService;

import java.util.List;
import java.util.stream.Collectors;
/**
 * This is controller classs for Expense module
 * */
@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

/**
 * It will fetch the expenses from the database
 * @return list
 * */

    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpense()
    {
        log.info("API GET /expenses called");
        //Call the service method
        List<ExpenseDto> list = expenseService.getAllExpenses();
        log.info("Printing the data from service {}",list);
        //Convert the expense DTO to Expense Respond
        List<ExpenseResponse> responses = list.stream().map(expenseDto -> mapToExpenseRespond(expenseDto)).collect(Collectors.toList());
        //return the list/respond
       return  responses;
    }

    /**
     * Mapper method for converting expense dto object to expense response
     * @param expenseDto
     * return ExpenseResponse
     * */
    private ExpenseResponse mapToExpenseRespond(ExpenseDto expenseDto) {
        return modelMapper.map(expenseDto, ExpenseResponse.class);
    }
}
