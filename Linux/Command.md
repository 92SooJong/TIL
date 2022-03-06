# chmod
`chmod` 를 통해서 권한 변경이 가능하다.
- 예시 `chmod u+rwx [파일명]` 사용자(u)에게 읽기(r),쓰기(w),실행(x) 권한을 부여(+)한다
- `u(사용자)`,`g(그룹)`,`o(타인)`
- `+(권한부여)`, `-(권한제거)`,`=(권한유지)`
- `r(읽기)`,`w(쓰기)`,`x(실행)`

# 조회
- `sar -r 1` 메모리 사용량을 조회
- `hostname -I` IP주소를 확인
- `hostname` 호스트명을 조회
- `ls -l` 현재 디렉토리에 존재하는 파일 및 디렉토리의 목록을 확인할 수 있다.
- `ps -aux` 프로세스 목록과 각각의 상태 확인
- `ps -ef` 프로세스 목록과 상태 ( 자식관계 파악에 용이함 )
- `readlink -f $0` 현재 파일($0)에 대한 심볼릭 링크를 마지막 뎁스(-f)까지 탐색한다.
- `dirname a.txt` a.txt 파일이 속한 directory를 반환한다

# 기타
- `tar -xzf [tgz파일]` tgz 파일의 압축을 해제한다
- `sudo hostnamectl set-hostname [새로운hosname]` 호스트명을 변경한다
- `sudo wget [https , http , ftp 주소]` 입력한 주소를 통해 파일을 내려받는다.
- `rm -r [폴더명]` 폴더를 제거한다
- `ln -s <TARGET> <LINK_NAME>` 심볼릭링크를 만든다

# Bash명령어
- `source [파일명]` [파일명]의 스크립트를 실행한다.
