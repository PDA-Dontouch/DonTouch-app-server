package donTouch.estate_server.estate;

import donTouch.estate_server.estate.dto.EstateFundDetailDto;
import donTouch.estate_server.estate.service.EstateFundDetailService;
import donTouch.utils.utils.ApiUtils;
import donTouch.utils.utils.ApiUtils.ApiResult;
import donTouch.estate_server.estate.dto.EstateFundDto;
import donTouch.estate_server.estate.service.DataAccessService;
import donTouch.estate_server.estate.service.EstateFundService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class EstateRestController {
    private final EstateFundService estateFundService;
    private final EstateFundDetailService estateFundDetailService;

    @GetMapping("/api/estates")
    public ApiResult<List<EstateFundDto>> getAllEstates(){
        try{
            List<EstateFundDto> resultList = estateFundService.getAllEstateFund();
            return ApiUtils.success(resultList);
        }catch (NullPointerException e){
            return ApiUtils.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/api/estates/{estateId}")
    public ApiResult<EstateFundDetailDto> getEstate(@PathVariable int estateId){
        try{
            EstateFundDetailDto result = estateFundDetailService.findEstateInfoById(estateId);
            return ApiUtils.success(result);
        }catch (NullPointerException e){
            return ApiUtils.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
