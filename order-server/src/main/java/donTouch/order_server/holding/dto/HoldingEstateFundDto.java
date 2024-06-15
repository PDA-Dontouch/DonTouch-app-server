package donTouch.order_server.holding.dto;

import java.sql.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class HoldingEstateFundDto {
    private int id;
    private Long userId;
    private int estateFundId;
    private int inputCash;
    private String estateName;
    private double estateEarningRate;
    private Date createAt;
}