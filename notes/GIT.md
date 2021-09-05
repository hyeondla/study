# 시작

> 깃 설치

https://git-scm.com/



> 환경 설정

```
$ git config --global user.name "hyeondla"
```

```
$ git config --global user.email "hyeondla@gmail.com"
```



> 리눅스 명령어

```
$ pwd 
```

현재 위치 경로 표시 *print working directory* 

```
$ ls 
```

현재 디렉터리의 파일,디렉터리 확인 *list* 

**$ ls -a** 숨김 파일, 디렉터리 표시

**$ ls -l** 상세 정보 표시

**$ ls -r** 정렬 순서 거꾸로 표시

**$ ls -t** 작성 시간 내림차순 표시

```
$ cd 
```

디렉터리 이동 *change directory*  

**$ cd ..** 상위 디렉터리로 이동 

**$ cd (이동할 디렉터리 이름)**  하위 디렉터리로 이동

**$ cd ~** 홈 디렉터리로 이동

**$ cd ~/(이동할 디렉터리 이름)** 홈 디렉터리의 하위 디렉터리로 이동

```
$ mkdir (생성할 디렉터리 이름) 
```

현재 디렉터리 안에 하위 디렉터리 생성 *make directory* 

```
$ rm -r (삭제할 디렉터리 이름)
```

 현재 디렉터리에서 하위 디렉터리 삭제 *remove* 



> 빔 편집기로 텍스트 문서 생성

```
$ vim (생성할 문서 이름).txt
```

**I, A (입력 모드)** 입력, 수정

**Esc (ex 모드)** 저장, 종료

:w 편집 문서 저장

:q 편집기 종료

:wq (파일 이름) 편집 문서 파일이름으로 저장, 종료  

:q! 저장하지 않고 편집기 종료 .swp 임시파일 생성됨

```
$ git config --global core.editor "(편집기 이름 or 실행 파일 경로)"
```

기본 편집기 변경



> 텍스트 문서 내용 확인

```
$ cat (문서 이름).txt
```

 터미널 창에서 텍스트 문서 내용 확인 *concatenate*

```
$ cat 파일1, 파일2, 파일n > 새파일 
```

파일 연결해서 새 파일 생성

```
$ cat 파일1 >> 파일2 
```

파일2 끝에 파일1 연결



> 디렉터리를 나타내는 기호
>

**~** 현재 홈 디렉터리 c/Users/(사용자아이디)

