package com.br.magalums.config;

import com.br.magalums.entity.Channel;
import com.br.magalums.entity.Status;
import com.br.magalums.repository.ChannelRepository;
import com.br.magalums.repository.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoaded implements CommandLineRunner {

    private final StatusRepository statusRepository;
    private final ChannelRepository channelRepository;

    public DataLoaded(StatusRepository statusRepository,
                      ChannelRepository channelRepository){
        this.statusRepository = statusRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::toChannel)
                .forEach(this.channelRepository::save);

        Arrays.stream(Status.Values.values())
                .map(Status.Values::toStatus)
                .forEach(this.statusRepository::save);
    }
}
