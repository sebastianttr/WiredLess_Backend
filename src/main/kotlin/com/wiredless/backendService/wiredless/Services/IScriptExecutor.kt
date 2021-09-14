package com.wiredless.backendService.wiredless.Services

interface IScriptExecutor {
    fun executeScript(name: String, author: String, type: IProjectHandler.ProjectType,vararg executeArgs: String);

    enum class ScriptLanguage{
        Python,
        JavaScript,
        Go,
        Java,
        CSharp,
    }
}