package org.shark.crud;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shark.crud.model.dto.BoardDTO;
import org.shark.crud.model.dto.UserDTO;
import org.shark.crud.repository.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  //----- JUnit4를 이용한 테스트

@ContextConfiguration(locations = {  //----- Test 시 필요한 빈(Bean)을 찾을 장소를 작성합니다. (root-context.xml의 4개 빈과 BoardDAO 빈)
    "file:src/main/webapp/WEB-INF/spring/root-context.xml"  //---------------- root-context.xml
  , "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"  //-- @Repository는 component-scan이 있어야 동작하므로 추가
})

public class UserDAOUnitTest {

  @Autowired
  private BoardDAO boardDao;
  
  @Test
  public void 목록_가져오기_테스트() {
//    assertEquals(3, boardDao.getBoards().size());
    assertEquals("나는 호랑이", boardDao.getBoards().get(1).getTitle());
  }
  
  @Test
  public void 신규등록_테슽() {
    UserDTO user = UserDTO.builder()
                      .uid(3)
                      .build();
    BoardDTO board = BoardDTO.builder()
                        .title("테스트죄목")
                        .content("테슽흐내용")
                        .user(user)
                        .build();
    assertEquals(1, boardDao.insertBoard(board));
  }

}
