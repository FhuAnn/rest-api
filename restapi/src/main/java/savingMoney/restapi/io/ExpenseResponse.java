package savingMoney.restapi.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseResponse  {
    private String Name;
    private String description;
    private String category;
    private Date date;
    private BigDecimal amount;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
