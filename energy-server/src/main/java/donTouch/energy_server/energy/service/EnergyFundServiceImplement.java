package donTouch.energy_server.energy.service;

import donTouch.energy_server.energy.domain.EnergyFund;
import donTouch.energy_server.energy.domain.EnergyFundJpaRepository;
import donTouch.energy_server.energy.dto.EnergyFundDto;
import donTouch.energy_server.utils.EnergyFundMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EnergyFundServiceImplement implements EnergyFundService{

    private final EnergyFundJpaRepository energyRepository;
    private final EnergyFundMapper energyMapper = EnergyFundMapper.INSTANCE;

    @Override
    public List<EnergyFundDto> getAllEnergyFund() {
        List<EnergyFund> energyFundList = energyRepository.findAll();
        if (energyFundList.isEmpty()) {
            throw new NullPointerException("EstateFund List is empty");
        }
        List<EnergyFundDto> estateFundDtoList = new ArrayList<>();
        energyFundList.forEach(estateFund -> {
            EnergyFundDto dto = energyMapper.toDto(estateFund);
            estateFundDtoList.add(dto);
        });
        return estateFundDtoList;
    }
}