package com.hekeki.kotlinspringbootskeleton.api.v1.client

import com.hekeki.kotlinspringbootskeleton.api.v1.dto.SkeletonData
import org.jetbrains.annotations.NotNull
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.service.annotation.DeleteExchange
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange
import org.springframework.web.service.annotation.PutExchange

@Validated
@HttpExchange("/api/v1/skeletonData")
interface SkeletonDataClientIF {

    @PostExchange(contentType = MediaType.APPLICATION_JSON_VALUE, accept = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@NotNull @RequestBody skeletonData: SkeletonData): SkeletonData

    @GetExchange("{sid}", accept = [MediaType.APPLICATION_JSON_VALUE])
    fun read(@NotNull @PathVariable sid: Int): SkeletonData

    @PutExchange("{sid}", contentType = MediaType.APPLICATION_JSON_VALUE, accept = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@NotNull @PathVariable sid: Int, @NotNull @RequestBody skeletonData: SkeletonData): SkeletonData

    @DeleteExchange("{sid}")
    fun delete(@NotNull @PathVariable sid: Int)
}