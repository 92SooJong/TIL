# AppsFlyer

[https://support.appsflyer.com/hc/en-us/articles/360000677217-OneLink-Smart-Script-Web-to-app-URL-generator](https://support.appsflyer.com/hc/en-us/articles/360000677217-OneLink-Smart-Script-Web-to-app-URL-generator)

사용자가 모바일에서 광고 클릭하면 두가지 동작이 발생함


1. 웹페이지로 이동
2. 웹에서 다시 app store 로 이동.

여기서 사용자가 다운로드를 해도 어트리뷰트가 제대로 안됨. 광고를 클릭하고 들어왔음에도 정상적으로 작동하지 않음.

이 문제를 OneLink Smart Script가 해결해줌.

incoming URL를 사용해보셈. incoming URL를 사용하면 웹 페이지에서 바로 유니크한 OneLink long URL을 만들어냄. 그리고 이 OneLink는 앱 스토어로 사용자를 디렉팅 함.

아래 링크를 통해서 OneLink Smart Script V2를 세팅해봐. (V1은 레거시니까 쓰지 말라)

[https://support.appsflyer.com/hc/en-us/articles/4413588932241](https://support.appsflyer.com/hc/en-us/articles/4413588932241)

AppsFlyer UI를 통해서 생성도 가능하지만 개발적으로도 적용 가능함. GTM을 사용해서도 세팅이 가능함요.

개발자는 아래 가이드를 보삼

[https://dev.appsflyer.com/hc/docs/dl_smart_script_v2](https://dev.appsflyer.com/hc/docs/dl_smart_script_v2)

그냥 UTM만 제대로 세팅해도 작동 할것같은데??
