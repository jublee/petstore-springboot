package org.petstore.demo.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.spockframework.runtime.extension.IGlobalExtension
import org.testcontainers.containers.Network
import org.testcontainers.containers.BindMode
import org.testcontainers.containers.output.OutputFrame
import org.wiremock.integrations.testcontainers.WireMockContainer

import java.time.Duration
import java.util.function.Consumer

class ContainerExtension implements IGlobalExtension {

    private static final Logger LOG = LoggerFactory.getLogger(ContainerExtension.class)

    private static dockerNetworkName = System.getenv("NAME") ?: null
    private static Network network = Network.newNetwork()

    private static Consumer<OutputFrame> logConsumer(String containerName) {
        return {
            def message = it?.utf8StringWithoutLineEnding
            if (LOG.isDebugEnabled() && message) {
                LOG.debug("[{}] [{}]", containerName, message)
            }
        }
    }


    private static final WireMockContainer wiremockServer = new WireMockContainer("wiremock/wiremock:3.9.1")
            .withPrivilegedMode(false)
            .withStartupTimeout(Duration.ofSeconds(120))
            .withClasspathResourceMapping("wiremock", "/home/wiremock", BindMode.READ_ONLY)
            .withLogConsumer { logConsumer("wiremockServer") }
            .tap { it ->
                {
                    if (dockerNetworkName) {
                        it.withNetworkMode(dockerNetworkName)
                    } else {
                        it.withNetwork(network)
                    }
                }
            }


    @Override
    void start() {
        wiremockServer.start()
        def host = "http://" + wiremockServer.getHost() + ":" + wiremockServer.getPort()
        println "host - " + host
        System.setProperty("wiremock.host", host)
    }

    @Override
    void stop() {
        wiremockServer.stop()
    }
}
