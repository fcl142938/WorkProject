package com.accp.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@ServerEndpoint("/websocket/{user}")
public class WebSocketTest {
	Session session;
	String user;

	public static Map<String, WebSocketTest> map = new HashMap<String, WebSocketTest>();

	/*
	 * public WebSocketTest() { System.out.println("111111111111111"); }
	 */

	/**
	 * 接受和返回值
	 *       
	 * @param message
	 * @param session
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@OnMessage
	public void onMessage(String message, Session session) throws IOException, InterruptedException {
		/* System.out.println("message:"+message); */
		JSONObject json = JSON.parseObject(message);
		/*
		 * System.out.println(json.get("user")); System.out.println(json.get("msg"));
		 * System.out.println(json.get("status"));
		 */

		/**
		 * 发送信息
		 */
		if (map.get(json.get("user")) != null && map.get(json.get("user")).session != null) {
			map.get(json.get("user")).session.getBasicRemote().sendText(JSON.toJSONString(json));
		}

		if (map.get("All") != null && map.get("All").session != null) {
			map.get("All").session.getBasicRemote().sendText("12");
		}

		/*
		 * for (String it : map.keySet()) { System.out.println(it);
		 * System.out.println(map.get("All")); }
		 */

		/*
		 * for (String it : map.keySet()) { System.out.println(it); }
		 */

		// map.get(json.get("user")).session.getBasicRemote().sendText(json.get("msg").toString());
		/* session.getBasicRemote().sendText(message); */

	}

	@OnOpen
	public void onOpen(@PathParam("user") String user, Session session) {
		this.session = session;
		this.user = user;
		map.put(user, this);
	}

	@OnClose
	public void onClose() {
		map.remove(this.user);

	}

	@OnError
	public void error(Session session, Throwable t) {
		System.out.println("发生错误，请注意");
		t.printStackTrace();
	}

}
