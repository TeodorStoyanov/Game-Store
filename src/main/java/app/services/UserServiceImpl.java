package app.services;

import app.entities.User;
import app.entities.enums.Role;
import app.modelPasser.ModelPasser;
import app.models.bindingModels.user.RegisterUser;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void persist(RegisterUser registerUser) {
        User user= ModelPasser.getInstance().map(registerUser,User.class);

        if(this.userRepository.findAll().size()>0){
            user.setRole(Role.USER);
        }
        else {
            user.setRole(Role.ADMIN);
        }
        this.userRepository.saveAndFlush(user);
    }
}