**./** 현재 작업 중인 디렉터리

**../** 현재 디렉터리의 상위 디렉터리



---



# 버전 관리


> 초기화

```
$ git init
```

디렉터리 초기화 *initialize*

→ Initialized empty Git repository in … 

버전이 저장되는 저장소인 .git 디렉터리 생성됨

> 작업 트리

파일 수정, 저장 작업 수행 

**tracked** 한 번이라도 커밋을 한 파일은 수정 여부를 계속 추적함

				수정 후 상태 확인 → **modified:  (파일명)** 표시

**untracked** 한 번도 깃에서 버전 관리를 하지 않아 수정 여부를 추적하지 않음

> 스테이지

버전으로 만들 파일 저장

커밋을 통해 버전이 생성되며 저장소로 저장

.git/index 파일에 내용이 저장됨

> 저장소(리포지트리)

스테이지의 파일을 버전으로 만들어 저장

.git/HEAD 파일에 내용이 저장됨

> 깃 상태

```
$ git status
```

**On branch master** 현재 master 브랜치에 있음

**No commits yet** 아직 커밋한 파일이 없음

**nothing to commit** 현재 커밋할 파일이 없음, unmodified 상태

**Changes not staged for commit** 

파일이 수정되었으나 아직 스테이지에 올라가지 않음, modified 상태

**Changes to be committed** 커밋할 변경 사항이 있음, staged 상태

> 스테이징

```
$ git add (파일명)
$ git add .
```

작업 트리에서 파일 생성, 수정 시 스테이지에 파일 추가

**add .** 현재 저장소에서 수정된 파일을 한꺼번에 스테이징

> 커밋

```
$ git commit -m "(커밋메시지)"
```

변경사항 확인을 위한 메시지 작성

→ 1 file changed, 1 insertion(+)

    스테이지에 있던 파일이 저장소에 추가됨

깃 상태 확인

→ nothing to commit, working tree clean

> 스테이징 + 커밋

```
$ git commit -am "(커밋메시지)"
$ git commit -a -m "(커밋메시지)"
```

한 번 커밋한 파일은 스테이징과 커밋을 한꺼번에 처리 가능

> 가장 최근의 커밋 메시지 수정

```
$ git commit --amend
```

기본 편집기인 빔이 실행되어 원래 커밋 메시지가 나타남

입력 모드로 바꿔 메시지 수정

ex 모드로 돌아가 저장, 종료

> 버전 확인

```
$ git log
$ git log --stat
$ git log --oneline
```

커밋 해시, 최신 커밋 표시 (HEAD ㅡ> master) , 작성자, 버전 생성 날짜, 커밋 메시지 표시

**--stat** 커밋에 관련된 파일까지 함께 표시

**--oneline** 한 줄에 한 커밋씩 표시

> 변경 사항 확인

```
$ git diff
```

작업 트리에 있는 파일과 스테이지에 있는 파일 비교

스테이지에 있는 파일과 저장소에 있는 최신 커밋 비교

**－ (내용)** 최신 버전과 비교할 때 삭제된 내용

**＋ (내용)** 최신 버전과 비교할 때 추가된 내용

> 버전 관리 제외

빔으로 **.gitignore** 파일 생성

버전 관리하지 않을 파일, 디렉토리 이름, 파일 확장자 입력하여 목록 지정

> 파일 수정 되돌리기

```
$ git checkout -- (파일명)
```

되돌린 내용은 다시 복구 불가

> 스테이징 되돌리기

```
$ git reset HEAD (파일명)
```

파일명 미지정시 스테이지에 있는 모든 파일을 되돌림

> 커밋 되돌리기

```
$ git reset 
```

스테이징도 함께 취소되어 파일이 작업 트리에만 남아 있음

**HEAD^** 최신 커밋을 되돌림

**HEAD~*n*** 최근 *n*개의 커밋을 되돌림

**--soft HEAD^** 최근 커밋을 하기 전 상태로 작업 트리를 되돌림

**--mixed HEAD^** 최근 커밋과 스테이징을 하기 전 상태로 작업 트리를 되돌림, 기본 옵션

**--hard HEAD^** 최근 커밋, 스테이징, 파일 수정을 하기 전 상태로 작업 트리를 되돌림, 복구 불가

> 특정 커밋으로 되돌리기

$ git log 결과 화면에서 되돌릴 커밋의 해시를 선택하여 Copy

```
$ git reset --hard (복사한 커밋 해시)
```

복사한 커밋이 가장 최신 커밋, 이후의 커밋은 삭제됨

> 커밋 삭제하지 않고 되돌리기

$ git log 결과 화면에서 취소할 커밋의 해시를 선택하여 Copy

```
$ git revert (복사한 커밋 해시)
```

기본 편집기인 빔이 실행됨

입력 모드로 바꿔 커밋 메시지 입력 가능

ex 모드로 돌아가 저장, 종료



---



# 브랜치

깃으로 버전 관리를 시작하면 master 브랜치가 기본 생성됨 

→ 커밋할 때마다 최신 커밋을 가리킴

> 분기 branch 

master 브랜치에서 뻗어 나오는 새 브랜치 생성하는 것

기존 저장된 파일을 master 브랜치에 그대로 유지

기존 파일 내용 수정, 새로운 기능 추가

> 병합 merge 

분기했던 브랜치를 master 브랜치에 합치는 것

> 브랜치 생성/확인

```
$ git branch
$ git branch (생성할 브랜치 이름)
```

**＊ master** 표시됨 → master 브랜치에서 작업하고 있음을 의미

> 브랜치 이동

```
$ git checkout (이동할 브랜치 이름)
```

> 브랜치 버전 확인

```
$ git log --oneline --branches
$ git log --oneline --branches --graph
```

**--branches** 각 브랜치의 커밋을 함께 표시

**--graph** 커밋과 커밋의 관계 |로 표시 

> 브랜치 차이 확인

```
$ git log (브랜치1)..(브랜치2)
```

왼쪽 브랜치 기준으로 오른쪽 브랜치와 비교

브랜치1에는 없고 브랜치2에만 있는 커밋을 보여줌

> 서로 다른 파일 병합

```
$ git checkout master
$ git merge (가져올 브랜치 이름)
```

**$ git merge (브랜치 이름) --no-edit** 지정 메시지 사용, 커밋 메시지 창 열리지 않음

**$ git merge (브랜치 이름) --edit** 

커밋 메시지 창을 열어 메시지를 추가, 수정

기본 편집기인 빔이 실행됨

커밋 메시지 **Merge branch '(브랜치 이름)'** 표시됨, 수정 가능

ex 모드에서 저장, 종료

> 빨리 감기 병합 fast-forward merge

master 브랜치 분기 후 master 브랜치에서 새로운 커밋을 하지 않았다면 

분기한 브랜치에서 만든 최신 커밋을 master 브랜치가 가리키게 하면 병합됨

병합 명령 시 fast-forward 메시지 표시되며 커밋 메시지 창은 열리지 않음

> 같은 파일의 다른 내용을 수정한 경우 병합

각 브랜치의 수정 내용이 자연스럽게 하나의 파일에 합쳐짐

> 같은 파일의 같은 위치를 수정한 경우 병합

줄 단위로 변경 여부 확인하기 때문에 브랜치 충돌 발생

**CONFLICT (content) : Merge conflict in (파일 이름)**

**automatic merge failed; fix conflicts and then commit the result.** 

메시지 표시됨, 자동 병합 불가

```
$ vim (충돌이 생긴 파일)
```

**〈〈〈〈〈〈〈 HEAD**

**(현재 브랜치에서 수정한 내용)**

**=======**

**(병합할 브랜치에서 수정한 내용)**

**〉〉〉〉〉〉〉 (병합할 브랜치 이름)**

사용자가 직접 수정 후 〈〈〈〈〈〈 HEAD, =======, 〉〉〉〉〉〉〉 (병합할 브랜치 이름) 삭제

저장 후 편집기 종료

수정 파일 스테이징, 커밋

> 브랜치 삭제

```
$ git branch
$ git checkout master
$ git brancd -d (삭제할 브랜치 이름)
```

병합하지 않은 브랜치를 삭제하려면 옵션 **-D** 사용하여 강제 삭제

같은 이름의 브랜치를 생성하면 예전 내용을 다시 볼 수 있음

> 브랜치 reset

git checkout → HEAD 제어를 통해 브랜치 이동 가능

```
$ git reset (원하는 커밋의 커밋 해시)
```

git reset → HEAD가 가리키는 브랜치의 최신 커밋을 원하는 커밋으로 지정 가능

다른 브랜치의 커밋을 지정한 경우 원래 가리키던 커밋은 연결이 끊기며 삭제됨

> 수정 중인 파일 감추기

```
$ git stash
```

감추려는 파일이 tracked 상태(한 번은 커밋)여야 함

커밋하지 않은 수정 내용 보관, stash 목록에서 확인 가능

가장 최근 보관한 파일 stash@{0}에 보관

기존 보관 파일은 stash@{1}, stash@{2}, …로 옮겨짐

> 감춘 파일 되돌리기

```
$ git stash pop
```

stash 목록에서 가장 최근 항목을 되돌림

> 감춘 파일 삭제

```
$ git stash drop
```

stash 목록에서 가장 최근 항목 삭제



---



# 깃허브

> 원격 저장소 만들기

화면 오른쪽 위 `+` → New repository 클릭

**Repository name** 저장소 이름, 영문 숫자 언더바(_) 붙임표(-) 사용 가능

**Description** 간단한 설명

**Public / Private** 공개 / 비공개

**Initialize this repository with a README** 저장소 소개, 설명을 작성하는 파일 자동 생성

**Add .gitignore** .gitignore 파일에 지정할 언어 선택

**Add a License** 오픈 소스 라이선스 선택

→ Create Repository 클릭

→ https://github.com/(아이디)/(저장소명) 으로 저장소에 접속 

> 지역 저장소 생성

```
$ git init loc-git
$ cd loc-git
$ vim f1.txt
```

f1.txt에 아무거나 간단히 입력 후 편집기 저장, 종료 → 스테이징, 커밋

> 원격 저장소에 연결

```
$ git remote add origin (깃허브 저장소 주소)
```

**$ git remote -v** 입력 시

origin (주소) (fetch)

origin (주소) (push) 

표시됨

한번만 수행하면 됨

> 원격 저장소에 파일 올리기 git push

```
$ git push -u origin master
```

지역 저장소의 브랜치를 원격 저장소의 master 브랜치로 푸시

한번만 수행하면 됨

```
$ git push
```

이후로 푸시할 때는 push 명령어만 입력

> 깃허브에서 직접 커밋

깃허브 저장소 접속 후 Create new file 클릭

→ 파일 내용 입력

→ 기본 커밋 메시지 사용/수정

→ Commit new file 클릭

> 원격 저장소에서 파일 내려받기 git pull

```
$ git pull origin master
```

원격 저장소의 내용을 master 브랜치로 가져옴

> SSH(Secure Shell) 원격 접속

프라이빗 키와 퍼블릭 키를 사용해 현재 사용하고 있는 기기를 깃허브에 인증

> SSH 키 생성

```
$ cd ~
$ ssh-keygen
```

홈 디렉터리 안의 .ssh 디렉터리에 SSH 키 저장됨

`Enter` 세번 → SSH를 통해 다른 컴퓨터에 접속할 수 있는 비밀번호 생성됨

(파일 경로)/**id_rsa** → 프라이빗 키

(파일 경로)/**id_rsa.pub** → 퍼블릭 키

```
$ cd ~/.ssh
$ ls -la
```

→ 저장 확인

> 깃허브에 퍼블릭 키 전송

```
$ cd ~/.ssh
$ cat id_rsa.pub
```

퍼블릭 키에 담긴 내용 표시됨 → 전부 복사

→ 깃허브 로그인 → 사용자 아이콘 → Settings → SSH and GPG keys → New SSH key

→ Title : 등록하려는 키를 쉽게 알아볼 수 있도록 작성 (퍼블릭 키 여러개 등록 가능하기 때문)

→ Key : 복사한 값 붙여넣기 → Add SSH key → Confirm password

SSH 키를 만들었던 컴퓨터는 깃허브 저장소의 SSH 주소만 알고 있으면 

로그인하지 않고도 바로 저장소에 접속 가능

> SSH 주소로 원격 저장소 연결

깃허브 화면 오른쪽 위 `+` → New repository → 저장소 이름 입력 → Create repository

→ 저장소 주소 `SSH ` 클릭 → 주소 복사

```
$ cd ~
$ git init connect-ssh
$ cd connect-ssh
$ git remote add origin (복사한 주소 붙여넣기)
```

**$ git remote -v** 연결 확인



---



# 협업

> 원격 저장소 복제 git clone

원격 저장소를 지역 저장소로 똑같이 가져오는 것

깃허브 저장소 → Clone or Download → Clone with HTTPS 원격 저장소 주소 복사

```
$ git clone (복사한 주소 붙여넣기) (만들 디렉터리 이름)
$ git clone (복사한 주소 붙여넣기) .
```

**마침표(.)** 입력시 현재 디렉터리에 복제

원격 저장소를 복제하면 자동으로 연결됨 

**$ git remote -v** 연결 확인

> 개인 작업 후 원격 저장소에 올리기

```
$ git commit -am "(커밋 메시지)"
$ git push
```

> 원격 저장소에서 내려받기

```
$ git pull
```

새로 올라온 커밋 가져옴

→ 개인 작업 후 push → 반복 → 항상 최신 소스 유지 가능

git fetch와 git merge FETCH_HEAD를 한꺼번에 수행함 

> 원격 master 브랜치

디렉토리에서 **$ git log --oneline** 명령으로 커밋 상태 확인

**HEAD ─> master** 지역 저장소의 최종 커밋

**origin/master** 원격 저장소의 최종 커밋

최종 커밋 앞에 표시됨 

master 브랜치가 origin 원격 master 브랜치의 버전보다 앞에 있다면

**$ git status** 입력 시 

**Your branch is ahead of 'origin/master' by *n* commit.**

**(use "git push" to publish your local commits)** 표시됨

→ **$ git push** 입력 시 master와 origin/master 브랜치가 같은 커밋을 가리킴

> 원격 브랜치 정보 가져오기 git fetch

```
$ git fetch
```

**$ git log --oneline** 입력 시 (HEAD ─> master)만 보임

원격 저장소의 최신 커밋 정보를 가져왔지만 아직 지역 저장소에 합치지 않았음

**$ git status** 입력 시 

**Your branch is behind 'origin/master' by *n* commit, and can be fast-forwarded.**

**(use "git pull" to update your local branch)** 표시됨

페치로 가져온 원격 저장소 정보는 **FETCH_HEAD** 브랜치로 가져옴

**$ git checkout FETCH_HEAD** 로 이동하여 git log 명령으로 가져온 최신 커밋을 볼 수 있음

**$ git diff HEAD origin/master** 지역 저장소의 최신 커밋과 패치 커밋의 차이 비교

최신 커밋을 현재 브랜치에 합치려면

**$ git pull** 명령으로 원격 저장소의 소스를 내려받거나

**$ git merge FETCH_HEAD** 명령으로 FETCH_HEAD의 커밋을 병합 

(→ master 브랜치로 이동 뒤 병합해야함)

> 공동 작업자 추가

깃허브 저장소 → Settings → Collaborators → 메일 주소 입력 → Add Collaborator

협업자는 깃허브 메시지 화면에서 Accept Invitation 클릭 시 수락됨

> 작업 환경 구성

```
$ git init (생성할 지역 저장소 이름)
$ cd (생성한 지역 저장소 이름)
$ git config user.name "(사용자 이름)"
$ git config user.email "메일 주소"
```

저장소마다 다른 이름이나 메일 주소 사용을 위해 --global 옵션 제외

공동 작업자 모두 같은 방식으로 지역 저장소와 환경 설정

> 원격 저장소에 첫 푸시

```
$ vim overview.txt
$ git add overview.twt
$ git commit -m "overview"
$ git remote add origin (원격 저장소 주소)
$ git push -u origin master
```

overview.txt에는 아무 내용이나 작성

**-u** 옵션 → 다음부터 git push 명령만으로 원격 저장소의 master 브랜치에 푸시

> 공동 작업자 컴퓨터에 원격 저장소 복제하기

```
$ git clone (원격 저장소 주소)
```

> 공동 작업자 컴퓨터에서 올리기

```
$ git pull
$ git push -u origin master
```

**! [rejected]** 원격 저장소에 있는 최신 커밋 정보가 저장되어 있지 않았음

→ 자신의 커밋을 푸시하기 전에 원격 저장소의 최신 커밋을 가져와야함

→ git pull 명령 먼저 사용 → 빔 실행 → 커밋 메시지 표시 → 편집기 종료 → git push

> 새로 만든 브랜치 푸시하기

```
$ git pull
$ git checkout -b (생성할 브랜치 이름)
```

**checkout -b** 옵션 → 브랜치를 만들고 체크아웃함

```
$ git push origin (브랜치 이름)
```

**origin** 원격 저장소에 푸시함

> 푸시한 브랜치 병합하기 pull request

원격 저장소 → branches → **New pull request** → 메시지 작성 → Create pull request

→ 원격 저장소 → Pull request → 등록한 풀 리퀘스트 클릭 → **Merge pull request** 

→ 커밋 메시지 입력 → Confirm merge → 푸시한 브랜치가 원격 저장소에 반영됨



