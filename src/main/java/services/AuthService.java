package services;

import models.API.User;

public interface AuthService extends BasicService{
    User createUser(User user);
    User loginUser(User user);
}
