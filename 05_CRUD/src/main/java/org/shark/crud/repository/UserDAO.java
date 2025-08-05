package org.shark.crud.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.shark.crud.model.dto.UserDTO;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  //----- SqlSessionTemplate template 빈(Bean) 자동 주입(@Autowired) 처리를 위한 생성자
@Repository  //----- DAO 레벨에서 사용하는 @Component
public class UserDAO {

  private final SqlSessionTemplate template;
  
  //----- 조회 (회원 정보)
  public UserDTO getUserByEmailAndPassword(UserDTO user) {
    return template.selectOne("mybatis.mapper.userMapper.getUser", user);
  }
  
  public UserDTO getUserByNickname(String nickname) {
    return template.selectOne("mybatis.mapper.userMapper.getUserByNickname", nickname);
  }
  
  // 조회 (회원 정보)
  public UserDTO getUserByEmail(String email) {
    return template.selectOne("mybatis.mapper.userMapper.getUserByEmail", email);
  }
  
  public int insertUser(UserDTO user) {
    return template.insert("mybatis.mapper.userMapper.insertUser", user);
  }
  
}
