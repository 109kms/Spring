package org.shark.mvc.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BoardList {

  private List<BoardDTO> boards;
  
  public BoardList() {
    boards = new ArrayList<BoardDTO>();
  }
  
  public void add(BoardDTO board) {
    boards.add(board);
  }
  
}
