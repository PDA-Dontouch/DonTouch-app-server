package donTouch.stock_server.dividend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class DividendDTO {
    private Integer id;

    private LocalDate dividendDate;
    private Boolean isFixed;

    private String symbol;
    private String name;
    private Long quantity;
    private Long dividend;

    private LocalDate paymentDate;
}
