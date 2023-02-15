package com.study.webserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;
import java.net.Socket;

public class WebApplicationServer {
    private static final Logger logger = LoggerFactory.getLogger(WebApplicationServer.class);
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) throws Exception{
        int port = DEFAULT_PORT;

        if(args != null && args.length >= 1) {
            port = Integer.parseInt(args[0]);
        }

        try(ServerSocket listenSocket = new ServerSocket(port)) {
            logger.info("웹 서버가 실행되었습니다. port : {}", port);

            Socket connection;
            while((connection = listenSocket.accept()) != null) {
                Thread thread = new Thread(new RequestHandler(connection));
                thread.start();
            }
        }

    }


}
