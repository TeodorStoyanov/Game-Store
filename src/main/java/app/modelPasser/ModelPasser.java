package app.modelPasser;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.modelmapper.ModelMapper;

public class ModelPasser {

    private static ModelMapper modelMapper;

    public static ModelMapper getInstance(){

        if(modelMapper == null){
            modelMapper=new ModelMapper();
        }

        return modelMapper;
    }
}
