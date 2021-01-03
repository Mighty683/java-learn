package Server;

public interface IPlayerSocket {
    void sendMessage(String message);

    String getName();
}
