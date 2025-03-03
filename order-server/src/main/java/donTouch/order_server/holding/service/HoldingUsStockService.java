package donTouch.order_server.holding.service;

import donTouch.order_server.holding.domain.HoldingUsStock;
import donTouch.order_server.holding.dto.HoldingUsStockDto;
import donTouch.order_server.holding.dto.HoldingUsStockFindForm;
import donTouch.order_server.holding.dto.PurchaseInfoDTO;

import java.util.List;

public interface HoldingUsStockService {
    List<String> findHoldingStockIds(Long userId);

    HoldingUsStock save(HoldingUsStockDto holdingUsStockDto);

    HoldingUsStock findHolding(Long userId, String krHoldingStockId);

    HoldingUsStock sellStockUpdate(HoldingUsStockFindForm holdingUsStockFindForm);

    List<PurchaseInfoDTO> findHoldingStockInfos(Long userId, List<String> symbols);
}
