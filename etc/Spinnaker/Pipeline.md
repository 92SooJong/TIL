# Pipeline과 Pipeline stage
In Spinnaker, a "Pipeline" is a set of steps and tasks, executed in a specific order, that define the deployment process of an application. It serves as a blueprint for releasing software, with stages representing phases of a deployment.

A "Pipeline Stage" is a single, identifiable step in a pipeline that defines a specific task or set of tasks to be executed. Each stage has a specific purpose and function, such as deploying a new version of the application, running tests, or rolling back to a previous version.

In short, a pipeline is the overall deployment process, while a pipeline stage represents a step in that process.

# 정리하면
`Pipeline`은 task나 step에 대한 묶음을 의미한다

`Pipeline Stage`는 하나의 step을 의미한다

즉, 2개의 용어가 명확히 다른 개념을 의미하므로 혼돈하지 말자

