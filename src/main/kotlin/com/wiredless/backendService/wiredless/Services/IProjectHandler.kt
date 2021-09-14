package com.wiredless.backendService.wiredless.Services

interface IProjectHandler {

    fun createProject(name:String,author:String,type: ProjectType)

    enum class ProjectType{
        JavaScript_Express,
        Python_Django,
        Java_Spring,
        Go,
        Kotlin_Spring,
        CSharp_ASPNET
    }

}
