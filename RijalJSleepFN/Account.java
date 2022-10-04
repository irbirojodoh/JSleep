package RijalJSleepFN;


public class Account extends Serializable implements FileParser  {
    public String name;
    public String email;
    public String password;

    /** */
    public Account(int id, String name, String email, String password){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString() {
        return "email=" + this.email + ", name=" + this.name + ", password=" + this.password ;
    }

    @Override
    public boolean read(String xxx){
        return true;
    }

    @Override
    public Object write(){
        return null;
    }
    
}


