package org.shark.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.shark.mvc.model.dto.BoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/c")
@Controller
public class MvcControllerC {

  List<BoardDTO> boards = new ArrayList<BoardDTO>();
  
  public MvcControllerC() {
    boards.add(new BoardDTO("제목1", 20));
    boards.add(new BoardDTO("제목2", 10));
    boards.add(new BoardDTO("제목3", 30));
  }
  
  /******************************** forward ********************************/
  
  //----- ModelAndView를 이용한 forward (데이터 전달)
  @RequestMapping("/list")
  public ModelAndView methodA() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("c/list");
    mv.addObject("boards", boards);  // JSP로 전달되는 데이터 boards
    return mv;
  }
  
  //----- Model을 이용한 forward (데이터 전달)
  @RequestMapping("/detail")  //----- 요청 주소 : /c/detail?bid=1
  public String methodB(Model model  //----- JSP로 전달할 데이터를 저장할 Model
                      , int bid) {  //------ @RequestParam 생략
    
    model.addAttribute("board", boards.get(bid));  //-- JSP로 전달되는 데이터 board
    return "c/detail";    
  }
  
  /******************************** redirect ********************************/
  
  //----- RedirectAttributes를 이용한 redirect
  @RequestMapping("/regist")  //----- 요청 주소 : /c/regist?title=신규제목&hit=0
  public String methodC(RedirectAttributes rAttr
                      , String title
                      , int hit) {
    
    //----- 등록
    boolean result = boards.add(new BoardDTO(title, hit));
    
    //----- 등록 결과에 따른 메시지
    String msg = result ? "등록 성공" : "등록 실패";
    
    //----- 메시지를 전달 (리다이렉트할 장소로 전달하는 경우 Flash Attribute 형태로 저장합니다.)
    rAttr.addFlashAttribute("msg", msg);
    
    //----- redirect (새로운 요청 주소로 리다이렉트 구성)
    return "redirect:/c/list";
    
  }
  
  
  
  
  
  
  
  
  
}
