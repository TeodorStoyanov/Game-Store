package app;

import app.commands.Executable;
import app.commands.RegisterCommand;
import app.services.GameService;
import app.services.UserService;

public class CommandFactory {
    private UserService userService;
    private GameService gameService;

    public CommandFactory(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    public Executable getCommand(String command){

        switch (command){
            case "Register":
                return new RegisterCommand(this.userService,this.gameService);
        }

        return null;
    }
}
