# What is "@ModelAttribute" in Spring?

"@ModelAttribute" is a Spring MVC annotation that is used to bind request parameters to a model object in the web application. The annotated method is executed before the main controller method and adds its return value as a model attribute to the model of the request. This attribute can then be accessed in the JSP view or any other type of view that is being used to render the response.

> Request Parameter를 model Object에 바인딩하기 위해 사용한다. 추가로 model Object는 자동으로 응답 model에 세팅이 된다.


```java
@Controller
public class FormController {
 
  @GetMapping("/form")
  public String showForm(Model model) {
    model.addAttribute("user", new User());
    return "form";
  }
 
  @PostMapping("/form")
  public String submitForm(@ModelAttribute User user, Model model) {
    // process the user form
    model.addAttribute("result", "Form submitted successfully");
    return "result";
  }
}
```

```html
<!DOCTYPE html>
<html>
<head>
  <title>Form Result</title>
</head>
<body>
  <h1>Form Result</h1>
  <p>Username: ${user.username}</p>
  <p>Password: ${user.password}</p>
  <p>${result}</p>
</body>
</html>
```
## 예제 코드
- https://www.geeksforgeeks.org/spring-mvc-modelattribute-annotation-with-example/