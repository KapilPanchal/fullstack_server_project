package com.app61.server.config;

import com.app61.server.enumeration.Status;
import com.app61.server.model.Server;
import com.app61.server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class AppConfig {

    @Bean
    CommandLineRunner runner (ServerRepo serverRepo){
        return args -> {

            Server server1 = Server.builder()
                    .ipAddress("127.0.0.1")
                    .name("Ubuntu Linux")
                    .memory("16 Gb")
                    .type("Personal Computer")
                    .imageUrl("http://localhost:9002/server/image/server1.png")
                    .status(Status.SERVER_UP)
                    .build();

            Server server2 = Server.builder()
                    .ipAddress("192.168.0.2")
                    .name("Windows Linux")
                    .memory("8 Gb")
                    .type("Personal Computer")
                    .imageUrl("http://localhost:9002/server/image/server2.png")
                    .status(Status.SERVER_DOWN)
                    .build();

            Server server3 = Server.builder()
                    .ipAddress("192.168.0.3")
                    .name("Ubuntu Linux - Server")
                    .memory("64 Gb")
                    .type("Server")
                    .imageUrl("http://localhost:9002/server/image/server3.png")
                    .status(Status.SERVER_UP)
                    .build();

            Server server4 = Server.builder()
                    .ipAddress("192.168.0.4")
                    .name("Ubuntu Linux")
                    .memory("128 Gb")
                    .type("Personal Computer")
                    .imageUrl("http://localhost:9002/server/image/server4.png")
                    .status(Status.SERVER_DOWN)
                    .build();

            serverRepo.saveAll(Stream.of(server1,server2,server3,server4).collect(Collectors.toList()));
        };
    }
}
