package donTouch.order_server.holding.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HoldingStockDTO {
    private String exchange;
    private Integer stockId;
}
