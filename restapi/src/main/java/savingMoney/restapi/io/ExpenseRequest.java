package savingMoney.restapi.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseRequest {
    private String expenseId;
    private String Name;
    private String description;
    private String category;
    private Date date;
    private BigDecimal amount;
}
