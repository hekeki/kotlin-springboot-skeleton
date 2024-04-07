package com.hekeki.kotlinspringbootskeleton.webapp.controller

import com.hekeki.kotlinspringbootskeleton.api.v1.dto.SkeletonData
import org.jetbrains.annotations.NotNull
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.service.annotation.DeleteExchange
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange
import org.springframework.web.service.annotation.PutExchange

@RestController
@HttpExchange("api/v1/skeletonData")
class SkeletonDataServiceController {

    private val log = LoggerFactory.getLogger(SkeletonDataServiceController::class.java)

    @PostExchange(accept = [MediaType.APPLICATION_JSON_VALUE], contentType = MediaType.APPLICATION_JSON_VALUE)
    fun create(@NotNull @RequestBody skeletonData: SkeletonData): ResponseEntity<SkeletonData> {
        return ResponseEntity.ok(SkeletonData(sid = 1, description = skeletonData.description))
    }

    @GetExchange(value = "{sid}", accept = [MediaType.APPLICATION_JSON_VALUE])
    fun read(@NotNull @PathVariable sid: Int): ResponseEntity<SkeletonData> {
        return ResponseEntity.ok(SkeletonData(sid = sid, description = "SkeletonData with ID: $sid"))
    }

    @PutExchange(value = "{sid}", accept = [MediaType.APPLICATION_JSON_VALUE], contentType = MediaType.APPLICATION_JSON_VALUE)
    fun update(@NotNull @PathVariable sid: Int, @NotNull @RequestBody skeletonData: SkeletonData): ResponseEntity<SkeletonData> {
        return ResponseEntity.ok(SkeletonData(sid = sid, description = skeletonData.description))
    }

    @DeleteExchange(value = "{sid}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun delete(@NotNull @PathVariable sid: Int) {
        log.info("SkeletonData with ID: $sid was deleted")
    }
}