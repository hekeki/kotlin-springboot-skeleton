package com.hekeki.kotlinspringbootskeleton.webapp.controller

import com.hekeki.kotlinspringbootskeleton.api.v1.SkeletonDataServiceIF
import com.hekeki.kotlinspringbootskeleton.api.v1.dto.SkeletonData
import org.springframework.web.bind.annotation.RestController

@RestController
class SkeletonDataServiceController : SkeletonDataServiceIF {
    override fun create(sid: Int, data: SkeletonData): SkeletonData {
        return SkeletonData(sid = data.sid, description = data.description)
    }

    override fun read(sid: Int): SkeletonData {
        return SkeletonData(sid = sid)
    }

    override fun update(sid: Int, data: SkeletonData): SkeletonData {
        return SkeletonData(sid = data.sid, description = data.description)
    }

    override fun delete(sid: Int) {
        // nothing to do
    }
}