public class User {
    private final String username;
    private final String password;  // In a real application, never store plain text passwords

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }
}


