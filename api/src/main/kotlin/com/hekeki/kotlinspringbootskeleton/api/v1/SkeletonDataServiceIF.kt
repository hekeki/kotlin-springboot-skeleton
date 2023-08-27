package com.hekeki.kotlinspringbootskeleton.api.v1

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
interface SkeletonDataServiceIF {

    @GetExchange("{sid}", accept = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@PathVariable(value = "sid") sid: Int, @RequestBody @NotNull data: SkeletonData): SkeletonData

    @PostExchange("{eid}", contentType = MediaType.APPLICATION_JSON_VALUE, accept = [MediaType.APPLICATION_JSON_VALUE])
    fun read(@PathVariable(value = "sid") @NotNull sid: Int): SkeletonData

    @PutExchange("{eid}", contentType = MediaType.APPLICATION_JSON_VALUE, accept = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@PathVariable(value = "sid") @NotNull sid: Int, @RequestBody @NotNull data: SkeletonData): SkeletonData

    @DeleteExchange("{eid}")
    fun delete(@PathVariable(value = "sid") @NotNull sid: Int)
}