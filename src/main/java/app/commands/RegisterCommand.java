package app.commands;

import app.models.bindingModels.user.RegisterUser;
import app.services.GameService;
import app.services.UserService;

public class RegisterCommand extends Command {

    public RegisterCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        RegisterUser registerUser=new RegisterUser();

        try {
            registerUser.setEmail(params[0]);
            registerUser.setPassword(params[1]);
            registerUser.setConfirmPassword(params[2]);
            registerUser.setFullName(params[3]);
            super.getUserService().persist(registerUser);
        } catch (Exception e){
            return e.getMessage();
        }

        return String.format("%s was registered!",params[3]);
    }
}
