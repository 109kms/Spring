package org.shark.crud.service;

import org.shark.crud.model.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  UserDTO findUserByEmailAndPassword(UserDTO user);
}
