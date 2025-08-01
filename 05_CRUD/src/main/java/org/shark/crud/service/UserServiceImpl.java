package org.shark.crud.service;

import org.shark.crud.model.dto.UserDTO;
import org.shark.crud.repository.UserDAO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserDAO userDAO;
  
  
  @Override
  public UserDTO findUserByEmailAndPassword(UserDTO user) {
    return userDAO.getUser(user);
  }

}
