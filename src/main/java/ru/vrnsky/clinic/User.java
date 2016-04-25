package ru.vrnsky.clinic;

/**
 * Model of typical user which have id and name
 */
public class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }


//    @Override
//    public boolean equals(Object o) {
//
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//
//        User user = (User) o;
//
//        if (id != user.id) return false;
//        return name.equals(user.name);
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + name.hashCode();
//        return result;
//    }
}
