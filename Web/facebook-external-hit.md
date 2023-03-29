# Facebook external hit

# 1. 찾아보게된 이유
서비스를 운영하고 있는 자꾸 URL의 끝에 `--sanitized--`가 붙어서 Bad Request(400)을 발생시킴. agent를 확인해보니 `facebookexternalhit`로 찍힘.

# 2. facebookexternalhit 에이전트
facebookexternalhit는 페이스북에서 사용하는 웹크롤러이다. 페이스북에서 웹사이트에서 데이터를 수집하고, 이 정보를 페이스분 피드나 다른 페이스북 product에 노출한다. 페이스북 사용자가 페이스북에 URL을 공유하면, 페이스북 시스템은 자동으로 공유된 URL을 조회한다. 이떄 사용되는 에인전트가 facebookexternalhit이다. facebookexternalhit는 공유된 URL의 미리보기를 생성한다.

facebookexternalhit 에이전트는 title, description, images와 같은 메타정보를 URL의 웹사이트로 부터 수집한다. 이 정보는 preview 화면에서 함께 제공한다. 이렇게 하는 이유는 사용자가 링크를 눌러서 Facebook을 이탈하지 않고 Facebook 플랫폼 위에서 웹사이트의 정보를 확인 하도록 하기 위함이다.

# 3. --sanitized-- 가 URL에 포함되는 이유

facebookexternalhit 에이전트는 URL의 끝에 보안을 위해서 `--sanitized--`를 붙이는 경우가 있다. 

사용자가 페이스북에 링크를 공유했을떄, facebookexternalhit는 공유된 링크의 컨텐츠뿐만아니라 파라미터나 Query String을 조회한다. 어떤 경우는 query string들은 민감정보를 포함할 때가 있다. (예를 들면 사용자의 ID, Session ID, 또는 인증 토큰)

When a user shares a link on Facebook, the "facebookexternalhit" agent retrieves the content of the shared URL, including any parameters or query strings in the URL. However, some query strings in URLs can contain sensitive information, such as user IDs, session IDs, or authentication tokens.

facebookexternalhit는 민감 정보가 뉴스피드나 다른 페이스북 product에 노출되는 것을 방지하고자 자동으로 `--sanitized--`를 스크랩되는 URL의 끝에 붙인다. 결국 URL에 있는 민감 정보들이 제거 되거나 `--sanitized--` 같은 문자로 대체된다.

예를 들면 원본 URL이 `https://example.com/some-page?user_id=1234` 인 경우에 facebookexternalhit가 스크랩을 할때는 `https://example.com/some-page?user_id=--sanitized--` 식으로 실제 사용자 ID를 숨긴채 Facebook에 노출한다.

이런 방식을 통해서 Facebook의 뉴스피드에 사용자의 민감정보가 노출되는 것을 막는다.

# 4. 민감정보가 아님에도 --sanitized--로 변경되는 이유

1. Facebook 시스템에 문제가 있는 경우
2. Open Graph protocol
    - Open Graph protocol이 정상적으로 세팅되어 있는지 확인해야한다. Open Graph protocol은 페이스북에 메타데이터를 제공한다. 이 메타데이터가 부정확하거나 찾지 못하는 경우 facebookexternalhit가 부정확한 위치에 `--sanitized--`를 세팅할 수 있다.

디버깅을 위해 Facebook Sharing Debugger 툴을 사용할 수도 있다. 이 툴은 페이스북에서 링크를 공유했을때 컨텐츠가 어떻게 보여질지 사전에 확인할 수 있도록 해준다. 
