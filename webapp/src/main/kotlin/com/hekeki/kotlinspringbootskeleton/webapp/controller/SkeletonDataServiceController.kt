package com.hekeki.kotlinspringbootskeleton.webapp.controller

import com.hekeki.kotlinspringbootskeleton.api.v1.dto.SkeletonData
import io.nbage.webapp.exception.GlobalResponseEntityExceptionHandler
import org.jetbrains.annotations.NotNull
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/skeletonData")
class SkeletonDataServiceController {

    private val log = LoggerFactory.getLogger(GlobalResponseEntityExceptionHandler::class.java)

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@NotNull @RequestBody skeletonData: SkeletonData): SkeletonData {
        return SkeletonData(sid = 1, description = skeletonData.description)
    }

    @GetMapping("{sid}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun read(@NotNull @PathVariable sid: Int): SkeletonData {
        return SkeletonData(sid = sid, description = "SkeletonData with ID: $sid")
    }

    @PutMapping("{sid}", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@NotNull @PathVariable sid: Int, @NotNull @RequestBody skeletonData: SkeletonData): SkeletonData {
        return SkeletonData(sid = sid, description = skeletonData.description)
    }

    @DeleteMapping("{sid}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun delete(@NotNull @PathVariable sid: Int) {
        log.info("SkeletonData with ID: $sid was deleted")
    }
}