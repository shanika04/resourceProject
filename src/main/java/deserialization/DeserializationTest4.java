package deserialization;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Set;
import java.util.UUID;
import java.io.ObjectInputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeserializationTest4 {
    @PostMapping("/test")
    public void test(FileInputStream fileIS)
        throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(fileIS);
        ParentClass button = (ParentClass) in.readObject();
        ObjectClass specificButton = (ObjectClass) button;
        in.close();
    }
}

class ParentClass {
    private int val = 0;

    public ParentClass(int value){
        this.val = value;
    }
}

class ObjectClass extends ParentClass {
    private SecondObjectClass obj = null;

    public ObjectClass(int value){
        super(value);
        this.obj = new SecondObjectClass(value);
    }
}

class SecondObjectClass {
    private int val = 0;
    private Set<String> setVal = null;

    public SecondObjectClass(int value){
        this.val = value;
    }
}