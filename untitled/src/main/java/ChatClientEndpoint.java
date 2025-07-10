import jakarta.websocket.*;

import java.net.URI;



@ClientEndpoint
public class ChatClientEndpoint {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to server");
        try {
            session.getBasicRemote().sendText("Hello, server!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received from server: " + message);
    }

    public static void main(String[] args) {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://localhost:8025/ws/chat";
        try {
            container.connectToServer(ChatClientEndpoint.class, URI.create(uri));
            Thread.sleep(5000); // wait to receive message
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

