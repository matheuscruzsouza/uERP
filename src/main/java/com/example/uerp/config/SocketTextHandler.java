package com.example.uerp.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public final class SocketTextHandler extends TextWebSocketHandler {

	private static final SocketTextHandler INSTANCE = new SocketTextHandler();

	private Map<String, List<WebSocketSession>> sessions = new HashMap<String, List<WebSocketSession>>();

	public static SocketTextHandler getInstance() {
		return INSTANCE;
	}

	synchronized List<WebSocketSession> addSession(WebSocketSession sess, String name) {
		if (this.sessions.get(name) == null) {
			List<WebSocketSession> sessions = new ArrayList<>();

			this.sessions.put(name, sessions);
		}

		this.sessions.get(name).add(sess);

		return this.sessions.get(name);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		addSession(session, "BROADCAST");
		System.out.println("New Session in BROADCAST: " + session.getId());
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {

		String payload = message.getPayload();
		JSONObject jsonObject = new JSONObject(payload);

		String room = jsonObject.get("room").toString();
		List<WebSocketSession> rooms = this.addSession(session, room);

		for (WebSocketSession sess : rooms) {
			if (sess.getUri() != session.getUri()) {
				try {
					sess.sendMessage(new TextMessage(payload));
				} catch (Exception ex) {
					synchronized (sessions) {
						removeSession(session);
					}
				}
			}
		}

	}

	private void removeSession(WebSocketSession session) {
		Iterator<Entry<String, List<WebSocketSession>>> it = sessions.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<WebSocketSession>> pair = (Map.Entry<String, List<WebSocketSession>>) it.next();

			try {
				((List<WebSocketSession>) pair.getValue()).remove(session);
			} catch (Exception e) {
			}

			it.remove();
		}
	}

	public List<String> getRooms() {

		List<String> rooms = new ArrayList<String>();

		Iterator<Entry<String, List<WebSocketSession>>> it = sessions.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<WebSocketSession>> pair = (Map.Entry<String, List<WebSocketSession>>) it.next();

			rooms.add(pair.getKey());

			it.remove();
		}

		return rooms;
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		removeSession(session);
	}

	public void broadcast(TextMessage message) throws IOException {
		this.send(message, "BROADCAST");
	}

	public void send(TextMessage message, String room) throws IOException {
		String payload = message.getPayload();

		List<WebSocketSession> list = sessions.get(room);

		if (list != null && !list.isEmpty()) {
			for (WebSocketSession sess : list) {
				try {
					sess.sendMessage(new TextMessage(payload));
				} catch (Exception ex) {
					synchronized (sessions) {
						removeSession(sess);
					}
				}
			}
		}
	}
}