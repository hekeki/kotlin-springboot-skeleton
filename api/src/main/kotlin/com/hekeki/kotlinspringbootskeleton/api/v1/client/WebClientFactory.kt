package com.hekeki.kotlinspringbootskeleton.api.v1.client

import java.nio.charset.StandardCharsets
import java.util.*
import org.springframework.http.HttpHeaders
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClient.Builder
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

object WebClientFactory {

    fun <T> createClient(proxyInterface: Class<T>, baseURI: String): T {
        return createClient(proxyInterface, baseURI, emptyMap())
    }

    fun <T> createClient(proxyInterface: Class<T>, baseURI: String, headers: Map<String, String>): T {
        val webClientBuilder: Builder = WebClient.builder().baseUrl(baseURI)
        if (headers.isNotEmpty()) {
            headers.forEach(webClientBuilder::defaultHeader)
        }
        val httpServiceProxyFactory: HttpServiceProxyFactory = HttpServiceProxyFactory
            .builder(WebClientAdapter.forClient(webClientBuilder.build())).build()
        return httpServiceProxyFactory.createClient(proxyInterface)
    }

    fun <T> createClientBasicAuth(proxyInterface: Class<T>, baseURI: String, user: String, password: String): T {
        return createClient(
            proxyInterface, baseURI,
            java.util.Map.of(
                HttpHeaders.AUTHORIZATION,
                "Basic " + Base64.getEncoder().encodeToString("$user:$password".toByteArray(StandardCharsets.UTF_8))
            )
        )
    }
}
