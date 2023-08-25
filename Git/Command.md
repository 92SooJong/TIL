# 사실 쓰려고 하면 기억 안나서 구글링 하는 명령어 모음

### 원격의 삭제된 브랜치를 로컬 커밋 히스토리에 반영할때
`git remote prune origin` 

### Undo Commit 
`git reset --soft HEAD^` Or `git reset --mixed HEAD^`

following command work same as `git reset --soft HEAD^`

`git reset HEAD^`


### 원격 브랜치의 히스토리를 로컬 브랜치의 히스토리로 강제로 덮어쓴다.

`git push -f -u origin [branch명]`

### 원격 브랜치의 주소를 재설정하는 경우
`git remote set-url <remote_name> <remote_url>`

### token 변경
`git remote set-url <remote_name> https://<token>@<git repo url>`

example, `git remote set-url origin https://<token>@github.com/92SooJong/java-study.git`

## 오래된 원격 브랜치 지우기(작성중)

git for-each-ref refs/heads refs/remotes --format '%(refname) %(committerdate:raw) %(committerdate:relative)' | awk '{if ((systime()-$2)>(86400*90)) print $1, $4 " " $5 " " $6}'

git ls-remote


# 최초셋팅
- 테스트를 위한 README 파일 생성 `echo "# git_tutorial" >> README.md`
- 현재 위치를 로컬 저장소로 설정함. 즉, repository를 받아올수 있는 상태 `git init`
-  변경된 사항을 준비영역에 추가함 `git add README.md`
- 준비영역의 파일들을 로컬 저장소로 옮긴다 `git commit -m "first commit"`
- 로컬 저장소와 원격저장소를 연결한다. `git remote add origin https://github.com/92SooJong/git_tutorial.git`
- 로컬의 커밋이력을 원격 master브랜치에 반영한다.  `git push -u origin master`

# 설정
- commit 시에 사용할 username과 email 설정
  - `git config --global user.name "your_name"`
  - `git config --global user.email "your_email@example.com"`

# 기본
- 원격 저장소의 변경사항을 받아온다 `git pull origin master`
- init 명령을 취소한다. 로컬 저장소 기능 제거 `rm -r .git`
- 현재 경로 파일 준비영역에 추가 `git add .`
- add 된 파일 로컬 저장소에 저장 `git commit`
- hello 메세지를 달고 로컬 저장소에 저장 `git commit -m "hello"`
- 로컬 저장소 파일을 원격 저장소로 push `git push -u origin master`
- staging 변경 내역조회 `git status`

# Branch
- 브랜치 생성 `git branch [브랜치명]`
- 브랜치 이동 `git checkout [브랜치명]`
- 브랜치 병합 `git merge [브랜치명]` ( 현재 HEAD가 가르키고 있는 브랜치에 [브랜치명]을 흡수함 )
