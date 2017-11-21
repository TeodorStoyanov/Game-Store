package app.services;

import app.models.bindingModels.user.RegisterUser;

public interface UserService {

    void persist(RegisterUser registerUser);
}
