package com.RijalJSleepFN;


public class Account extends Serializable    {
    public String name;
    public String email;
    public String password;

    public static final String REGEX_PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    public static final String REGEX_EMAIL = "^[a-zA_Z0-9]+@[a-zA-Z.]+.[a-zA-Z.]+[a-zA-Z]$";

    /** */
    public Account(String name, String email, String password){
       // super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean validate(){
        return this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD);
    }

    public String toString() {
        return "email=" + this.email + ", name=" + this.name + ", password=" + this.password ;
    }

    //@Override
    public boolean read(String xxx){
        return true;
    }

    //@Override
    public Object write(){
        return null;
    }
    
}


