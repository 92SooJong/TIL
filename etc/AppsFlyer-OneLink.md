# AppsFlyer의 Onelink

AppsFlyer는 마케터를 위한 도구임.

AppsFlyer에서 OneLink라는 기능을 제공함.

# Deep Link와 One Link 차이점


Deep Link


- Deep links are a type of link that send users directly to an app instead of a website or a store
- 딥 링크는 사용자를 웹사이트나 스토어 대신 바로 앱으로 보내는 링크를 말함.
- **사용자가 광고를 클릭하면 웹으로 가는게 아니라 앱으로 보냄!!**

OneLink


- *OneLink is a universal deep link*
- OneLink는 deep link에 좀더 기능이 추가된거라고 생각하면 됨.
- OS별로 따로 생성해야했던 Deep Link의 문제를 해결했다. (Universal하게 사용가능!)
- AppsFlyer의 OneLink는 사용자의 OS나 브라우저를 파악하는 기능이 있음.

## 질문

- 실제로 마케터분들이 OS별로 링크를 만들어서 광고를 내보내고 있는지 확인 해보자.

# Web To App이동시 GA Tag 살리기


AppsFlyer는 Web에서 APP으로 이동할때 GA Tag를 유실되지 않도록 지원한다.

사용자가 Web에서 App이동을 위한 버튼(당연히 OneLink가 삽입되어 있을것이다)을 클릭했을때 utm이 유실되지 않도록 해준다. 이 기능을 Smart Script라고 부른다.

AppsFlyer에 접속하면 Smart Script를 설정할 수 있는 기능이 있다. 원본 링크(incoming)가 OneLink화 될때 파라미터를 어떻게 처리할 것인지 설정할 수 있다. 기본적으로 utm_source는 pid가 되고, utm_campagin은 c가 된다. 이부분에 대한 pid, c에 대한 세팅이 GA에 되어 있지 않다면 결국은 유실될것이다. (이 부분에서 조심해야한다!)

원본 링크가 One Link화 될때 수행되는 파라미터 변경을 Javascript로도 처리가능하다. 예를 들면 utm_source를 onelink에서도 살리고 싶다면 이 방식으로 해결하면 된다.
