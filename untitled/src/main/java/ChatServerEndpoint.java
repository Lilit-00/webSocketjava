import org.glassfish.tyrus.server.Server;


import org.glassfish.tyrus.server.Server;

public class ChatServerEndpoint
{
    public static void main(String[] args) {
        Server server = new Server("localhost", 8025, "/ws",null, ChatEndpoint.class);
        try {
            server.start();
            System.out.println("WebSocket server started at ws://localhost:8025/ws/chat");
            System.in.read(); // wait for Enter key
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }
}

