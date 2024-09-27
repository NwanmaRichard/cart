package com.example.cart.service.user;

import com.example.cart.dto.UserDto;
import com.example.cart.model.User;
import com.example.cart.request.CreateUserRequest;
import com.example.cart.request.UserUpdateRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser (Long userId);

    //Helper method for converting user to the userDto
    UserDto convertUserToDto(User user);

    User getAuthenticatedUser();
}
