package donTouch.user_server.user.service;

import donTouch.user_server.user.domain.JpaUserRepository;
import donTouch.user_server.user.domain.Users;
import donTouch.user_server.user.dto.InvestmentTypeForm;
import donTouch.user_server.user.dto.UsersDto;
import donTouch.user_server.user.utils.EntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final JpaUserRepository jpaUserRepository;

    public UsersDto findUserByEmail(String email) {
        Users user = jpaUserRepository.findByEmail(email)
            .orElseThrow(()-> new NullPointerException("User not found"));
        return UsersDto.toDto(user);
    }


    public int updateInvestmentType(InvestmentTypeForm investmentTypeForm){
        Users user = jpaUserRepository.findById(investmentTypeForm.getUserId())
                .orElseThrow(()-> new NullPointerException("유저 정보가 없습니다."));

        Integer score = investmentTypeForm.getTotalScore();
        int result;

        if(score<0){
            throw new NullPointerException("점수는 0 또는 양수로 입력하세요.");
        }else if(score <=  7 ){
            result = 1; // 안정형
        }else if(score <= 14){
            result = 2; // 안정추구형
        }else if(score <= 21){
            result = 3; // 위험중립형
        }else if(score <= 28){
            result = 4; // 적극투자형
        }else{
            result = 5; //공격투자형
        }

        user.setInvestmentType(result);
        jpaUserRepository.save(user);

        return result;
    }
}
