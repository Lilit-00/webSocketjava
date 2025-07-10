import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.websocket.Session;

import jakarta.websocket.OnMessage;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatEndpoint {

    @OnMessage
    public String onMessage(String message) {
        System.out.println("Received from client: " + message);
        return "Echo: " + message;
    }
}

