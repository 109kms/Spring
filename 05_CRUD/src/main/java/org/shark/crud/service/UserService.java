package org.shark.crud.service;

import org.shark.crud.model.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  UserDTO login(UserDTO user);
  UserDTO findUserByNickname(String nickname);
  UserDTO findUserByEmail(String email);
  boolean signUp(UserDTO user);
}
