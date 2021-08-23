public class User {
    private String name;
    private int age;
    private Boolean isRegistered;

    public Boolean getRegistared(){
        return isRegistered;
    }

    public void setRegistared(Boolean isRegistared){
        this.isRegistered = isRegistared;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
         this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public User(String name, Integer age, Boolean isRegistared) {
        this.name = name;
        this.age = age;
        this.isRegistered = isRegistared;
    }
}
