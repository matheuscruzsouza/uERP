package com.example.uerp.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public final class SocketTextHandler extends TextWebSocketHandler {

	private static final SocketTextHandler INSTANCE = new SocketTextHandler();

	private List<WebSocketSession> sessions = new ArrayList<>();

	public static SocketTextHandler getInstance() {
		return INSTANCE;
	}

	synchronized void addSession(WebSocketSession sess) {
		this.sessions.add(sess);
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		addSession(session);
		System.out.println("New Session: " + session.getId());
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {

		String payload = message.getPayload();
		// JSONObject jsonObject = new JSONObject(payload);
		// session.sendMessage(new TextMessage("Hi " + jsonObject.get("user") + " how may we help you?"));
		
		for (WebSocketSession sess : sessions) {
			if (sess.getUri() != session.getUri()) {
				sess.sendMessage(new TextMessage("Hi " + payload + " how may we help you?"));
			}
		}

	}

	public void broadcast(TextMessage message) throws IOException {
		String payload = message.getPayload();

		System.out.println("Session: " + payload);
		
		for (WebSocketSession sess : sessions) {
			sess.sendMessage(new TextMessage("Hi " + payload + " how may we help you?"));
		}
	}

}