package com.arthur.service;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by xusheng on 2019/4/24.
 */
public class CustomRule implements IRule {
    private ILoadBalancer lb;

    private List<Integer> excludePorts;

    public CustomRule() {
    }

    public CustomRule(List<Integer> excludePorts) {
        this.excludePorts = excludePorts;
    }

    @Override
    public Server choose(Object o) {
        List<Server> reachableServers = lb.getReachableServers();
        List<Server> availableServers = getAvailableServers(reachableServers);
        return getAvailableRandomServer(availableServers);
    }

    private Server getAvailableRandomServer(List<Server> availableServers) {
        int index = new Random().nextInt(availableServers.size());
        return availableServers.get(index);
    }

    private List<Server> getAvailableServers(List<Server> servers) {
        if (excludePorts == null || excludePorts.isEmpty()) {
            return servers;
        }

        Iterator<Server> iterator = servers.iterator();
        while (iterator.hasNext()) {
            if (servers.contains(iterator.next().getPort())) {
                iterator.remove();
            }
        }
        return servers;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.lb = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.lb;
    }
}
